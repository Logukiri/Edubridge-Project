import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("user123", "1234");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        if (bank.authenticate(userId, userPin)) {
            int choice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Show Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        bank.showTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (bank.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        bank.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                        break;
                    case 4:
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        Bank other = new Bank("otherUser", "5678");
                        if (bank.transfer(other, transferAmount)) {
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Transfer failed.");
                        }
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Authentication failed.");
        }

        scanner.close();
    }
}