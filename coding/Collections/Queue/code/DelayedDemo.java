import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedDemo {

    public static void main(String[] args) throws Exception {

        BlockingQueue<Submission> queue = new DelayQueue<>();

        Submission s1 =
                new Submission("Task1", 3000);

        Submission s2 =
                new Submission("Task2", 1000);

        queue.put(s1);
        queue.put(s2);

        System.out.println("Waiting to take...");

        while (!queue.isEmpty()) {
            System.out.println(queue.take());
        }
    }
}

class Submission implements Delayed {

    private String name;
    private long startTime;

    public Submission(String name, long delayMillis) {
        this.name = name;
        this.startTime =
                System.currentTimeMillis() + delayMillis;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        long remaining =
                startTime - System.currentTimeMillis();

        return unit.convert(remaining,
                TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {

        Submission o = (Submission) other;

        return Long.compare(this.startTime,
                            o.startTime);
    }

    @Override
    public String toString() {
        return "Executed: " + name +
               " at " + System.currentTimeMillis();
    }
}