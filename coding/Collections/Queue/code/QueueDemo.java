import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue.remove());
        queue.clear();
        System.out.println(queue.poll());
        // System.out.println(queue.remove()); // java.util.NoSuchElementException
        
    }
}
