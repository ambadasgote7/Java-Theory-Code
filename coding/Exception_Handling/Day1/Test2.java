import java.io.*;

/*
One way to handle the exception is to use try-catch
Second way is to declare the exception in throws
*/
public class Test2 {
    public static void main(String[] args) throws IOException {
        // try {
        //     FileReader file = new FileReader("test.txt");
        //     System.out.println(file.read());
        // } catch (IOException e) {
        //     System.out.println("Cannot read file");
        // }

        FileReader file = new FileReader("test.txt");
        System.out.println(file.read());
    }
}
