
class ThreadDemo extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World " + i);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println("Main Thread Started");
       
        Thread t = new ThreadDemo();
        t.start();  
        System.out.println("Main Thread Finished");
    }
}