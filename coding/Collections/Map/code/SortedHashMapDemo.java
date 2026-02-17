import java.util.SortedMap;
import java.util.TreeMap;

public class SortedHashMapDemo {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(101, "Rahul");
        map.put(103, "Raju");
        map.put(102, "Amit");
        map.put(105, "Ambadas");

        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap(103));
        System.out.println(map.tailMap(103));
        System.out.println(map.subMap(101, 103));
                
    }
}
