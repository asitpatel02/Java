package Assignments_3;

import javax.swing.*;
import java.util.Random;

public class Random_Number_Guessing_Game {

    // Main
    public static void main(String[] args) {

        // Random Number
        Random random = new Random();

        // int variable for random number 10=<0
        int RandNum = random.nextInt(11);

        // Boolean Variable for user false
        boolean usercorrect = false ;

        // String Variable
        String userinputStr ;

        // Int Variable
        int userGuessNum;

        // while loop for enter the guess number
        while (!usercorrect){
            userinputStr = JOptionPane.showInputDialog("Guess the number: ");
            userGuessNum = Integer.parseInt(userinputStr);

            // if statements for guess num are high, low and correct number
            if (userGuessNum> RandNum){
                JOptionPane.showMessageDialog(null," Too High, try again \uD83D\uDE1F");
            }else if (userGuessNum<RandNum){
                JOptionPane.showMessageDialog(null," Too low, try again \uD83D\uDE1F");
            }else {
                JOptionPane.showMessageDialog(null," Yes you guessed the number \uD83D\uDE03 .");
                usercorrect = true;
            }
        }

        // Exit
        System.exit(0);
    }
}
