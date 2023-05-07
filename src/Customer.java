public class Customer {
    private final String firstName;
    private final String lastName;
    private final Account account;
    private final String egn;

    public Customer(String firstName, String lastName, String egn, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.account = account;
    }

    @Override
    public String toString() {
        return "\nCustomer information\n" +
                "First Name: " + firstName +
                "Last Name: " + lastName +
                "egn: " + egn +
                account;
    }
}
