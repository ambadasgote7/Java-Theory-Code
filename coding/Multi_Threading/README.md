### Multi-Threading

----

### Basics

## What is a CPU ?
- CPU is a central processing unit.
- All the processing is done by CPU.
- It performs Arithmetic Logic Unit (ALU) operations, control flow, and memory coordination

## What is a core ?
- A core is an independent execution unit inside a CPU.
- Who is responsible for executing the instructions.
- One core can execute only one instruction at a time.
- Multiple cores can execute multiple instructions at a time.

## What is a Program ?
- Program is a set of instructions.

## What is a Process ?
- A process is a program in execution.
- Processes are heavyweight and isolated from each other.
- It has:
    - Own memory (heap)
    - Own address space
    - System resources (files, network sockets)

## What is a Thread ?
- A thread is the smallest unit of execution inside a process.
- Multiple threads share:
    - Same heap memory
    - Same process resources
- But each thread has:
    - Own stack
    - Own program counter

---

## What is multi-tasking ?
- Multi-tasking is the ability of a computer to perform more than one task at a time.
- Ways of multi-tasking:
    - Process Based Multi-tasking
    - Thread Based Multi-tasking
    
**Process Based Multi-tasking :**
- Multiple processes run simultaneously.
- Each process has its own memory.
- They are isolated from each other.
- eg : Chrome runnig, VSCode running, etc.

**Thread Based Multi-tasking :**
- Multiple threads run simultaneously.
- Threads share the same memory and resources.
- eg : Chrome is Process where multiple tabs are Threads.

---

## Creating a Thread
- We can create a thread by extending the Thread class.
- We can create a thread by implementing the Runnable interface.

**Thread Class :**
- Thread class is the base class for all thread implementations.

```java
class ThreadDemo extends Thread {
    public void run() {
        System.out.println("Hello World");
    }
}
public class Test {
    public static void main(String[] args) {
        Thread t = new ThreadDemo();
        t.start();
    }
}
```

**Runnable Interface :**
- Runnable interface is the base interface for all thread implementations.
```java
class RunnableDemo implements Runnable {
    public void run() {
        System.out.println("Hello World");
    }
}
public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableDemo());
        t.start();
    }
}
```
**Notes :**

---

# 1️⃣ Why do we call `start()` instead of `run()`?

This is one of the most frequently asked interview questions.

## What happens when you call `start()`?

```java
t.start();
```

When `start()` is called, the JVM:

- Creates a new thread in memory  
- Registers it with the Thread Scheduler  
- Allocates a new call stack  
- Then internally calls the `run()` method  

### Flow:

```
start() → creates new thread → JVM calls run() on that new thread
```

---

## What happens if you call `run()` directly?

```java
t.run();
```

- No new thread is created  
- Executes like a normal method call  
- Runs in the main thread  
- No concurrency  
- No parallel execution  

Calling `run()` directly does NOT create multithreading.

---

## Interview Answer (Difference Between start() and run())

- `start()` creates a new thread and then invokes `run()` internally.
- `run()` behaves like a normal method if called directly.
- `start()` involves thread scheduler and new call stack allocation.
- `run()` does not create a new execution path.

---

# 2️⃣ Why do we pass a Runnable object to Thread constructor?

```java
Thread t = new Thread(new RunnableDemo());
```

## Concept:

- Runnable = Task (What to execute)
- Thread = Worker (Who executes it)

This follows the **Separation of Concern** principle.

---

## Why not always extend Thread?

Java does not support multiple inheritance.

If you extend Thread:

```java
class MyClass extends Thread
```

You cannot extend any other class.

But with Runnable:

```java
class MyClass extends SomeOtherClass implements Runnable
```

You can extend another class and still define a thread task.

---

## Why Runnable is Preferred (Interview Answer)

- Better object-oriented design
- Supports multiple inheritance of type
- Separates task from execution
- More reusable in large-scale applications
- Cleaner architecture

---

# 3️⃣ Important Interview Notes

## ✅ Thread Lifecycle

- New
- Runnable
- Running
- Blocked / Waiting
- Terminated

---

## ✅ Thread Scheduler

- Controlled by JVM
- Execution order is not guaranteed
- OS dependent
- Uses time slicing and priority mechanisms

---

## ✅ Is `start()` overridable?

- Yes, it is overridable.
- Not recommended unless absolutely necessary.
- Always call `super.start()` if overridden.

---

## ✅ Can we start a thread twice?

```java
t.start();
t.start();  // ❌ IllegalThreadStateException
```

- A thread can be started only once.
- Restarting a thread throws `IllegalThreadStateException`.

---

## User Threads and Daemon Threads
---

# 1️⃣ User Thread

## Definition:
A **User Thread** is a normal thread that performs application-level tasks.

## Key Points:
- Created by default when you create a thread.
- JVM waits for user threads to finish before terminating.
- Performs main application work.
- If user threads are running, JVM will NOT exit.

## Example:
```java
class UserThreadDemo extends Thread {
    public void run() {
        System.out.println("User Thread Running");
    }
}

public class Test {
    public static void main(String[] args) {
        UserThreadDemo t = new UserThreadDemo();
        t.start();
    }
}
```

---

# 2️⃣ Daemon Thread

## Definition:
A **Daemon Thread** is a background service thread that supports user threads.

## Key Points:
- Runs in background.
- JVM does NOT wait for daemon threads to finish.
- Automatically terminates when all user threads finish.
- Used for background tasks (e.g., garbage collection).

---

## How to Create a Daemon Thread

```java
class DaemonThreadDemo extends Thread {
    public void run() {
        System.out.println("Daemon Thread Running");
    }
}

public class Test {
    public static void main(String[] args) {
        DaemonThreadDemo t = new DaemonThreadDemo();
        t.setDaemon(true);  // Must be called before start()
        t.start();
    }
}
```

---

# Important Rules (Interview Critical)

- `setDaemon(true)` must be called **before** `start()`.
- If called after `start()`, it throws `IllegalThreadStateException`.
- Main thread is always a **User Thread**.
- Garbage Collector runs as a **Daemon Thread**.
- A daemon thread cannot prevent JVM shutdown.

---

# Difference Between User Thread and Daemon Thread

| Feature | User Thread | Daemon Thread |
|----------|-------------|---------------|
| JVM waits to finish? | Yes | No |
| Purpose | Application logic | Background support |
| Default type | Yes | No |
| JVM Exit Condition | JVM exits after all user threads finish | JVM may exit even if daemon thread is running |

---

# Interview Trap Question

## Q: What happens if only daemon threads are left running?

Answer:
- JVM terminates immediately.
- Daemon threads are stopped automatically.
- No guarantee of execution completion.

---

# Real-World Examples

- User Thread → Handling client requests
- Daemon Thread → Garbage Collector, background logging, monitoring

---

### Synchronization, Static Locking & Deadlock 

---

# 1️⃣ Why Synchronization Is Needed

When multiple threads access **shared mutable data**, race conditions can occur.

Example without synchronization:

```java
class Counter {
    int count = 0;

    void increment() {
        count++;   // NOT atomic
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + c.count);
    }
}
```

Expected: `2000`  
Actual: unpredictable (race condition)

---

# 2️⃣ Synchronized Method

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

- Lock is taken on `this` (current object)
- Only one thread can execute at a time
- Output will always be `2000`

---

# 3️⃣ Synchronized Block

```java
class Counter {
    int count = 0;
    private final Object lock = new Object();

    void increment() {
        synchronized (lock) {
            count++;
        }
    }
}
```

### Why use block?
- Lock only critical section
- Better performance control

### Best Practice:
```java
private final Object lock = new Object();
```

- `private` → prevent external interference
- `final` → prevent reassignment
- `static` → only if class-level lock needed

---

# 4️⃣ synchronized(this)

```java
void increment() {
    synchronized(this) {
        count++;
    }
}
```

Works only if:
- All threads use the SAME object instance.

Example:

```java
Counter c = new Counter();
```

Both threads must call `c.increment()`.

If two different objects:
```java
Counter c1 = new Counter();
Counter c2 = new Counter();
```

No synchronization between them.

---

# 5️⃣ Static Synchronization

```java
class Counter {
    static int count = 0;

    static synchronized void increment() {
        count++;
    }
}
```

Lock is taken on:
```
Counter.class
```

Equivalent to:

```java
synchronized(Counter.class) {
    count++;
}
```

Used when:
- Shared static data
- Need class-level locking

---

# 6️⃣ Important Difference

| Type | Lock Taken On |
|------|---------------|
| synchronized method | this (object) |
| static synchronized method | Class object |
| synchronized(lock) | Custom object |

---

# 7️⃣ Reentrant Locking

Java intrinsic locks are **reentrant**.

If a thread already holds a lock,
it can acquire it again without blocking.

Example:

```java
synchronized (Counter.class) {
    synchronized (Counter.class) {
        // Allowed (same thread)
    }
}
```

---

# 8️⃣ Blocking Example

```java
class Demo {
    static void method() {
        synchronized (Demo.class) {
            try { Thread.sleep(5000); } catch (Exception e) {}
        }
    }
}
```

If one thread enters:
- Other threads wait until lock is released.

---

# 9️⃣ Deadlock Example (Important for Interview)

Deadlock requires:
- Two locks
- Opposite acquisition order

```java
public class Test {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (Counter.class) {
                System.out.println("T1 locked Counter");
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (Counter2.class) {
                    System.out.println("T1 locked Counter2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (Counter2.class) {
                System.out.println("T2 locked Counter2");
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (Counter.class) {
                    System.out.println("T2 locked Counter");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class Counter {}
class Counter2 {}
```

### What Happens?
Possible output:
```
T1 locked Counter
T2 locked Counter2
```

Then program hangs forever.

Reason:
- T1 waiting for Counter2.class
- T2 waiting for Counter.class
- Circular waiting → Deadlock

---

# 🔟 Avoiding Deadlock

Always lock in SAME order.

Correct pattern:

```
Counter.class → Counter2.class
```

If both threads follow same order:
No deadlock.

---

# 1️⃣1️⃣ Interrupt Concept (Important)

`interrupt()` does NOT stop a thread.

- If thread is sleeping/waiting → `InterruptedException`
- If running normally → interrupt flag set

Check using:

```java
Thread.currentThread().isInterrupted();
```

---

# 1️⃣2️⃣ join()

```java
t1.join();
```

Main thread waits until `t1` finishes.

- Ensures completion
- Does NOT fix race condition

---

# 🔥 Interview Key Points

- Race condition happens due to non-atomic operations.
- Synchronization ensures mutual exclusion.
- Lock object determines synchronization, not variable.
- Static synchronized locks class object.
- Deadlock requires multiple locks with circular dependency.
- Java locks are reentrant.
- join() ensures completion, not correctness.
- interrupt() sends signal, does not kill thread.

---

# 🎯 One-Line Interview Definition

> Synchronization is a mechanism that controls access to shared resources in a multithreaded environment by allowing only one thread at a time to execute critical sections.

---
