package coding.OOPS_4;

/*
4. final is an access modifer applicable at
    a. variable => If applied at variable level, then the value can't be changed.
    b. method => If applied at method level, then we can't override the method
    in child class.
    c. class => If applied at class level, then the class won't participate in
    inheritance.
*/

class Parent {
    public final void methodOne() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    /*
     error: methodOne() in Child cannot override methodOne() in Parent
            public void methodOne() {
                        ^
        overridden method is final

        Cannot override the final method from Parent
     */
     
    // public void methodOne() {
    //     System.out.println("Child method");
    // }
}

public class Test7 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.methodOne();
    }
}
