import java.io.Serializable;

public class Customer  implements Serializable{
    private final String firstName;
    private final String lastName;
    private final String egn;
    private final Account account;

    Customer(String firstName, String lastName, String egn, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.account = account;
    }

    @Override
    public String toString(){
        return "\nCustomer Information\n" +
                "First Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() +  "\n" +
                "EGN: " + getEgn() +  "\n" +
                account;
    }

    public String basicInfo(){
        return " Account Number: " + account.getAccountNumber() + " - Name: " + getFirstName() + " " + getLastName();
    }

    Account getAccount(){
        return account;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the egn
     */
    public String getEgn() {
        return egn;
    }

}