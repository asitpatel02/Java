package CH7;

import java.util.Scanner;

// Code Listing 7-5
public class PayArray {
    public static void main(String[] args) {
        final int EMPLOYEES = 3; // Number of employees
        double payRate; // Hourly pay rate
        double grossPay; //Gross pay

        //create a array a hold
        int[] hours = new int[EMPLOYEES];

        //Create a Scanner object
        Scanner keyboard = new Scanner(System.in);

        //get the your worked by each employee
        System.out.println("Enter the hours worked by " + EMPLOYEES + " employees who all earn the same hourly rate.");

        for (int index =0; index < EMPLOYEES; index++){
            System.out.print("Employee #" + (index+1) + ": ");
            hours[index] = keyboard.nextInt();
        }

        //get the hourly pay rate
        System.out.print("Enter the hourly rate for each employee: ");
        payRate = keyboard.nextDouble();

        //Display each employee's gross pay
        System.out.println("Here os each employee's gross pay: ");
        for (int index = 0; index < EMPLOYEES; index++){
            grossPay = hours[index] * payRate;
            System.out.println("Employee #" + (index + 1) + ": $" + grossPay);
        }

    }
}
