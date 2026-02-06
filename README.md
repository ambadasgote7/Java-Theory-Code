### Java Theory

----

## Object Oriented Programming (OOPs)

## Data-Hiding
Our internal data should not go to the outside world directly, 
that is outside person can't access our internal data directly is called **Data-Hiding**.

## Abstraction 
Hiding the internal implementation details, but exposing the set of services offered is technically called **Abstraction**.

## Encapsulation
Binding the data and the corresponding methods into a single unit is called **Encapsulation**.

## Getter and Setter
A getter is a method that returns the value of a property, and a setter is a method that sets the value of a property.

**Example :**
```java
public class BankAccount {
    private double balance;
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
```

1. Withdrawing the money from the ATM to understand the Data-Hiding, Abstraction.
![alt text](./imgaes/image.png)

2. Encapsulation of the Bank Account.
![alt text](./imgaes/image1.png)

----
