package coding.OOPS_6;

import java.io.*;
public class Test6 {
    public static void main(String[] args) throws Exception {

        Student s = new Student(101, "Ram");

        // Serialization
        FileOutputStream fos = new FileOutputStream("data.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.close();

        System.out.println("Object serialized successfully");
    }
}

class Student implements Serializable {   // Marker Interface
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


