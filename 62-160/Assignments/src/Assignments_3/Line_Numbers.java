package Assignments_3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Line_Numbers {

    //Main
    public static void main(String[] args) throws IOException {

        // Scanner for input char
        Scanner input = new Scanner(System.in);

        // int variable
        int lineNum = 1;

        // String Variable
        String UserFileName;

        // input file name
        System.out.print("Please Enter the name of the file.(test.txt): ");
        UserFileName = input.nextLine();

        // open file
        File file = new File(UserFileName);

        // while loop = if user input file dose not exist
        while( !file.exists()){
            System.out.println( UserFileName +" dose not exist. Please enter a different file name.");
            UserFileName = input.nextLine();
            file = new File( UserFileName );
        }

        // read the file
        Scanner fileToScan = new Scanner(file);

        // print with line number
        while ( fileToScan.hasNext()){
            System.out.println(lineNum + ":" + fileToScan.nextLine());
            lineNum +=1;
        }

        // exit
        System.exit(0);
    }
}
