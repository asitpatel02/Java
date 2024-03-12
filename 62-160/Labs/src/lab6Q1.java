
import java.util.Scanner;

public class lab6Q1 {

        public static void main(String[ ] args)
        {

            Scanner keyboard = new Scanner(System.in);


            System.out.print("What is the name of the first runner? ");
            char runner1;
            runner1 = keyboard.next().charAt(0);

            System.out.print("What is this runner's score in minutes? ");
            int score1;
            score1 = keyboard.nextInt();

            System.out.print("What is the name of the second runner? ");
            char runner2;
            runner2 = keyboard.next().charAt(0);

            System.out.print("What is this runner's score in minutes? ");
            int score2;
            score2 = keyboard.nextInt();

            System.out.print("What is the name of the third runner? ");
            char runner3;
            runner3 = keyboard.next().charAt(0);

            System.out.print("What is this runner's score in minutes? ");
            int score3;
            score3 = keyboard.nextInt();

            if (score1 < score2 && score1 < score3)
            {
                if (score2 < score3)
                {
                    System.out.println("The first place runner is " + runner1 + "\nThe second place runner is "
                            + runner2 + "\nThe third place runner is " + runner3 + ". ");
                }
                else
                {
                    System.out.println("The first place runner is " + runner1 + "\nThe second place runner is "
                            + runner3 + "\nThe third place runner is " + runner2 + ". ");
                }
            }
            else if (score2 < score1 && score2 < score3)
            {
                if (score1 < score3)
                {
                    System.out.println("The first place runner is " + runner2 + "\nThe second place runner is "
                            + runner1 + "\nThe third place runner is " + runner3 + ". ");
                }
                else
                {
                    System.out.println("The first place runner is " + runner2 + "\nThe second place runner is "
                            + runner3 + "\nThe third place runner is " + runner1 + ". ");
                }
            }
            else if (score3 < score1 && score3 < score2)
            {
                if (score1 < score2)
                {
                    System.out.println("The first place runner is " + runner3 + "\nThe second place runner is "
                            + runner1 + "\nThe third place runner is " + runner2 + ".");
                }
                else
                {
                    System.out.println("The first place runner is " + runner3 + "\nThe second place runner is "
                            + runner2 + "\nThe third place runner is " + runner1 + ".");
                }
            }
        }
}