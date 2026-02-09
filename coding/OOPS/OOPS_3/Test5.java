// In child-child relationship, the compiler will through error about ambiguous method call

class Sample {
    public void show(String s) {
        System.out.println("String version...");
    }
    public void show(StringBuffer s) {
        System.out.println("StringBuffer version...");
    }
}
public class Test5 {
    public static void main(String[] args) {
        Sample s = new Sample();
        s.show("ambadas"); // String version...
        s.show(new StringBuffer("ambadas")); // Object version...
      //  s.show(null); // Complier will throw error : reference to show is ambiguous
    }
}
