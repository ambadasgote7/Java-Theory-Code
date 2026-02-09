package coding;

final class Sample {
    final int x = 10;
    public final void show() {
        System.out.println("Sample");
    }
}

//  error: cannot inherit from final Sample
// class Test extends Sample {
//     // Cannot override the final method from Sample
//     // void show() {
//     //     System.out.println("Test");
//     // }
// }

public class finalKeyword {
    public static void main(String[] args) {
        Sample s = new Sample();
        s.show();
        //s.x = 20; // The final field Sample.x cannot be assigned
        System.out.println(s.x);
    }
}
