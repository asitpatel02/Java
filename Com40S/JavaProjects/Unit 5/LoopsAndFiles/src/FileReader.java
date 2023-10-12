
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Unit 5 Practicing loops and file access
 *
 * @author 312679-Shruti Panchal
 */
public class FileReader {

    private File file;

    public FileReader() {
        //default constructor
        file = new File("src/data.dat");
    }

    public FileReader(String fileName) {
        //overloaded constructor to choose a file
        file = new File(fileName);
    }
    
    public int numLines() {
        int lines = 0;
        try {
            Scanner inFile = new Scanner(file);
            while (inFile.hasNext()) {
                lines += 1;
                inFile.nextLine();
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Invalid File");
            lines = -1;
        }
        return lines;
    }

    public String rndWord() {
        String rndWord = "";

        if (numLines() > 0) { //at least one word in file
            int max = numLines();
            int r = (int) ((max - 1 + 1) * Math.random() + 1);

            try {
                Scanner inFile = new Scanner(file);
                for (int i = 1; i <= r; i++) {
                    rndWord = inFile.next();
                }
                inFile.close();
                return rndWord.toUpperCase();
            } catch (FileNotFoundException e) {
                System.out.println("Invalid File");
            }
        }
        return "";

    }

    public static void main(String[] args) {
        FileReader f1 = new FileReader();
        //System.out.println(f1.numLines());
        System.out.println(f1.rndWord());

    }

}
