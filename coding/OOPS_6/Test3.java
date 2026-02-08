package coding.OOPS_6;

interface ICalculator {
    void add(int a, int b);
    void sub(int a, int b);
}

class AdvancedCalculator {
    void mul(int a, int b) {
        System.out.println("The mul is :: " + (a * b));
    }
    void div(int a, int b) {
        System.out.println("The div is :: " + (a / b));
    }
}

class Calculator extends AdvancedCalculator implements ICalculator {
    public void add(int a, int b) {
        System.out.println("The sum is :: " + (a + b));
    }
    public void sub(int a, int b) {
        System.out.println("The diff is :: " + (a - b));
    }
}
public class Test3 {
    public static void main(String[] args) {
        // Using the class directly
        Calculator cal = new Calculator();
        cal.add(10, 20);  
        cal.sub(50, 20); 
        cal.mul(10, 20);
        cal.div(10, 20);
        System.out.println();

        // using the parent class reference 
        AdvancedCalculator ac = new AdvancedCalculator();
        ac.mul(10, 20);
        ac.div(10, 20);
        System.out.println();

        // using the interface reference loose coupling
        ICalculator c = new Calculator();
        c.add(10, 20);
        c.sub(50, 20);
    }
}
