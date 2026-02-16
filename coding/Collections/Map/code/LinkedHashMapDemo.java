import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHash<Integer, String> map = new LinkedHash<>(3);
        map.put(101, "Rahul");
        map.put(102, "Amit");
        map.put(103, "Neha");
        map.get(101);
        map.put(104, "MAhi");

        System.out.println(map);
      

        
    }
}

class LinkedHash<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LinkedHash(int capacity) {
        super(capacity, 0.5f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
