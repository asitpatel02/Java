import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FilesApp {
    public static void main(String[] args) {
//        try{
//                Scanner keyboard = new Scanner(System.in);
//                System.out.print("Enter a source file name: ");
//                String source = keyboard.next();
//                System.out.print("Enter a target file name: ");
//                String target = keyboard.next();
//                FileReader read = new FileReader(source);
//                FileWriter write = new FileWriter(target, true); //true - append
//                int i = 0;
//                while ((i = read.read()) != -1) {
//                    write.write((char) i + "");
//                }
//                read.close();
//                write.close();
//                System.out.println("Copied successfully!!"); } catch (Exception e1) {
//                System.out.println(e1);
//        }

        //What will be the value of x[8] after the following code has been executed?

        final int SUB = 12;

        int[] x = new int[SUB];

        int y = 20;

        for(int i = 0; i < SUB; i++)

        {

            x[i] = y;

            y += 5;
            System.out.println(y);

        }
    }
}
