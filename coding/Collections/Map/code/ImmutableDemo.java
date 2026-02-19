import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableDemo {
    public static void main(String[] args) {
    //     Map<Integer, String> map = new HashMap<>();
    //     map.put(1, "A");
    //     map.put(2, "B");
    //     map.put(3, "C");
    //     Map<Integer, String> map1 = Collections.unmodifiableMap(map);
    //   //  map1.put(4, "A");
    //   map.put(4, "D");
    //     System.out.println(map);

        Map<Integer, String> map = Map.of(1, "A", 2, "B", 3, "C");
        map.put(4, "D");
        System.out.println(map);
        
    }
}
