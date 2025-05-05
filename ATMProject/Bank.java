import java.util.ArrayList;
import java.util.List;

public class Bank {
    private AccountHolder holder;
    private Account account;
    private List<BankTransaction> transactions;

    public Bank(String userId, String userPin) {
        holder = new AccountHolder(userId, userPin);
        account = new Account();
        transactions = new ArrayList<>();
    }

    public boolean authenticate(String userId, String userPin) {
        return holder.getUserId().equals(userId) && holder.getUserPin().equals(userPin);
    }

    public void deposit(double amount) {
        account.deposit(amount);
        transactions.add(new BankTransaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (account.withdraw(amount)) {
            transactions.add(new BankTransaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public boolean transfer(Bank otherBank, double amount) {
        if (account.transfer(otherBank.account, amount)) {
            transactions.add(new BankTransaction("Transfer", amount));
            return true;
        }
        return false;
    }

    public void showTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (BankTransaction t : transactions) {
                System.out.println(t);
            }
        }
    }

    public double getBalance() {
        return account.getBalance();
    }
}