// Auto type promotion
class Demo {
    public void add(int a) {
        System.out.println("int parameter");
    }
    public void add(float a) {
        System.out.println("float parameter");
    }
}
public class Test2 {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.add('c'); // char --> char,int
        d.add(10L); // long ---> long, float
      //  d.add(10.0); // complie time error :   no suitable method found for add(double)
    }
}
