
package coding.OOPS_5;

abstract class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    int marks;
    float avg;
    Student(String name, int age, int marks, float avg) {
        // To call the parameterized constructor of the parent class from the child class
        super(name, age);
        this.marks = marks;
        this.avg = avg;
    }
    public void display() {
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println("Marks : " + this.marks);
        System.out.println("Grades : " + this.avg);
    }
}
public class Test4 {
    public static void main(String[] args) {
       Student s = new Student("Ambadas", 21, 100, 90.0f);
       s.display();
    }
}