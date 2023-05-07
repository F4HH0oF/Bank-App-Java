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
        return "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "egn: " + egn + "\n" +
                account;
    }

    public String basicInfo() {
        return "First Name: " + firstName +
                " Last Name: " + lastName +
                " egn: " + egn + " Account Number: " + account.getAccountNumber();
    }

    Account getAccount(){
        return account;
    }
}
