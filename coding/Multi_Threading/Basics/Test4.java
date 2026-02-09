
class Sample extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World Demo " + i);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
public class Test4 {
    public static void main(String[] args) {
        System.out.println("Main Thread Started");
        System.out.println(Thread.currentThread().getName());

        Thread thr = new Thread(new Sample(), "Sample");
        thr.start();
        
        // Lambda Expression
        Thread t = new Thread(() -> {
            // for (int i = 0; i < 5; i++) {
            //     System.out.println("Hello World " + i);
            // }
        });
        System.out.println(Thread.currentThread().getName());
        t.start();
        
        Runnable r = () -> {
            // for (int i = 0; i < 5; i++) {
            //     System.out.println("Hello World " + i);
            // }
        };
        Thread t2 = new Thread(r);
        System.out.println(t2.currentThread());
        t2.start();
        
        System.out.println("Main Thread Finished");
    }   
}
 
