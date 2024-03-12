
import java.io.*;
import java.util.Scanner;

public class lab8Q1 {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

//        PrintWriter filename = new PrintWriter("test.txt");
//
//        char morelines = 'y';
//
//        String userLine;
        String fileToOpen;
//
        int numberOfLines = 1;
//        int count = 1;
//
//        while(morelines == 'y'){
//
//            System.out.println("Please enter the "+ count +" line: ");
//            userLine = input.nextLine();
//
//            filename.println(userLine);
//            System.out.println(" Do you want to enter another line? Enter y for yes: ");
//            morelines = input.nextLine().charAt(0);
//            count++;
//        }
//        filename.close();

        System.out.println("Please enter the name of the file you want to open: ");
        fileToOpen = input.nextLine();

        File fileOpened = new File( fileToOpen );

        while ( !fileOpened.exists()){
            System.out.println( fileToOpen + " dose not exist. \nPlease enter another file name: ");
            fileToOpen = input.nextLine();
            fileOpened = new File(fileToOpen);

        }

        Scanner fileToRead = new Scanner(fileOpened);

        while ( fileToRead.hasNext() && numberOfLines <= 5){
            System.out.println( fileToRead.nextLine());
            numberOfLines++;
        }
        fileToRead.close();
    }
}