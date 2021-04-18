import java.util.Scanner;

public class Email {
    private final static int MAIL_BOX_CAPACITY = 1000;
    private final static int DEFAULT_PASSWORD_LENGTH = 8;

    private final String firstName;
    private final String lastName;
    private String password;
    private final int mailboxCapacity;
    private String department;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        mailboxCapacity = MAIL_BOX_CAPACITY;
        this.password = generateRandomPassword(DEFAULT_PASSWORD_LENGTH);
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
        System.out.println("Enter your department code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");

        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();
        String department = "";

        switch (departmentChoice) {
            case 1:
                department = "sales";
                break;
            case 2:
                department = "dev";
                break;
            case 3:
                department = "accounting";
                break;
            case 0:
                department = "";
                break;
        }

        return department;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    private String generateRandomPassword(int passwordLength) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ1234567890abvcdefghjklmnopqrstuwxyz";
        char[] password = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            int randomNumber = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomNumber);
        }

        return new String(password);
    }

    @Override
    public String toString() {
        return "Email {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", mailboxCapacity=" + mailboxCapacity +
                ", department='" + department + '\'' +
                "} ";
    }
}
