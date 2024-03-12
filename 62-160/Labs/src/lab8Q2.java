
import java.util.Arrays;
import java.util.Scanner;

public class lab8Q2 {

    static boolean changeValue = true;
    public static void main(String[] args) {
        // Values
        int value = 0,
                correctGuess = 0,
                incorrectGuess = 0,
                total = 0;
        final String[] colors = new String[] {"red", "green", "blue", "orange", "yellow"};
        String color = "";

        // Welcome Message
        System.out.println("----------ESP Game----------");
            System.out.println("You must randomly select any of these colors: " + Arrays.toString(colors));

        // Initialize Scanner
        Scanner input = new Scanner(System.in);

        // While loop to stop game after 10 tries
        while (total < 5) {

            // If user enters invalid name, do not change value,
            // If user enters correct or incorrect name, change value
            if (changeValue == true) {
                value = ((int) (Math.random() * 100) % 5 + 0);
            }
            System.out.println("Please select a color, and type it ("+Arrays.toString(colors)+"): ");
            String selectedColor = input.nextLine();

            // Select color from array using value
            color = colors[value];

            // If statements to check whether or not the user got the answer correct
            if (selectedColor.equalsIgnoreCase(color)) {
                correctGuess = correctGuess + 1;
                System.out.println("\nGood guess! Color was: " + color + "\n");
                changeValue = true;
            } else if (Arrays.asList(colors).contains(selectedColor) && selectedColor != color){
                System.out.println("\nBad guess. Color was: " + color + "\n");
                incorrectGuess = incorrectGuess + 1;
                changeValue = true;
            }
            else {
                System.out.println("\nIncorrect entry, try again\n");
                changeValue = false;
            }


            // Counter, once reaches 10, while loop stops
            total = correctGuess + incorrectGuess;
        }
        System.out.println("You have gotten " + correctGuess + "/5 guesses correct!");
    }
}