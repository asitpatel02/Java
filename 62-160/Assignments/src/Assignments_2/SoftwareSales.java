package Assignments_2;

import javax.swing.*;


public class SoftwareSales {

    //Main
    public static void main(String[] args) {

        // initialize variables
        int userInput;

        // constant variables
        double discount = 0;
        double subtotal = 0;
        double packagePrice = 99;
        double total = 0;

        // String variables
        String UserInput;
        String userOutput;

        //Input
        UserInput= JOptionPane.showInputDialog("Please enter how many packages you're buying");
        userInput= Integer.parseInt(UserInput);

        //if statements
        if(userInput<10){
            subtotal=packagePrice*userInput;
            discount=0;
            total=subtotal-discount;
        }else if (userInput<20){
            subtotal=packagePrice*userInput;
            discount=((double)20/100)*subtotal;
            total=subtotal-discount;
        }else if (userInput<50){
            subtotal=packagePrice*userInput;
            discount=((double) 30/100)*subtotal;
            total=subtotal-discount;
        }else if (userInput<100){
            subtotal=packagePrice*userInput;
            discount=((double)40/100)*subtotal;
            total=subtotal-discount;
        }else {
            subtotal=packagePrice*userInput;
            discount=((double) 50/100)*subtotal;
            total=subtotal-discount;
        }

        //Output
        userOutput=String.format("Packages Purchases: %d\nSubtotal: $%,.2f\nDiscount: $%,.2f\nTotal: $%,.2f",
                userInput, subtotal, discount, total);

        JOptionPane.showMessageDialog(null, userOutput);

        //exit
        System.exit(0);
    }
}