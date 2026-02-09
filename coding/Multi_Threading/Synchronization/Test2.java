
/*
Here two threads are using the same variable (count) to increment it.
As we used the synchronization block, the output will be always 2000.
Synchronization block ensures that only one thread can access the variable at a time.

Synchronization method -
    
*/
class Counter {
    int count = 0;
    synchronized void increment() {
        count++;
    }
}
public class Test2 {
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
