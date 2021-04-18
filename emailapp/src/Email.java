public class Email {

    private final String firstName;
    private final String lastName;
    private String password;
    private final String department;
    private final int mailboxCapacity;

    public Email(String firstName, String lastName, String department, int mailboxCapacity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.mailboxCapacity = 10000;
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

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }


}
