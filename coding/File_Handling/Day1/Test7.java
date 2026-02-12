import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Test7 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("student.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            Student s = new Student("Ambadas", 21);
            oos.writeObject(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student s = (Student) oos.readObject();
            System.out.println(s.name + " " + s.age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
