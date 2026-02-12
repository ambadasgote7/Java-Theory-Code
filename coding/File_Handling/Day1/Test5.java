
import java.io.IOException;
import java.nio.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
public class Test5 {
    public static void main(String[] args) {
        Path path = Paths.get("data.txt");
        // try {
        //     List<String> lines = Files.readAllLines(path);
        //     for (String s : lines) {
        //         System.out.println(s);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        
        try {
            Files.write(path, Arrays.asList("Hello", "world"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
