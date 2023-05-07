public class Account {
    private double balance = 0;
    private double interest = 0.02;
    private int accountNumber;
    private static int numberOfAccounts = 100000;

    Account(){
        accountNumber = numberOfAccounts++;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest * 100;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void withdrawal(double amount){
        if(amount + 5 > balance){
            System.out.println("You have insufficient funds!");
            return;
        }
        checkInterest();
        balance -= amount + 5;
        System.out.println("You have withdrawn $" + amount + " and incurred a fee of $5");
        System.out.println("You now have a balance of $" + balance);
    }
    public void deposit(double amount){
        if(amount < 0){
            System.out.println("You cannot deposit negative money!");
            return;
        }
        checkInterest();
        amount += amount * interest;
        balance += amount;
        System.out.println("You have deposited $" + amount + " with an interest rate of " + (interest*100) + "%");
        System.out.println("You now have a balance of $" + balance);
    }

    public void checkInterest(){
        if(balance > 1000){
            interest = 0.05;
        }else{
            interest = 0.02;
        }
    }
}
