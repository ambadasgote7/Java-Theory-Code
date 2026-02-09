// Priority in parent-->child is to child

class Sample {
    public void show(String s) {
        System.out.println("String version...");
    }
    public void show(Object o) {
        System.out.println("Object version...");
    }
}

public class Test4 {
    public static void main(String[] args) {
        Sample s = new Sample();
        s.show("ambadas"); // String version...
        s.show(new Object()); // Object version...
        // Complier will always gives priority to child class in parent-->child relationship
        s.show(null); // String(reference), Object(reference) ---> String version...
    }
}
