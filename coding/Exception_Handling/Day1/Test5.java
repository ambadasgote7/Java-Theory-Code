
class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class AmountMustBePositiveException extends RuntimeException {

    public AmountMustBePositiveException(String message) {
        super(message);
    }
}

class Bank {
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new AmountMustBePositiveException("Withdraw amount must be positive");
        } 
        if (amount > balance) {
            throw new InsufficientBalanceException("Balance is " + balance + " but you are trying to withdraw " + amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}
public class Test5 {
    public static void main(String[] args) {
        Bank bank = new Bank(1000);
        bank.withdraw(-20); 
    }
}
