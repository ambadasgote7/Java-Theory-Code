import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue {
    private Queue<Integer> q = new LinkedList<>();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void add(int item) {
        synchronized (q) {
            while (q.size() == capacity) {
                System.out.println("Queue full. Producer waiting...");
                try {
                    q.wait();
                } catch (Exception e) {}
            }

            q.add(item);
            System.out.println("Produced: " + item);

            q.notifyAll();
        }
    }

    public int remove() {
        synchronized (q) {
            while (q.isEmpty()) {
                System.out.println("Queue empty. Consumer waiting...");
                try {
                    q.wait();
                } catch (Exception e) {}
            }

            int item = q.remove();
            System.out.println("Consumed: " + item);

            q.notifyAll();
            return item;
        }
    }
}

public class Test2 {
    public static void main(String[] args) {

        BlockingQueue queue = new BlockingQueue(1);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                queue.add(i);
                try { Thread.sleep(500); } catch (Exception e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            try { Thread.sleep(2000); } catch (Exception e) {}
            for (int i = 1; i <= 3; i++) {
                queue.remove();
                try { Thread.sleep(1000); } catch (Exception e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
