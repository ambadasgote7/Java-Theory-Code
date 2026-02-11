# Exception Handling
---

## What is an Exception?
- An exception is an object that represents an abnormal condition that occurs during program execution and disrupts the normal flow of instructions.
- It’s a runtime event that signals something went wrong.

```java 
int div = 10 / 0;
```
- It is a runtime error that is thrown when the program attempts to divide by zero.

**What Causes Exceptions?**
- Invalid user input
- File not found
- Database connection failure
- Dividing by zero
- Null reference access
- Array index out of bounds

---

## What is an Exception Handling?
- Exception handling is the process of responding to the runtime errors so that the program can continue to run.
- It is a way to handle the abnormal conditions that occur during program execution.

**Example:**
```java
int div = 10 / 0;
System.out.println("Hello");
```
If exception is not handled the second line of code will not be executed.

```java
try {
    int div = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Exception Occurred");
}
System.out.println("Hello");
```
Here the exception is handled and the exception message is printed and then the second line of code is executed.

---

## What is try-catch?
- try-catch is a structure used to handle the runtime errors so your program does not crash unexpectedly.

**What does try do?**
The try block contains code that might cause a problem.
```java
try {
    int result = 10 / 0;
}
```
**What does catch do?**
The catch block handles the error if it happens.
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

**Here’s what happens:**
- 10 / 0 causes an error.
- Java creates an ArithmeticException object.
- It jumps to the matching catch.
- The program continues instead of crashing.

**Why is try-catch used?**
Because in real applications:
- Files may not exist.
- Users may enter invalid input.
- Databases may fail.
- Null values may appear.

**Without try-catch**
```java
int result = 10 / 0;
System.out.println("Next line");
```
- Program stops immediately.

**With try-catch**
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Handled");
}
System.out.println("Next line");
```
- Now the program continues.

--- 

## Checked vs Unchecked Exceptions

### Checked Exceptions
- Checked exceptions are exceptions that are checked at compile time.

**That means:**
If your method can cause this exception, Java forces you to either:
- Handle it using try-catch
- Or declare it using throws
If you don’t → code won’t compile.

```java 
import java.io.*;

class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("test.txt");
    }
}

```
FileReader can throw IOException.
Compiler forces you to handle or declare it.

**Common Checked Exceptions**
- IOException
- SQLException
- ClassNotFoundException

**Rule**
If it does NOT extend RuntimeException, it is usually checked.

---

### Unchecked Exceptions
- Unchecked exceptions are exceptions that are not checked at compile time.
- They are thrown at runtime.
- Compiler does NOT force you to handle them.

```java
int a = 10 / 0;  // ArithmeticException
```
You are not forced to handle it.

**Common Unchecked Exceptions**
- NullPointerException
- ArithmeticException
- ArrayIndexOutOfBoundsException
- IllegalArgumentException

These extend RuntimeException.

--- 

### What is throws Keyword?
**throws** is used in a method declaration to indicate that the method may pass an exception to its caller instead of handling it.

- It does NOT handle the exception.
- It shifts responsibility.

```java
Syntax - returnType methodName() throws ExceptionType {
    // risky code
}
```

**Example (Checked Exception)**
```java
import java.io.*;

class Test {

    static void readFile() throws IOException {
        FileReader fr = new FileReader("test.txt");
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}
```
**Here’s what’s happening:**
- FileReader can throw IOException
- readFile() does NOT handle it
- So it declares throws IOException
- Responsibility moves to main
- main also declares it

This is called exception propagation.

**Important Points**

- 1️⃣ Used only with methods
You cannot use throws inside a block.

- 2️⃣ Mainly for checked exceptions
You are not forced to declare unchecked exceptions.

- 3️⃣ Multiple exceptions allowed
```java
void test() throws IOException, SQLException {
}
```

---

### What is throw?
**throw** is used to manually create and send an exception object.

**Syntax:**
throw new ExceptionType("message");

**Example**
```java
class Test {
    public static void main(String[] args) {
        int age = 16;

        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote");
        }

        System.out.println("Eligible");
    }
}
```
**What happens:**
- Condition true
- Exception object created
- Program stops immediately
- If no try-catch → program terminates

**Important Points**
- 1️⃣ throw is used inside method body
Not in method declaration.

- 2️⃣ You can throw:
- Checked exceptions
- Unchecked exceptions
- Custom exceptions

- 3️⃣ After throw, code below it does NOT execute

**Example:**
```java
throw new RuntimeException();
System.out.println("Hello");  // unreachable code
```
Compile-time error.

**When Do We Use throw?**
When we want to enforce business rules.

**Example:**
```java
if (balance < withdrawalAmount) {
    throw new IllegalArgumentException("Insufficient balance");
}
```
- This is not a system error.
- This is business logic validation.

**Professional systems use throw for:**
- Validation failures
- Invalid input
- Rule violations
- Security checks

```java 
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

    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);

        account.withdraw(6000);  // This will throw exception
    }
}
```
---

### What is finally?
**finally** is a block that executes after try-catch, whether an exception occurs or not.
- It is mainly used for cleanup work.

**Example**
If an exception occurs, the finally block is executed.
```java 
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error occurred");
} finally {
    System.out.println("Finally block executed");
}
```
If No Exception Occurs, the finally block is executed.
```java
try {
    System.out.println("Hello");
} catch (Exception e) {
    System.out.println("Error");
} finally {
    System.out.println("Finally executed");
}
```

**Why finally Exists**
Because some resources must always be closed:
- File connections
- Database connections
- Network connections
- Streams

**Example:**
```java
FileReader fr = null;

try {
    fr = new FileReader("test.txt");
} catch (IOException e) {
    System.out.println("Error reading file");
} finally {
    try {
        if (fr != null) {
            fr.close();
        }
    } catch (IOException e) {
        System.out.println("Error closing file");
    }
}
```
Even if reading fails, file is closed.

**Important Facts**

- 1️⃣ finally runs:
    - If exception occurs
    - If no exception occurs
    - Even if return is inside try or catch

- 2️⃣ finally does NOT run if:
    - System.exit() is called
    - JVM crashes

---

### 🔹 Try-With-Resources
**try-with-resources** is a special try statement used to automatically close resources after use.
- Introduced in Java 7.
- It removes the need for writing finally just to close things.

**Why It Exists**

Before Java 7, we had to manually close resources:
```java
FileReader fr = null;

try {
    fr = new FileReader("test.txt");
    System.out.println("File opened");
} catch (IOException e) {
    System.out.println("Error");
} finally {
    try {
        if (fr != null) {
            fr.close();
        }
    } catch (IOException e) {
        System.out.println("Error closing file");
    }
}
```
Messy. Nested try. Easy to forget close.

---

Clean Version Using Try-With-Resources
```java
import java.io.*;

class Test {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("test.txt")) {
            System.out.println("File opened");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

- No finally.
- File closes automatically.

**How It Works**
- Any object inside the try() must implement:
👉 AutoCloseable

**Important classes that implement it:**
- FileReader
- BufferedReader
- Scanner
- Connection
- PreparedStatement

**When try block ends:**
- **close()** is called automatically
- Even if exception occurs

**Multiple Resources**
```java
try (
    FileReader fr = new FileReader("test.txt");
    BufferedReader br = new BufferedReader(fr)
) {
    System.out.println(br.readLine());
} catch (IOException e) {
    System.out.println("Error");
}
```
Resources are closed in reverse order.

---
# Custom Exception in Java

## Overview

A Custom Exception is a user-defined exception created to represent specific business or application-level errors.

Instead of using generic exceptions like Exception or RuntimeException, we create meaningful exception types that clearly describe the problem.

---

## Why Use Custom Exceptions?

Using custom exceptions improves:

- Code readability
- Debugging clarity
- Business rule enforcement
- API design
- Layered architecture handling

Example:

Bad:
throw new Exception("Error");

Good:
throw new InsufficientBalanceException("Insufficient balance");

---

## Project Structure

BankAccount.java
InsufficientBalanceException.java

---

## Step 1: Create Custom Exception (Unchecked)

InsufficientBalanceException.java

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

Why extend RuntimeException?

- Business rule violations are usually unchecked
- No need to force caller to handle
- Cleaner service layer design

---

## Step 2: Use Custom Exception

BankAccount.java

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Available balance: " + balance + ", attempted withdrawal: " + amount
            );
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }

    public static void main(String[] args) {

        try {
            BankAccount account = new BankAccount(5000);
            account.withdraw(6000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}

---

## Output

Transaction failed: Available balance: 5000.0, attempted withdrawal: 6000.0

---

## Checked vs Unchecked Custom Exception

Unchecked:
extends RuntimeException
- Used for business validation failures
- Not mandatory to handle

Checked:
extends Exception
- Caller must handle or declare using throws
- Used when recovery is expected

---

## When to Use Custom Exceptions

Use for:
- Business rule violations
- Domain-specific errors
- Validation failures
- Application logic errors

Do NOT create custom exceptions for every small issue.
Use them when they add clarity.

---

## Interview Summary Statement

A custom exception is a user-defined exception class that extends Exception or RuntimeException to represent domain-specific errors in an application.
