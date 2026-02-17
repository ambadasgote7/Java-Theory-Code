import java.util.WeakHashMap;

public class WeakHashmapDemo {
    public static void main(String[] args) {

        WeakHashMap<String, Integer> map = new WeakHashMap<>();

        String key1 = new String("Rahul");
        String key2 = new String("Amit");
        String key3 = new String("Raju");
        
        map.put(key1, 101);
        map.put(key2, 102);
        map.put(key3, 103);
        map.put("Ambadas", 104);

        System.out.println("Before GC: " + map);

        key1 = null;
        key2 = null;
        key3 = null;
        

        System.gc();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After GC: " + map);



        // WeakHashMap<Student, Integer> map = new WeakHashMap<>();

        // Student student1 = new Student("Rahul", 20);
        // Student student2 = new Student("Amit", 21);
        // Student student3 = new Student("Neha", 22);

        // map.put(student1, 101);
        // map.put(student2, 102); 
        // map.put(student3, 103);

        // System.out.println(map);

        // student1 = null;
        // student2 = null;
        // student3 = null;
    
        // System.gc();
        // try {
        //     Thread.sleep(10000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println(map);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + "-" + age;
    }
}