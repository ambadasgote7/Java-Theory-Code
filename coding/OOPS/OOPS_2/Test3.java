package coding.OOPS_2;

class Calculator {
    public void add(int a, int b) {
        int result =  a + b;
        System.out.println(result);
    }
}

public class Test3 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add(10, 20);
    }
}
