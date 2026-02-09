package coding.OOPS_2;

class LoanApp {
    static float rateOfInterest = 0.05f;

}
public class Test4 {
    public static void main(String[] args) {
        System.out.println(LoanApp.rateOfInterest);
        System.out.println(new LoanApp().rateOfInterest);
    }
}
