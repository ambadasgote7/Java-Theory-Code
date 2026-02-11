
class BankAccount {

    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class Test3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.withdraw(-1);  // This will throw exception
    }
}
