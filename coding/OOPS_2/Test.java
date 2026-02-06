package coding.OOPS_2;

class Person {
    public String name;
    public String address;
    public int age;
}
class Student extends Person {
    public int marks;
    public String grade;

    Student(String name, String address, int age, int marks, String grade) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Name : " + this.name);
        System.out.println("Address : " + this.address);
        System.out.println("Age : " + this.age);
        System.out.println("Marks : " + this.marks);
        System.out.println("Grade : " + this.grade);
    }
}
public class Test {
    public static void main(String[] args) {
        Student s = new Student("Ambadas", "Dudhani", 21, 81, "A");
        s.display();
    }
}
