import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test3 {
    public static void main(String[] args) {
        // // Methos 1 : Writing to a file using FileWriter but it overwrites the file
        // try {
        //     FileWriter fw = new FileWriter("data.txt");
        //     fw.write("Hey, People I am Writing in to data file but this overwrites the file");
        //     fw.write(System.lineSeparator());
        //     fw.write("This is second line");
        //     fw.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // Method 2 :Writing to a file using FileWriter but it appends to the file
        // try {
        //     FileWriter fw = new FileWriter("data.txt", true);
        //     fw.write("\nHey, People I am Writing in to data file but this appends to the file");
        //     fw.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // Method 3 : Writing to a file using BufferedWriter but overwrites the file depends on the filewriter you pass
        // try {
        //     BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt", true));
        //     bw.newLine();
        //     bw.write("Hey, People I am Writing in to data file using the BufferWriter but this do not overwrites the file");
        //     bw.newLine();
        //     bw.write("This is second line");
        //     bw.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // Method 4 : Writing to a file using printWriter overwrites the file
        // try {
        //     PrintWriter pw = new PrintWriter("data.txt");
        //     pw.println("Hey, People I am Writing in to data file using the PrintWriter");
        //     pw.println("This is second line");
        //     pw.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // Method 5 : Writing to a file using printWriter appends to the file
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("data.txt", true));
            pw.println("Hey, People I am Writing in to data file using the PrintWriter this will append to the file");
            pw.println("This is second line");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
