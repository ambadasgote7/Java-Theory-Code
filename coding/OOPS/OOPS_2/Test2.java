package coding.OOPS_2;

class Employee {
    public String name;
    public int age;

    Employee() {
        System.out.println("Default Constructor");
    }
    Employee(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized Constructor");
    }
    public void display() {
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
    }
}

public class Test2 {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.display();
        Employee e = new Employee("Ambadas", 21);
        e.display();
    }
}
