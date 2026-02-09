package coding.Multi_Threading.Synchronization;
/*
Here two threads are using the same variable (count) to increment it.
 both Threads modifies it in the same time if we not use the synchronization.
 Add the output will be unpredictable.
*/
class Counter {
    int count = 0;
    void increment() {
        count++;
    }
}
public class Test {
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




