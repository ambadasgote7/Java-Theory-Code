import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.addFirst(0);
        list.addLast(3);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size());
        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        List<String> fruits = new LinkedList<>(Arrays.asList("apple", "banana", "orange", "mango"));
        System.out.println(fruits);




        // Node n1 = new Node();
        // Node n2 = new Node();
        // n1.value = 1;
        // n1.next = n2;
        // n2.value = 2;
        // n2.next = null;


    }
}

class Node {
    int value;
    Node next;
}
