package coding.OOPS_2;

class Student {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
    }
}
public class Test5 {
    public static void main(String[] args) {
        Student s1 = new Student("Ambadas", 21);
        s1.display();
        Student s2 = new Student("John", 22);
        s2.display();
    }
}
