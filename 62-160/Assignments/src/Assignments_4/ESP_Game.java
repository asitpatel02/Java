package Assignments_4;

import java.util.Random;
import java.util.Scanner;

public class ESP_Game {

    /** this is generateComputerColor method generate computer random colors
     * @param rand generate random number and transfer to inger colorIndex
     * @return computerChosenColor color name to main method
     * computerChosenColor is String for hold colors name
     * else if statement for chose color from number
     */
    public static String generateComputerColor(Random rand){

        // Int variable
        int colorIndex;

        // random number generator
        colorIndex = rand.nextInt(5);

        String computerChosenColor = "";

        // if statement for select random colors
        if (colorIndex == 0){
            computerChosenColor = "Red";
        } else if (colorIndex == 1){
            computerChosenColor = "Green";
        } else if (colorIndex == 2){
            computerChosenColor = "Blue";
        } else if (colorIndex == 3){
            computerChosenColor = "Orange";
        } else if (colorIndex == 4){
            computerChosenColor = "Yellow";
        }
        System.out.println("Computer has chosen a color");
        return computerChosenColor;
    }

    /**
     *  This is gerUserColor method ask to user enter the guess color  
     * @param scanner scan the user color input
     * @param guessNumber print the number of question number
     * @return userColor is user enter color to send to main method
     *
     */
    public static String getUserColor(Scanner scanner, int guessNumber){

        // String Variable
        String userColor;

        // ask to user enter the color and scan the color
        System.out.print("Guess Number " + guessNumber + " User guess the computers color: ");
        userColor = scanner.nextLine();

        // return statement
        return userColor;
    }

    /**
     *  this is compareColors boolean method is compare to both color
     * @param ColorA hold the computer select color
     * @param ColorB hold the user entered color
     * @return true if the both colors are same, false otherwise
     */
    public static boolean compareColors( String ColorA, String ColorB){
        if (ColorA.equalsIgnoreCase(ColorB)){
            return true;
        } else {
            return false;
        }
    }

    /**
     *  this is displayUserColorGuesses void method print the score out of 5
     * @param userCorrectGuesses hold total score
     */
    public static void displayUserColorGuesses(int userCorrectGuesses){
        System.out.println("The user Correctly guesses " + userCorrectGuesses + " times");
    }

    // Main
    public static void main(String[] args) {

        // Introductions
        System.out.println("You must randomly select any of these colors: Red, Green, Blue, Orange, Yellow ");
        System.out.println();

        // Scanner class
        Scanner scanner = new Scanner(System.in);

        // random number generator
        Random random = new Random();

        // String Variables
        String computerColor;
        String userColor;

        // int Variables
        int userCorrectGuesses = 0;

        // for loop repeat 5 times
        for (int currentGuessNumber = 1; currentGuessNumber <=5; currentGuessNumber++){

            // read computer random colors
            computerColor = generateComputerColor(random);

            // read user enter colors
            userColor = getUserColor(scanner, currentGuessNumber);

            // after the user con
            System.out.println("The Computer Selected "+ computerColor +"\nYou Selected "+ userColor);

            // check the colors if it's same then added 1 score
            if (compareColors(computerColor, userColor)){
                userCorrectGuesses = userCorrectGuesses + 1;
            }
            System.out.println();
        }
        displayUserColorGuesses(userCorrectGuesses);

        // exit program
        System.exit(0);
    }
}