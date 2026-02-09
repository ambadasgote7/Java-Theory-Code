// Ambigous method call CompileTime Error

class Demo {
    public void add(int a, float b) {
        System.out.println("int-float parameter");
    }
    public void add(float a, int b) {
        System.out.println("float-int parameter");
    }
}

public class Test3 {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.add(10, 20.0f); // int-float parameter
        d.add(10.0f, 20); // float-int parameter
        // Complie time error : reference to add is ambiguous
       // d.add(10, 20); // type promotion --> int-float, float-int, float-float
    }
}
