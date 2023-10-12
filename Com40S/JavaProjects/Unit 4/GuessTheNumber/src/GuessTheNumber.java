
import java.util.Scanner;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class GuessTheNumber {

    private int userGuess;
    private int high, low;
    private int randNum;
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        GuessTheNumber n1 = new GuessTheNumber();
        n1.lowHigh();
        
    }

    public void randNum() {
        //random number
        randNum = (int) ((high - low + 1) * Math.random() + low);
        System.out.println("I'm thinking of a number..." + randNum);
        userNum();
    }

    public void lowHigh() {
        //low
        System.out.print("What is the low number you want for the range: ");
        low = Integer.parseInt(in.next());
        //high
        System.out.print("What is the high number you want for the range: ");
        high = Integer.parseInt(in.next());

        randNum();
    }

    public void userNum() {
        //user input for their guess number        
        System.out.print("What do you think my number is? ");
        userGuess = Integer.parseInt(in.next());
        
        check();
    }

    public void check() {
        //check the numbers
        if (userGuess == randNum) {
            System.out.println("You guessed the number:)");            
        } else if (userGuess < low || userGuess > high) {
            System.out.println("Your guess is out of the range"); 
            userNum();
        } else if (userGuess > randNum) {
            if (userGuess > (high - randNum / 2)) {
                System.out.println("You guessed too high");
                userNum();
            } else {
                System.out.println("Your guessed number is high");
                userNum();
            }
        } else if (userGuess < randNum) {
            if (userGuess < (randNum - low / 2)) {
                System.out.println("You guessed too low");
                userNum();
            } else {
                System.out.println("Your guessed number is low");
                userNum();
            }
        }

    }

}
