package Assignment_1;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Name_Search {

    public static String getNamesFromUser() {          // get input of name from user:

        // Scanner
        Scanner keyboard = new Scanner(System.in);

        // asking to user enter the Popular name
        System.out.println("Popular name search ");
        System.out.print("Enter a name Starting with capital letter or separated by a space: ");

        // return to keyboard
        return keyboard.nextLine();

    } // close getNamesFromUser

    public static void getNamesFromFile( String[] array, String filename ) throws IOException  //get names from file:
    {
        int index = 0;

        File file = new File(filename);                //open the file:
        Scanner inputFile = new Scanner(file);  // scanner files

        while( inputFile.hasNext() && index < array.length) {
            array[index] = inputFile.nextLine();
            index++;
        } // close while loop

        inputFile.close();               //close file:
    } // close getNamesFromFile

    public static int sequentialSearch(String[] array, String value) {

        int index = 0;
        int element = -1;
        boolean found = false;

        while( !found && index < array.length) {
            if( array[index].equalsIgnoreCase(value))  {
                found = true;
                element = index;
            }// equals ignore case
            index++;
        }
        return element; // return to element
    } // close sequentialSearch

    public static void displaySearchResults(String input, String[] array1, String[] array2) {

        StringTokenizer nameTokenizer = new StringTokenizer(input);

        String searchName;                    //hold name:
        int resultOfBoy;
        int resultOfGirl;

        while(nameTokenizer.hasMoreTokens()) {
            searchName = nameTokenizer.nextToken();

            resultOfBoy = sequentialSearch(array1,searchName);  // try to find in boys name lists
            resultOfGirl = sequentialSearch(array2,searchName); // try to find in girls name lists
            if(resultOfBoy != -1) {
                System.out.println(searchName + " is a popular boy's name");    //display boy's result:
            }else if(resultOfGirl != -1){
                System.out.println(searchName + " is a popular girl's name");   //display girl's result:
            }else {
                System.out.println(searchName + " is a not popular name");
            }
        }
    }

    public static void main( String[]args ) throws IOException {

        // Variables
        final int SIZE = 200;
        String[] boyNames = new String[SIZE];
        String[] girlNames = new String[SIZE];

        // files names
        getNamesFromFile(boyNames, "Assignment_1/BoyNames.txt");
        getNamesFromFile(girlNames, "Assignment_1/GirlNames.txt");

        String searchNames = getNamesFromUser();

        displaySearchResults( searchNames, boyNames, girlNames );
    } // close main method
} // close class