import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        // ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
        // map.put(101, "Rahul");
        // map.put(102, "Amit");
        // map.put(103, "Ram");
        // map.put(104, "Ambadas");

        Map<Integer, Integer> map = new ConcurrentSkipListMap<>();
        System.out.println(map);

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 1000; i++) {
                // map.put(i, "A");
                map.put(i, i);
            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 1000; i < 2000; i++) {
                // map.put(i, "B");
                map.put(i, i);
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
        System.out.println(map.size());
    }
}
