
/*
The threads access the resources from the Cache.
If one thread modifies the value of shared resource it will be modified in the its own cache after some time it will update the in main memory.
SO the another thread will see the old value for some time.

Volatile Keyword -
     - If use use the volatile keyword then the the threads will access from the main memory.
*/
class Shared {
    // boolean flag = true;
    volatile boolean flag = true;
}
public class Test {
    public static void main(String[] args) {
        Shared s = new Shared();

        Thread t1 = new Thread(() -> {
            while (s.flag) {
            
            }
            System.out.println("Thread 1 is running");
        });

        Thread t2 = new Thread(() -> {
            try { Thread.sleep(10); } catch (Exception e) {}
            s.flag = false;
            System.out.println("Flag set to false");
        });
        t1.start();
        t2.start();
    }
}