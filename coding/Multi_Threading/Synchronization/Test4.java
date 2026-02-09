  
  /*
  Static Synchronization -
      - Lock is taken on Class object (Counter.class)
      - Equivalent to synchronized(Counter.class)
        void increment() {
            synchronized(Counter.class) {
                count++;
            }
        }
  */
class Counter {
    static int count = 0;
    static synchronized void increment() {
        count++;
    }
}

public class Test4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) Counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) Counter.increment();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
        System.out.println("Final Count: " + Counter.count);
    }
}

