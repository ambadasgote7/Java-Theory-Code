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
## Notes :

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

# Java Volatile Keyword 

## 1️⃣ Problem – Visibility Issue

In multithreading, each thread may use its own CPU cache.

So:
- Thread A updates a variable.
- Thread B may still see the old value.
- Because B reads from its cached copy.

This is called **memory visibility problem**.

---

## 2️⃣ Example Without volatile

```java
class Shared {
    boolean flag = true;
}

public class Test {
    public static void main(String[] args) {

        Shared s = new Shared();

        Thread t1 = new Thread(() -> {
            while (s.flag) {
                // infinite loop possible
            }
            System.out.println("Stopped");
        });

        Thread t2 = new Thread(() -> {
            try { Thread.sleep(10); } catch (Exception e) {}
            s.flag = false;
        });

        t1.start();
        t2.start();
    }
}
```

Problem:
`t1` may never stop because it may not see updated value.

---

## 3️⃣ Fix Using volatile

```java
class Shared {
    volatile boolean flag = true;
}
```

Now:
- Write goes directly to main memory.
- Read always comes from main memory.
- All threads see updated value immediately.

---

## 4️⃣ What volatile Guarantees

✔ Visibility  
✔ Prevents instruction reordering  

---

## 5️⃣ What volatile Does NOT Guarantee

❌ Atomicity  

Example:

```java
volatile int count = 0;
count++;   // NOT thread-safe
```

Because `count++` = Read → Add → Write (3 steps)

---

## 6️⃣ When To Use volatile

- Status flag
- Stop signal
- One thread writes, others read

---

## 🎯 Interview Definition

> Volatile ensures visibility of shared variables across threads but does not provide atomicity.

---

# Producer–Consumer Problem (Java Multithreading Notes)

---

# 1️⃣ Problem Statement

Two types of threads:

- **Producer** → produces data
- **Consumer** → consumes data

Both share a common resource (Buffer / Queue).

Problems:
- If buffer is **full** → producer must wait
- If buffer is **empty** → consumer must wait

This requires **inter-thread communication**.

---

# 2️⃣ Key Methods Used

| Method | Purpose |
|--------|----------|
| `wait()` | Makes thread release lock and go to WAITING state |
| `notify()` | Wakes one waiting thread |
| `notifyAll()` | Wakes all waiting threads |

Important Rules:
- Must be called inside `synchronized` block
- `wait()` releases the lock
- After notification, thread must reacquire lock

---

# 3️⃣ Simple Blocking Queue Implementation

```java
import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue {

    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void add(int item) {
        synchronized (queue) {

            while (queue.size() == capacity) {
                try {
                    queue.wait();   // wait if full
                } catch (Exception e) {}
            }

            queue.add(item);
            System.out.println("Produced: " + item);

            queue.notifyAll();   // notify consumers
        }
    }

    public int remove() {
        synchronized (queue) {

            while (queue.isEmpty()) {
                try {
                    queue.wait();   // wait if empty
                } catch (Exception e) {}
            }

            int item = queue.remove();
            System.out.println("Consumed: " + item);

            queue.notifyAll();   // notify producers
            return item;
        }
    }
}

public class Test {
    public static void main(String[] args) {

        BlockingQueue queue = new BlockingQueue(1);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                queue.add(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                queue.remove();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

# 4️⃣ Why Use `while` Instead of `if`?

Because of **Spurious Wakeups**.

Correct pattern:

```
while(condition) {
    wait();
}
```

Never use:

```
if(condition) {
    wait();
}
```

---

# 5️⃣ Thread States Involved

When producer/consumer calls `wait()`:

```
RUNNABLE → WAITING
```

After `notify()`:

```
WAITING → BLOCKED → RUNNABLE
```

---

# 6️⃣ Important Concepts

- `wait()` releases the lock.
- `notify()` does NOT release the lock immediately.
- The awakened thread must reacquire the monitor lock.
- Always use `notifyAll()` in real-world producer-consumer cases.

---

# 7️⃣ Interview Key Points

- Demonstrates inter-thread communication.
- Uses intrinsic locks (monitor lock).
- Avoid busy-waiting.
- Always guard `wait()` with `while`.
- Deadlock can occur if locking strategy is wrong.

---

# 🎯 Interview Definition

> The Producer–Consumer problem is a classic multithreading problem that demonstrates inter-thread communication using wait() and notify() to coordinate access to shared resources.

---
# Java Thread States and Transitions (Interview Notes)

---

# 1️⃣ Thread Life Cycle in Java

A thread in Java goes through the following states:

- NEW  
- RUNNABLE  
- BLOCKED  
- WAITING  
- TIMED_WAITING  
- TERMINATED  

You can check thread state using:

```java
Thread.State
```

---

# 2️⃣ NEW

Thread is created but not started.

```java
Thread t = new Thread();
System.out.println(t.getState());  // NEW
```

---

# 3️⃣ RUNNABLE

After calling:

```java
t.start();
```

Thread enters RUNNABLE state.

Important:
- RUNNABLE means ready to run.
- Java does NOT separate READY and RUNNING.
- Thread scheduler decides execution.

---

# 4️⃣ BLOCKED

Thread is waiting to acquire a monitor lock.

Example:

```java
synchronized(lock) {
    // If another thread holds lock,
    // current thread becomes BLOCKED
}
```

State: BLOCKED

---

# 5️⃣ WAITING

Thread waits indefinitely until another thread wakes it.

Caused by:

```java
wait()
join()
```

State: WAITING

---

# 6️⃣ TIMED_WAITING

Thread waits for a specific amount of time.

Caused by:

```java
Thread.sleep(1000)
wait(1000)
join(1000)
```

State: TIMED_WAITING

After timeout → returns to RUNNABLE.

---

# 7️⃣ TERMINATED

Thread has completed execution.

After `run()` method finishes.

A terminated thread cannot be restarted.

---

# 8️⃣ Example Showing State Changes

```java
public class Test {
    public static void main(String[] args) throws Exception {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        });

        System.out.println(t.getState());  // NEW

        t.start();
        System.out.println(t.getState());  // RUNNABLE

        Thread.sleep(100);
        System.out.println(t.getState());  // TIMED_WAITING

        t.join();
        System.out.println(t.getState());  // TERMINATED
    }
}
```

---

# 9️⃣ State Transition Flow

```
NEW → start() → RUNNABLE
RUNNABLE → lock unavailable → BLOCKED
RUNNABLE → wait() → WAITING
RUNNABLE → sleep() → TIMED_WAITING
RUNNABLE → run() completes → TERMINATED
```

---

# 🔟 Important Differences

| State | Reason |
|--------|--------|
| BLOCKED | Waiting for monitor lock |
| WAITING | Waiting for notify() or join() |
| TIMED_WAITING | Waiting for specific time |
| RUNNABLE | Ready or running |

---

# 1️⃣1️⃣ Interview Key Points

- Java does not have separate RUNNING state.
- `wait()` → WAITING state.
- `sleep()` → TIMED_WAITING state.
- Lock contention → BLOCKED state.
- Thread cannot restart after TERMINATED.

---

# 🎯 Interview Definition

> A thread in Java transitions through NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, and TERMINATED states depending on its execution flow and synchronization behavior.

---

# Running and Yielding of a Thread (Java Notes)

---

# 1️⃣ RUNNABLE State

In Java, there is no separate RUNNING state.

When a thread is:

- Ready to run
- Or currently executing

It is in:

```
RUNNABLE
```

The **Thread Scheduler** decides which thread runs.

---

# 2️⃣ Thread Scheduler

- Part of JVM
- Chooses which thread executes
- Behavior is OS dependent
- No guaranteed order

---

# 3️⃣ Thread.yield()

`yield()` is a static method:

```java
Thread.yield();
```

It means:

> "I am willing to give up CPU. Let other threads run."

---

# 4️⃣ Important About yield()

- It does NOT guarantee context switch.
- It is just a suggestion to scheduler.
- Thread remains in RUNNABLE state.
- It does NOT release locks.

---

# 5️⃣ Example

```java
public class Test {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1");
                Thread.yield();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2");
            }
        });

        t1.start();
        t2.start();
    }
}
```

Output is unpredictable.

yield() may or may not switch execution.

---

# 6️⃣ yield() vs sleep()

| yield() | sleep() |
|----------|---------|
| Suggests scheduler | Forces delay |
| No time parameter | Requires time |
| Does not release lock | Does not release lock |
| May do nothing | Always pauses thread |

---

# 7️⃣ Interview Points

- yield() is a hint, not a command.
- Thread remains RUNNABLE.
- No guarantee of execution order.
- Rarely used in real applications.

---

# 🎯 Interview Definition

> Thread.yield() is a static method that hints the scheduler to pause the current thread and allow other threads of equal priority to execute, but it provides no guarantee of context switching.

---

# Thread Sleep and Wake-Up (Java Notes)

---

# 1️⃣ Thread.sleep()

`Thread.sleep()` pauses the current thread for a specified time.

Syntax:

```java
Thread.sleep(milliseconds);
```

Example:

```java
public class Test {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
                System.out.println("Sleeping...");
                Thread.sleep(2000);
                System.out.println("Woke up!");
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        });

        t.start();
    }
}
```

---

# 2️⃣ What Happens Internally?

When `sleep()` is called:

- Thread enters `TIMED_WAITING` state
- Thread pauses execution
- After time expires → returns to `RUNNABLE`

---

# 3️⃣ Important Points

- `sleep()` is static method.
- It affects the current thread.
- It does NOT release any locks.
- It throws `InterruptedException`.

---

# 4️⃣ Sleep vs Wait

| sleep() | wait() |
|----------|---------|
| Belongs to Thread class | Belongs to Object class |
| Does NOT release lock | Releases lock |
| Used for delay | Used for inter-thread communication |
| Goes to TIMED_WAITING | Goes to WAITING |

---

# 5️⃣ Can Sleep Be Interrupted?

Yes.

If another thread calls:

```java
thread.interrupt();
```

Then:

- Sleeping thread throws `InterruptedException`.

---

# 6️⃣ Example of Interrupting Sleep

```java
public class Test {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted!");
            }
        });

        t.start();
        t.interrupt();
    }
}
```

---

# 🎯 Interview Definition

> Thread.sleep() pauses the current thread for a specified time without releasing any locks and moves it to TIMED_WAITING state.

---

# Java Multithreading – Remaining Core Concepts (Interview Guide)

---

# 1️⃣ Waiting and Notifying

## wait()

- Belongs to Object class
- Must be called inside synchronized block
- Releases the lock
- Moves thread to WAITING state

## notify()

- Wakes one waiting thread
- Does NOT release lock immediately

## notifyAll()

- Wakes all waiting threads

Example:

```java
synchronized(obj) {
    while(condition) {
        obj.wait();
    }
    obj.notifyAll();
}
```

---

# 2️⃣ Thread Timed Waiting

Thread enters TIMED_WAITING when:

- Thread.sleep(time)
- wait(time)
- join(time)

After timeout:
Thread moves back to RUNNABLE.

---

# 3️⃣ Interruption of a Thread

## interrupt()

```java
t.interrupt();
```

- Does NOT force stop thread
- Sets interrupt flag
- If sleeping/waiting → throws InterruptedException
- If running normally → flag is set

Check interrupt flag:

```java
Thread.currentThread().isInterrupted();
```

---

# 4️⃣ Thread Joining

## join()

```java
t.join();
```

- Current thread waits until t finishes
- Moves to WAITING state
- Ensures completion
- Does NOT fix race conditions

Timed join:

```java
t.join(1000);
```

Moves thread to TIMED_WAITING.

---

# 5️⃣ Thread Priority

Range: 1 – 10

Constants:

```java
Thread.MIN_PRIORITY  // 1
Thread.NORM_PRIORITY // 5
Thread.MAX_PRIORITY  // 10
```

Set priority:

```java
t.setPriority(10);
```

Important:
- Only a suggestion
- Scheduler may ignore
- OS dependent

---

# 6️⃣ Thread Scheduler

- Part of JVM
- Chooses which thread executes
- No guaranteed order
- Uses time slicing
- Behavior depends on OS

Java has no direct control over scheduler.

---

# 7️⃣ Deadlocks

Deadlock happens when:

- Two or more threads hold locks
- Each waits for the other’s lock
- Circular dependency
- Program freezes

Conditions for Deadlock:
1. Mutual exclusion
2. Hold and wait
3. No preemption
4. Circular wait

---

# 8️⃣ Creating a Deadlock (Example)

```java
public class Test {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (String.class) {
                System.out.println("T1 locked String");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (Integer.class) {
                    System.out.println("T1 locked Integer");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (Integer.class) {
                System.out.println("T2 locked Integer");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (String.class) {
                    System.out.println("T2 locked String");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

Result:
Program hangs due to deadlock.

---

# 9️⃣ Avoiding Deadlock

✔ Always acquire locks in same order  
✔ Use tryLock (ReentrantLock)  
✔ Avoid nested locking when possible  

---

# 🔟 Complete Thread State Flow

```
NEW → start() → RUNNABLE
RUNNABLE → sleep() → TIMED_WAITING
RUNNABLE → wait() → WAITING
RUNNABLE → waiting for lock → BLOCKED
RUNNABLE → run() ends → TERMINATED
```

---

# 🎯 Interview Rapid-Fire Summary

- sleep() → TIMED_WAITING (no lock release)
- wait() → WAITING (releases lock)
- join() → WAITING
- interrupt() → sets flag / throws exception
- yield() → hint to scheduler
- synchronized → mutual exclusion
- volatile → visibility only
- Deadlock → circular waiting

---

# Final Interview Definition

> Java multithreading provides mechanisms like synchronization, volatile variables, wait/notify, thread priorities, and scheduling to manage concurrent execution while preventing race conditions and deadlocks.

---




