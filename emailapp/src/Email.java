import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Email {
    private final static double MAIL_BOX_CAPACITY = 1000;
    private final static int DEFAULT_PASSWORD_LENGTH = 8;
    private final static String DOMAIN = "company.com";

    private List<Message> messages;
    private final String firstName;
    private final String lastName;
    private final String email;
    private String password;
    private final double mailboxCapacity;
    private String department;
    private double freeMailboxSpace;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        messages = new ArrayList<>();

        this.department = setDepartment();
        mailboxCapacity = MAIL_BOX_CAPACITY;
        freeMailboxSpace = mailboxCapacity;
        this.password = generateRandomPassword();
        this.email = setEmail();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public void showMessages() {
        if (messages.size() == 0) {
            return;
        }

        System.out.println("Messages: ");
        for (int i = 0, messagesSize = messages.size(); i < messagesSize; i++) {
            Message m = messages.get(i);
            System.out.println((i+ 1) + " Title: " + m.getMessageName());
        }
    }

    public double getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.getFirstName() + this.getLastName();
    }

    public String getEmail() {
        return this.email;
    }

    public double getFreeMailboxSpace() {
        return this.freeMailboxSpace;
    }

    private String setDepartment() {
        System.out.println("Enter your department code:\n1 for Sales\n2 for Development\n3 for Accounting");

        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();

        return switch (departmentChoice) {
            case 1 -> "sales";
            case 2 -> "dev";
            case 3 -> "accounting";
            default -> "";
        };
    }

    /**
     * Generate random password with creation of email
     * @return random password using capital and lower letter, numbers from 0 to 9
     */
    private String generateRandomPassword() {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ1234567890abvcdefghjklmnopqrstuwxyz";
        char[] password = new char[Email.DEFAULT_PASSWORD_LENGTH];

        for (int i = 0; i < Email.DEFAULT_PASSWORD_LENGTH; i++) {
            int randomNumber = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomNumber);
        }

        return new String(password);
    }

    public String setEmail() {
        return firstName.toLowerCase()
                + "." + lastName.toLowerCase()
                + "@" + department + DOMAIN;
    }

    @Override
    public String toString() {
        return "Email {" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", mailboxCapacity=" + this.getMailboxCapacity() +
                ", department='" + this.getDepartment() + '\'' +
                "} ";
    }

    /**
     * Show user information for the email: full name, department, password and mail capacity
     */
    public void showInfo() {
        System.out.println("Name: " + this.getFullName()
                +"\nDepartment: " + this.getDepartment()
                + "\nPassword: " + this.getPassword()
                + "\nMailCapacity: " + this.getMailboxCapacity() + "mb");
    }

    public void save(Message message) {
        if (this.getEmail().equals(message.getSendTo().getEmail())) {
            addMessage(message);
        }
    }

    private void addMessage(Message message) {
        messages.add(message);
        this.freeMailboxSpace -= message.getContent().length() * 0.01;
    }
}
