import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        // Method 1 : Reading the file character by character using FileReader which is slow for large files
        // try {
        //     FileReader file = new FileReader("data.txt");
        //     int ch = file.read();
        //     while (ch != -1) {
        //         System.out.print((char) ch);
        //         ch = file.read();
        //     }
        //     file.close();

        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // Method 2 : Reading the file line by line using BufferedReader which is faster for large files
        // try {
        //     BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        //     String line = br.readLine();
        //     while (line != null) {
        //         System.out.println(line);
        //         line = br.readLine();
        //     }
        //     br.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // Method 3 : Reading the file line by line using Scanner which not idle for large files
        try {
            File file = new File("data.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
