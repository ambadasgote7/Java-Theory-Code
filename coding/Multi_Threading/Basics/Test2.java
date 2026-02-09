class ThreadDemo1 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World " + i);
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        System.out.println("Main Thread Started");
        Thread t = new Thread(new ThreadDemo1());
        t.start();
        System.out.println("Main Thread Finished");
    }
}
