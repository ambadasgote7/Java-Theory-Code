package coding.OOPS_6;

interface ICalculator {
    void add(int a, int b);
    void sub(int a, int b);
}
interface IAdvancedCalculator {
    void mul(int a, int b);
    void div(int a, int b);
}

class Calculator implements ICalculator, IAdvancedCalculator {
    public void add(int a, int b) {
        System.out.println("The sum is :: " + (a + b));
    }
    public void sub(int a, int b) {
        System.out.println("The diff is :: " + (a - b));
    }
    public void mul(int a, int b) {
        System.out.println("The mul is :: " + (a * b));
    }
    public void div(int a, int b) {
        System.out.println("The div is :: " + (a / b));
    }
}
public class Test2 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add(10, 20);
        c.sub(50, 20);
        c.mul(10, 20);
        c.div(10, 20);
        System.out.println();
        // Loose coupling using interface reference
        ICalculator cal = new Calculator();
        cal.add(10, 20);
        cal.sub(50, 20);
        System.out.println();
        IAdvancedCalculator adv = new Calculator();
        adv.mul(10, 20);
        adv.div(10, 20);
    }
}
