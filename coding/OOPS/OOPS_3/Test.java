class Demo {
    public void add(int a, int b) {
        System.out.println("int-int parameter");
    }
    public void add(float a, float b) {
        System.out.println("float-float parameter");
    }
    public void add(double a, double b) {
        System.out.println("double-double parameter");
    }
}
public class Test {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.add(10,20); // int-int parameter
        d.add(10.0,20.0); // double-double parameter
        d.add(10.0f,20.0f); // float-float parameter
    }
}