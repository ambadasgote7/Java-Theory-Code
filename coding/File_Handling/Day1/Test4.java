import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;

public class Test4 {
    public static void main(String[] args) {
        // // Method 1 : Reading the file using FileInputStream
        // try {
        //     FileInputStream fis = new FileInputStream("image.png");
        //     int data = fis.read();
        //     while (data != -1) {
        //         System.out.print(data + " ");
        //         data = fis.read();
        //     }
        //     fis.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // // // Method 2 : Writing the file using FileOutputStream
        // try {
        //     FileOutputStream fos = new FileOutputStream("copy.png");
        //     fos.write(65);
        //     fos.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // // Method 3 : Reading file using BufferedInputStream
        // try {
        //     BufferedInputStream bis = new BufferedInputStream(new FileInputStream("image.png"));
        //     int data = bis.read();
        //     while (data != -1) {
        //         System.out.print(data + " ");
        //         data = bis.read();
        //     }
        //     bis.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // // Method 4 : Writing file using BufferedOutputStream
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("image.png"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.png"));
            int data = bis.read();
            while (data != -1) {
                bos.write(data);
                data = bis.read();
            }
            bos.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
