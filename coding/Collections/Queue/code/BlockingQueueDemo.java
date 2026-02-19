import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.Random;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        // BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // Thread t1 = new Thread(new Producer(queue));
        // Thread t2 = new Thread(new Consumer(queue));
        // t1.start();
        // t2.start();

        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Consumer(queue));
        t1.start();
        t2.start();

        // BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        // Thread t1 = new Thread(new Producer(queue));
        // Thread t2 = new Thread(new Consumer(queue));
        // t1.start(); 
        // t2.start();
    }
}

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private Random random = new Random();

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                int value = random.nextInt(100);
                System.out.println("Producer: " + value);
                queue.put(value);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int value;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer: " + queue.take());
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }	
}