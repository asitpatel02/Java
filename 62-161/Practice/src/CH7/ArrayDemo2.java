package CH7;

import java.util.Scanner;

// Code Listing 7-2
public class ArrayDemo2 {

    public static void main(String[] args) {

        final int EMPLOYEES  = 3; // number of Employees
        int[] hours = new int[EMPLOYEES]; //Array of hours

        //create a scanner object
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the hours worked by "+EMPLOYEES+" employees.");

        // get the hours for each employees
        for (int index=0; index < EMPLOYEES; index++){
            System.out.print("Employee "+(index +1)+": ");
            hours[index] = keyboard.nextInt();
        }

        System.out.println("The hours you entered are:");

        //display the values entered
        for (int index = 0; index<EMPLOYEES;index++){
            System.out.println(hours[index]);
        }
    }
}
