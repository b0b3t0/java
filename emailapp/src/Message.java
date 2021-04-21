import java.util.Objects;
import java.util.Scanner;

public class Message {

    private final String messageName;
    private final Email sendFrom;
    private final Email sendTo;
    private final String content;

    public Message(String messageName, Email sendFrom, Email sendTo) {
        this.messageName = messageName;
        this.sendFrom = sendFrom;
        this.sendTo = sendTo;
        this.content = writeMessage();
    }

    /**
     * We end message by pressing two times key Enter
     * @return value for the content field of the class
     */
    private String writeMessage() {
        StringBuilder message = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your message");
        String line = scanner.nextLine();

        while (!line.equals("")) {
            message.append(line);

            line = scanner.nextLine();
        }

        return message.toString();
    }

    public String getMessageName() {
        return this.messageName;
    }

    public Email getSendFrom() {
        return this.sendFrom;
    }

    public Email getSendTo() {
        return this.sendTo;
    }

    public String getContent() {
        return this.content;
    }

    public void showMessage() {
        System.out.println("Title: " + this.getMessageName());
        System.out.println("----------");
        System.out.println("send from: " + this.getSendFrom().getEmail());
        System.out.println("----------");
        System.out.println("send to: " + this.getSendTo().getEmail());
        System.out.println("----------");
        System.out.println("Message:");
        System.out.println(this.getContent());
        System.out.println("----------");
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(messageName, message.messageName)
                && Objects.equals(sendFrom, message.sendFrom)
                && Objects.equals(sendTo, message.sendTo)
                && Objects.equals(content, message.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageName, sendFrom, sendTo, content);
    }
}
