import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {
     //   ArrayList<String> list = new ArrayList<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        // System.out.println(list);
        // list.remove("B");
        // System.out.println(list);
        Thread t2 = new Thread(() -> {
            for (String s : list) {
                System.out.print(s + " ");
            }
        });
        Thread t1 = new Thread(() -> {
            for (String s : list) {
                list.add("D");
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
        System.out.println();
        System.out.println(list);
    }
}
