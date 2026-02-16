import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // HashMap<Integer, String> map = new HashMap<>();
        // map.put(101, "Rahul");
        // map.put(102, "Amit");
        // map.put(103, "Neha");
        // map.put(101, "Alice");

        // System.out.println(map);
        // System.out.println(map.get(102));
        // System.out.println(map.get(101));
        // System.out.println(map.containsKey(101));
        // System.out.println(map.containsValue("Rahul"));

        // map.remove(101);
        // System.out.println(map);

        // for (Map.Entry<Integer, String> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }
        // System.out.println("------------------------");
        // for(Integer key : map.keySet()) {
        //     System.out.println(key + " " + map.get(key));
        // }

        HashMap<Student, Integer> map = new HashMap<>();
        map.put(new Student("Ambadas", 9), 80);
        map.put(new Student("Babusha", 10), 85);
        map.put(new Student("Rahul", 11), 83);
        map.put(new Student("Ambadas", 9), 82);

        System.out.println(map);


        // Student s1 = new Student("Ambadas", 9);
        // Student s2 = new Student("Babusha", 10);
        // Student s3 = new Student("Rahul", 11);

        // map.put(s1, 80);
        // map.put(s2, 85);
        // map.put(s3, 83);
        // map.put(s1, 82);
        // System.out.println(map);
    }
}

class Student {
    private String name;
    private int roll;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + roll;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()) {
            return roll == ((Student) obj).roll && name.equals(((Student) obj).name);
        }
        return false;
    }

    public String getName() {
        return name;
    }

   public int getRoll() {
        return roll;
    }
    @Override
    public String toString() {
        return (roll + "-" + name);
    }

}
