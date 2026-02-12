import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test6 {
    public static void main(String[] args) {
        // try (FileInputStream fis = new FileInputStream("image.png") ) {
        //     int data = fis.read();
        //     while (data != -1) {
        //         System.out.print(data + " ");
        //         data = fis.read();
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("data.txt", true) )) {
            bos.write(65);
            bos.write(66);
            bos.write(67);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
