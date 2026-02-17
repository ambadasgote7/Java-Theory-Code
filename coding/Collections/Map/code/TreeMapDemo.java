import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Student, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(new Student("Rahul", 20), "A");
        map.put(new Student("Amit", 21), "B");
        map.put(new Student("Ram", 22), "C");
        map.put(new Student("Raju", 23), "D");

        System.out.println(map);
        
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student o) {
        return this.age - o.age;
    }

    public String toString() {
        return name + "-" + age;
    }
}


