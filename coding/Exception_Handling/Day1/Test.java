
public class Test {
    public static void main(String[] args) {
        int[] n = {10,20,60,40};
        int[] d = {2,3,0,4};
        for (int i = 0; i < n.length; i++) {
           // System.out.println(divide(n[i], d[i]));  // This will abnormally stop the program
           System.out.println(divide1(n[i], d[i])); // This will not stop the program
        }
        System.out.println("Good Job");
    }
    
    // This method will stop the program if the denominator is zero because no exception is handled
    public static int divide(int a, int b) {
        return a / b;
    }

    // This method will not stop the program if the denominator is zero because exception is handled
    public static int divide1(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
            return -1;
        }
    }
}

