
import java.util.*;

public class Test {
    public static void main(String[] args) {
       // List<Integer> list = new ArrayList<>();
       Vector<Integer> list = new Vector<>(1000, 300);
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(2);

        // System.out.println(list.get(0)); // 1
        // System.out.println(list.size());
        // System.out.println(list.contains(2));
        // System.out.println(list.indexOf(2));
        // System.out.println(list.lastIndexOf(2));

        System.out.println(list.capacity());
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        System.out.println(list.capacity());
    }
}
