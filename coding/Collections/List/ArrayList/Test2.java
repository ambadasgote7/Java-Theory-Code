import java.util.*;
import java.util.Collections;

import java.util.Comparator;
class Student implements Comparable<Student> {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int compareTo(Student s) {
        int ageCompare = Integer.compare(this.age, s.age);
        if (ageCompare != 0) {
            return ageCompare;
        }
        return this.name.compareTo(s.name);
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name + " " + age;
    }
}
public class Test2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Rahul", 21));
        students.add(new Student("Babusha", 22));
        students.add(new Student("Ambadas", 21));
        students.add(new Student("Chirag", 23));

        // Using comparable interface
       // Collections.sort(students);

       // using the comparator with lambda
    //   students.sort((s1, s2) -> {
    //       int ageCompare = Integer.compare(s1.age, s2.age);
    //       if (ageCompare != 0) {
    //           return ageCompare;
    //       }
    //       return s1.name.compareTo(s2.name);
    //   });
    // students.sort(new Comparator<Student>() {
    //     public int compare(Student s1, Student s2) {
    //         if (s1.age != s2.age) {
    //             return Integer.compare(s1.age, s2.age);
    //         } 
    //         return s1.name.compareTo(s2.name);
    //     }
    // });

     //   students.sort(Comparator.comparingInt((Student s) -> s.age).thenComparing(s -> s.name).reversed());

        students.sort(Comparator.comparingInt(Student :: getAge).thenComparing(Student :: getName).reversed());

        System.out.println(students);
    }
}
