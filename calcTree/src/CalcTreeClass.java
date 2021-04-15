import java.util.LinkedList;
import java.util.List;

public class CalcTreeClass {

    private LinkedList<Node> nodes;
    private static final List<String> OPERATORS = List.of("+", "-", "*", "/");

    public CalcTreeClass() {
        nodes = new LinkedList<>();
    }

    /**
     * Checking if the value of current node is operator
     * @param node
     * @return
     */
    private static boolean isOperator(Node node) {
        return OPERATORS.contains(node.getValue());
    }

    /**
     * If the value of node is not operator we return
     * it's int value, other way we goo to the node's
     * children and repeat it.
     * @param root
     * @return
     */
    static int calcTree(Node root) {
        if(!isOperator(root)) {
            return root.getIntValue();
        }

        int leftSubTree = calcTree(root.getLeftChild());
        int rightSubTree = calcTree(root.getRightChild());

        return switch (root.getValue()) {
            case "+" -> leftSubTree + rightSubTree;
            case "-" -> leftSubTree - rightSubTree;
            case "/" -> leftSubTree / rightSubTree;
            case "*" -> leftSubTree * rightSubTree;
            default -> throw new RuntimeException("unsupported operator");
        };
    }
}
