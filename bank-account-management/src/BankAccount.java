import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    private ArrayList<String> transactions;

    public BankAccount(String accountNumber, String accountHolder,
                       double initialBalance) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;

        transactions = new ArrayList<>();

        transactions.add(
                "Account created with balance: ₹"
                        + String.format("%.2f", initialBalance)
        );
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;

        transactions.add(
                "Deposited: ₹"
                        + String.format("%.2f", amount)
        );

        System.out.println("Money deposited successfully.");
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;

        transactions.add(
                "Withdrawn: ₹"
                        + String.format("%.2f", amount)
        );

        System.out.println("Money withdrawn successfully.");
    }

    public void showAccountDetails() {

        System.out.println("\n========== ACCOUNT DETAILS ==========");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.printf("Balance        : ₹%.2f%n", balance);
        System.out.println("======================================");
    }

    public void showTransactions() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        for (String transaction : transactions) {
            System.out.println(transaction);
        }

        System.out.printf(
                "Current Balance: ₹%.2f%n",
                balance
        );

        System.out.println("=========================================");
    }
}