// Account class for understanding the OOPS data-hiding, abstraction, encapsulation
class Account {

   private double balance; // this is the internal data to avoid the outside world to access it directly we make it private

   // as the account is of a person he can able to withdraw his money so we make the method public allow him to withdraw the money after authenticating the person
  public double getBalance() {
    // perform the authentication of the person
    if (validate("1234")) {
       return this.balance;
    } else {
       System.out.println("Invalid PIN");
       return 0;
    }
   }

   // this is for depositing the money to the account
   public void setBalance(double balance) {
     // perform the authentication of the person
     if (validate("1234")) {
        this.balance = balance;
     } else {
        System.out.println("Invalid PIN");
     }
   }

   // this method is used to validate the person and it is used within the same class to made the method private
   private boolean validate(String pin) {
      return pin.equals("1234");
   }

}

public class TestApp {
    public static void main(String[] args) {
        Account acc = new Account();
        acc.setBalance(1000);
        System.out.println("Balance : " + acc.getBalance());
    }
}