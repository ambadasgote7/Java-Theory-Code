import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();
        // table.put(101, "Rahul");
        // table.put(102, "Amit");
        // table.put(103, "Ambadas");

        // System.out.println(table);
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 1000; i++) {
                table.put(i, "A");
            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 1000; i < 2000; i++) {
                table.put(i,"B");
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
        System.out.println(table.size());
    }
}
