import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        File file = new File("data.txt");
        File myFolder = new File("myFolder");
        // try {
        //     if (file.createNewFile()) {
        //         System.out.println("File created successfully");
        //     } else {
        //         System.out.println("Error creating file");
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        System.out.println("Exists: " + file.exists());
        System.out.println("Is File: " + file.isFile());
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("File Name: "+file.getName());
        System.out.println("File Size: " + file.length());
        System.out.println(file.isDirectory());
        myFolder.mkdir();
        myFolder.delete();
        file.delete();
    }
}
