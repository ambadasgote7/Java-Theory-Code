
/*
Synchronization block -
     - Lock only critical section
     - Better performance control
     - Lock should be taken on the same object if not then it will not work as expected.
     - we can give synchronized(this) to lock on the same object but it be called by same instance of the object.
       like Counter c = new Counter(); both threads must call c.increment() to increment the count.
       if two different objects then no synchronization between them.
    - It is recommended to use final keyword for lock object so that it can not be reassigned.
    - Making it private will prevent external interference.
*/

class Counter {
    int count = 0;
    private final Object lock = new Object();
    void increment() {
        synchronized (lock) {
            count++;
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
        System.out.println("Final Count: " + c.count);
    }
}
