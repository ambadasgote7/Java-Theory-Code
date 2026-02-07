// Method Overloading : same name different parameter count
// It not good to use method overloading in case of same name different parameter count
// Instead of using methods with different parameter count, we can use var-args

class Calculator {
    public void add(int a, int b) {
        System.out.println(a+b);
    }
    public void add(int a, int b, int c) {
        System.out.println(a+b+c);
    }
    public void add(int a, int b, int c, int d) {
        System.out.println(a+b+c+d);
    }
    public void add(int a, int b, int c, int d, int e) {
        System.out.println(a+b+c+d+e);
    }
}

class AdvancedCalculator {
    public void add(int... args) {
        int sum = 0;
        for (int data : args)
            sum += data;
        System.out.println(sum);
    }
}

public class Test7 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add(10,20);
        c.add(10,20,30);
        c.add(10,20,30,40);
        c.add(10,20,30,40,50);

        System.out.println();
        AdvancedCalculator ac = new AdvancedCalculator();
        ac.add();
        ac.add(10);
        ac.add(10,20);
        ac.add(10,20,30);
        ac.add(10,20,30,40);    
        ac.add(10,20,30,40,50);
    }
}
