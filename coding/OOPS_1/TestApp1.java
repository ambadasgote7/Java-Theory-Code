class Student {
    private String name;
    private int rollNo;
    private double marks;

   public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getMarks() {
        return marks;
    }
}

public class TestApp1 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setDetails("John", 12, 90);
        System.out.println(s.getName());
        System.out.println(s.getRollNo());  
        System.out.println(s.getMarks());
    }
}
