package coding.OOPS_4;

class Parent {
    public void property() {
        System.out.println("Land + Cash + Gold");
    }

    public void marry() {
        System.out.println("Relative Girl");
    }
}

class Child extends Parent {
    public void property() {
        System.out.println("Land + Cash + Gold");
    }
    public void marry() {
        // Re-implementation of the method
        System.out.println("Some Other Girl");
    }
}
public class Test {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.property(); // Land + Cash + Gold
        p.marry(); // Relative Girl

        Child c = new Child();
        c.property(); // Land + Cash + Gold
        c.marry(); // Some Other Girl
       
        Parent pa = new Child();
        pa.property(); // Land + Cash + Gold
        pa.marry(); // Some Other Girl

        // Complier will throw error : incompatible types if we type cast then runtime error java.lang.ClassCastException
        // Child ch = (Child) new Parent();
        // ch.property();
        // ch.marry();
    }
}