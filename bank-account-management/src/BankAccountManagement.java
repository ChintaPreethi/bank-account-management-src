import java.util.Scanner;

public class BankAccountManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     BANK ACCOUNT MANAGEMENT");
        System.out.println("=================================");

        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolder = sc.nextLine();

        double initialBalance;

        while (true) {

            System.out.print("Enter initial deposit: ₹");
            initialBalance = sc.nextDouble();

            if (initialBalance >= 0) {
                break;
            }

            System.out.println(
                    "Initial balance cannot be negative."
            );
        }

        BankAccount account = new BankAccount(
                accountNumber,
                accountHolder,
                initialBalance
        );

        int choice;

        do {

            System.out.println("\n========== BANK MENU ==========");
            System.out.println("1. Account Details");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.println("===============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.showAccountDetails();
                    break;

                case 2:
                    System.out.printf(
                            "Current Balance: ₹%.2f%n",
                            account.getBalance()
                    );
                    break;

                case 3:
                    System.out.print(
                            "Enter deposit amount: ₹"
                    );

                    double deposit = sc.nextDouble();

                    account.deposit(deposit);
                    break;

                case 4:
                    System.out.print(
                            "Enter withdrawal amount: ₹"
                    );

                    double withdraw = sc.nextDouble();

                    account.withdraw(withdraw);
                    break;

                case 5:
                    account.showTransactions();
                    break;

                case 6:
                    System.out.println(
                            "Thank you for using our banking system!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 6);

        sc.close();
    }
}