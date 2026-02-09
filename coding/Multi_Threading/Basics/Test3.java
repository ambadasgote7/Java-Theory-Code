
class Demo implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World Demo " + i);
        }
    }
}

class Demo2 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World Demo2 " + i);
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        System.out.println("Main Thread Started");
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World Main " + i);
        }
        Thread t = new Thread(new Demo());
        t.start();
        Thread t2 = new Thread(new Demo2());
        t2.setDaemon(true);
        t2.start();
        System.out.println("Main Thread Finished");
    }   
}
