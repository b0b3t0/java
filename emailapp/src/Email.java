import java.util.Scanner;

public class Email {
    private final static int MAIL_BOX_CAPACITY = 1000;
    private final static int DEFAULT_PASSWORD_LENGTH = 8;
    private final static String DOMAIN = "company.com";

    private final String firstName;
    private final String lastName;
    private final String email;
    private String password;
    private final int mailboxCapacity;
    private String department;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        mailboxCapacity = MAIL_BOX_CAPACITY;
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

    public int getMailboxCapacity() {
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + getPassword() + '\'' +
                ", mailboxCapacity=" + getMailboxCapacity() +
                ", department='" + getDepartment() + '\'' +
                "} ";
    }

    /**
     * Show user information for the email: full name, department, password and mail capacity
     */
    public void showInfo() {
        System.out.println("Name: " + this.getFullName()
                +"\nDepartment: " + getDepartment()
                + "\nPassword: " + password
                + "\nMailCapacity: " + mailboxCapacity + "mb");
    }
}
