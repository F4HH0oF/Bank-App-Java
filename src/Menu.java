import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    //Instance variables
    Scanner keyboard = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exit = false;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("+---------------------------------+");
        System.out.println("|        Welcome to ZaBo's        |");
        System.out.println("|            Bank App             |");
        System.out.println("+---------------------------------+");
    }

    private void printMenu() {
        System.out.println("Make a selection: ");
        System.out.println("1) Create New Account");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a withdrawal");
        System.out.println("4) List account balance");
        System.out.println("0) Exit");
    }

    private int getInput() {
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only!");
            }

            if (choice < 0 || choice > 4) {
                System.out.println("Choice outside of range. Please, choose again!");
            }
        } while (choice < 0 || choice > 4);
        return choice;
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application!");
                System.exit(0);
                break;
            case 1:
                try {
                    createAccount();
                } catch (InvalidAccountTypeException e) {
                    System.out.println("Account was not created successfully!");
                }
                break;
            case 2:
                makeDeposit();
                break;
            case 3:
                makeWithdrawal();
                break;
            case 4:
                listBalances();
                break;
            default:
                System.out.println("Unknown error");
        }
    }

    private String askQuestion(String question, List<String> answers) {
        String response = "";
        Scanner input = new Scanner(System.in);
        boolean choices = (answers == null || answers.size() == 0) ? false : true;
        boolean firstRun = true;
        //If the answer is null (you don't have any required answers) it will run one time;
        //If it's not null, it means we've given it two options
        do {
            if (!firstRun) {
                System.out.println("Invalid selection. Please try again.");
            }
            System.out.print(question);
            if (choices) {
                System.out.print("(");
                for (int i = 0; i < answers.size() - 1; ++i) {
                    System.out.print(answers.get(i) + "/");
                }
                System.out.print(answers.get(answers.size() - 1));
                System.out.print(") ");
            }
            response = input.nextLine();
            firstRun = false;
            if (!choices) {
                break;
            }
        } while (!answers.contains(response));

        return response;

    }

    //Takes accountType and deposit amount. Keeps going until criteria is met
    private double getDeposit(String accountType) {
        double initialDeposit = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Please enter an initial deposit: ");
            try {
                initialDeposit = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Deposit must be a number!");
            }

            if (accountType.equalsIgnoreCase("checking")) {
                if (initialDeposit < 100) {
                    System.out.println("Checking account require a minimum of $100 to open!");
                } else {
                    valid = true;
                }
            } else if (accountType.equalsIgnoreCase("savings")) {
                if (initialDeposit < 50) {
                    System.out.println("Savings account require a minimum of $50 to open!");
                } else {
                    valid = true;
                }
            }
        }
        return initialDeposit;
    }

    private void createAccount() throws InvalidAccountTypeException {
        //Get account information
        String accountType = askQuestion("Please enter an account type: ", Arrays.asList("checking", "savings"));
        String firstName = askQuestion("Please enter your first name: ", null);
        String lastName = askQuestion("Please enter your last name: ", null);
        String egn = askQuestion("Please enter your egn: ", null);

        double initialDeposit = getDeposit(accountType);
        //An account can be created now
        Account account;
        if (accountType.equalsIgnoreCase("checking")) {
            account = new Checking(initialDeposit);
        } else if (accountType.equalsIgnoreCase("savings")) {
            account = new Savings(initialDeposit);
        } else {
            throw new InvalidAccountTypeException();
        }

        Customer customer = new Customer(firstName, lastName, egn, account);
        bank.addCustomer(customer);
    }


    private double getAmount(String question) {
        System.out.print(question);
        double amount = 0;
        try {
            amount = Double.parseDouble(keyboard.nextLine());
        } catch (NumberFormatException e) {
            amount = 0;
        }
        return amount;
    }

    private void makeDeposit() {
        int account = selectAccount();
        if (account >= 0) {
            double amount = getAmount("How much would you like to deposit?: ");
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private void makeWithdrawal() {
        int account = selectAccount();
        if (account >= 0) {
            double amount = getAmount("How much would you like to withdrawal?: ");
            bank.getCustomer(account).getAccount().withdrawal(amount);
        }
    }

    private void listBalances() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.println(bank.getCustomer(account).getAccount());
        }
    }


    private int selectAccount() {
        ArrayList<Customer> customers = bank.getCustomers();
        if (customers.size() <= 0) {
            System.out.println("No customers at your bank!");
            return -1;
        }
        System.out.println("Select an account: ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ") " + customers.get(i).basicInfo());
        }
        int account;
        System.out.print("Please enter your selection: ");
        try {
            account = Integer.parseInt(keyboard.nextLine()) - 1; // -1 because we want to print it from 1, and we do i+1
        } catch (NumberFormatException e) {
            account = -1;
        }
        if (account < 0 || account > customers.size()) {
            System.out.println("Invalid account selected!");
            account = -1;
        }
        return account;
    }
}
