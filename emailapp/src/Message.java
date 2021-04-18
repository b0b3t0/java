import java.util.Scanner;

public class Message {

    private final Email sendFrom;
    private final Email sendTo;
    private String content;

    public Message(Email sendFrom, Email sendTo) {
        this.sendFrom = sendFrom;
        this.sendTo = sendTo;
        this.content = writeMessage();
    }

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
        System.out.println("----------");
        System.out.println("send from: " + this.getSendFrom().getEmail());
        System.out.println("----------");
        System.out.println("send to: " + this.getSendTo().getEmail());
        System.out.println("----------");
        System.out.println("Message:");
        System.out.println(this.getContent());
        System.out.println("----------");
    }
}
