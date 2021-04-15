public class Test {
    public static void main(String[] args) {
        Node root = new Node("+");
        root.setRightChild(new Node("6"));
        root.setLeftChild(new Node("2"));
        System.out.println(CalcTreeClass.calcTree(root));
    }
}
