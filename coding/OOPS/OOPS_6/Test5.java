package coding.OOPS_6;

interface IRemote {
    int MIN_VALUE = 0;
    int MAX_VALUE = 100;
}
public class Test5 implements IRemote {
    public static void main(String[] args) {
        System.out.println(IRemote.MIN_VALUE);
        System.out.println(IRemote.MAX_VALUE);
        System.out.println(Test5.MIN_VALUE);
        System.out.println(Test5.MAX_VALUE);
    }
}
