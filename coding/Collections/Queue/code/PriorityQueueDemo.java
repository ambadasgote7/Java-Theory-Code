import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        queue.add(30);
        queue.add(10);
        queue.add(20);
        
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.size());

    }
}
