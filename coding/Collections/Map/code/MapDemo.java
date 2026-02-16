import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // System.out.println(map);
        // System.out.println(map.get("A"));
        // System.out.println(map.get( 2));
        // System.out.println(map.containsKey("A"));
        // System.out.println(map.containsValue(2));
        // System.out.println(map.size());
        // map.put("A", 4);
        // System.out.println(map);

        // for (String key : map.keySet()) {
        //     System.out.println(key + ": " + map.get(key));
        // }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
