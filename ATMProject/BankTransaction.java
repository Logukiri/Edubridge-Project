import java.util.Date;

public class BankTransaction {
    private String type;
    private double amount;
    private Date date;

    public BankTransaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public String toString() {
        return date + " - " + type + ": $" + amount;
    }
}