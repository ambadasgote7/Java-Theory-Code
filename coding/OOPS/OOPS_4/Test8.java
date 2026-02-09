package coding.OOPS_4;

/*
5. abstract is an access modifer applicable at
    a. method -> If we are not giving the body for a method then mark the method
    as "abstract".
    b. class -> If we don't want the object to be created for a class, then mark
    the class as "abstract".
    c. variable-> This access modifier can't be applied on variables.

In case of overriding, compulsorily the child class should give implementation for
all the abstract methods present in the parent class, if the implementation is not
given then that child class should be marked as "abstract".
*/

abstract class Parent {
    public abstract void methodOne();
}

class Child extends Parent {
    public void methodOne() {
        System.out.println("Child method");
    }
}

public class Test8 {
    public static void main(String[] args) {
        Child c = new Child();
        c.methodOne();
    }
}
