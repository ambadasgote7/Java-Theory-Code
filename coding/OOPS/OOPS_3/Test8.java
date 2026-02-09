// Method Overloading and var-args
class Demo {
    public void show(int i) {
        System.out.println("General method");
    }
    public void show(int... agrs) {
        System.out.println("Args method");
    }
}

public class Test8 {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.show(10); //  General method
        d.show(); // Args method
    }
}
