package coding.OOPS_4;

/*  
1. In case of Overriding, we can't change the returntype of the method,if we want
to change then there sould be relationship b.w
returntype of the methods.
*/

class Parent {
    public Object methodOne() {
        return true;
    }
}

class Child extends Parent {
    /* error: methodOne() in Child cannot override methodOne() in Parent
    public void methodOne() {
                ^
  return type void is not compatible with Object
   */ 
    // public void methodOne() {
    //     System.out.println("Child method");
    // }

    public String methodOne() {
        System.out.println("Child method");
        return null;
    }
}

public class Test4 {
    public static void main(String[] args) {
        System.out.println(new Parent().methodOne());
        System.out.println(new Child().methodOne());
    }
}
