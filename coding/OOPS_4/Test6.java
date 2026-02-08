package coding.OOPS_4;

/*
3.private methods won't participate in inheritance, so overriding them in child
class is not possible.
*/

class Parent {
    private void methodOne() {
        System.out.println("Parent method");
    }
}
class Child extends Parent {
    private void methodOne() {
        System.out.println("Child method");
    }
}
public class Test6 {
    public static void main(String[] args) {
        Parent p = new Child();
        // p.methodOne(); // error: methodOne() has private access in Parent
    }
}
