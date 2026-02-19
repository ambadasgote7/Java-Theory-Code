import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DequeDemo2 {
    public static void main(String[] args) {
        // ArrayDeque<Integer> deque = new ArrayDeque<>();
        // deque.addFirst(10);
        // deque.addLast(20);
        // deque.offerFirst(5);
        // deque.offerLast(3);
        // System.out.println(deque);
        // System.out.println(deque.pollFirst());
        // System.out.println(deque.peekFirst());
        // System.out.println(deque.removeFirst());
        // System.out.println(deque.size());

        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(10);
        // deque.addLast(20);
        // deque.offerFirst(5);
        // deque.offerLast(3);
        // System.out.println(deque);
        // System.out.println(deque.pollFirst());
        // System.out.println(deque.peekFirst());
        // System.out.println(deque.removeFirst());
        // System.out.println(deque.size());


        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        Thread t1 = new Thread(() -> {
            deque.addFirst(10);
            deque.addLast(20);
            deque.offerFirst(5);
            deque.offerLast(3);
            System.out.println("Thread 1 : "+deque);
            System.out.println("Thread 1 : "+deque.pollFirst());
            System.out.println("Thread 1 : "+deque.peekFirst());
            System.out.println("Thread 1 : "+deque.removeFirst());
            System.out.println("Thread 1 : "+deque.size());
        });
        Thread t2 = new Thread(() -> {
            deque.addFirst(10);
            deque.addLast(20);
            deque.offerFirst(5);
            deque.offerLast(3);
            System.out.println("Thread 2 : "+deque);
            System.out.println("Thread 2 : "+deque.pollFirst());
            System.out.println("Thread 2 : "+deque.peekFirst());
            System.out.println("Thread 2 : "+deque.removeFirst());
            System.out.println("Thread 2 : "+deque.size());
        });
        t1.start(); 
        t2.start();
    }
}
