import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");

        System.out.println(map);
        System.out.println(map.lowerKey(25));   // 20
        System.out.println(map.floorKey(20));   // 20
        System.out.println(map.ceilingKey(20)); // 20
        System.out.println(map.higherKey(25));  // 30
        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());
        System.out.println(map.descendingMap());

        System.out.println(map.pollFirstEntry());
        System.out.println(map.pollLastEntry());
        
    }
}
