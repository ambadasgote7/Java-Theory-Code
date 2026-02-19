import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(30);
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque.peekFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        
    }
}
