import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        // map.put(101, "Rahul");
        // map.put(102, "Amit");
        // map.put(103, "Ram");
        // map.put(104, "Ambadas");

        // System.out.println(map);
        // System.out.println(map.get(102));
        // System.out.println(map.containsKey(102));
        // System.out.println(map.containsValue("Ram"));
        // System.out.println(map.size());
        // System.out.println(map.isEmpty());

        Thread writer = new Thread(() ->{
            for (int i = 0; i < 1000; i++) {
                map.put(i, "A");
            }
        });
        Thread reader = new Thread(() ->{
            for (Integer i : map.keySet()) {
                System.out.print(map.get(i));
            }
        });
        writer.start();
        reader.start();
        // try {
        //     writer.join();
        //     reader.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println(map.size());
    }
}
