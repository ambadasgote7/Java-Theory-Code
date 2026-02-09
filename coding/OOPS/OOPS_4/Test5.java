package coding.OOPS_4;

/*
2. While overrding, we can't reduce the scope of access modifier.
        private< default < protected < public
*/

class Parent {
    public void methodOne() {
        System.out.println("Parent method");
    }
    private void methodTwo() {
        System.out.println("Parent method");
    }
}
class Child extends Parent {
    // attempting to assign weaker access privileges; was public
    // protected void methodOne() {
    //     System.out.println("Child method");
    // }
    
    public void methodTwo() {
        System.out.println("Child method");
    }
}

public class Test5 {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();
        p.methodOne();
        c.methodTwo();
    }
}
