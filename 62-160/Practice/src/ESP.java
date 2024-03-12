import java.util.Random;
import java.util.Scanner;

public class ESP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String computerColor;
        String userInputColor;
        int userCorrectGuesses = 0;

        for (int currentGuessNumber = 1; currentGuessNumber <=5; currentGuessNumber++){
            computerColor = ComputerColor(random);
            userInputColor = userInput(scanner, currentGuessNumber);
            System.out.println("The Computer Selected "+ computerColor +"\nYou Selected "+ userInputColor);
            if (compareColors(computerColor, userInputColor)){
                userCorrectGuesses = userCorrectGuesses + 1;
            }
        }
        System.out.println("The user Correctly guesses " + userCorrectGuesses + " times");
    }

    public static boolean compareColors( String ColorA, String ColorB){
        if (ColorA.equalsIgnoreCase(ColorB)){
            return true;
        } else {
            return false;
        }
    }
    
    public static String userInput(Scanner scanner, int guessNumber){
        String userInputColor;
        System.out.print("Guess Number " + guessNumber + " User guess the computers color: ");
        userInputColor = scanner.nextLine();
        return userInputColor;
    }
   
    public static String ComputerColor(Random rand){
        int selectedColour;
        selectedColour = rand.nextInt(5);
        String computerRandColor = "";
        if (selectedColour == 0){
            computerRandColor = "Red";
        } else if (selectedColour == 1){
            computerRandColor = "Green";
        } else if (selectedColour == 2){
            computerRandColor = "Blue";
        } else if (selectedColour == 3){
            computerRandColor = "Orange";
        } else if (selectedColour == 4){
            computerRandColor = "Yellow";
        }
        System.out.println("Computer has chosen a color");
        return computerRandColor;
    }
}