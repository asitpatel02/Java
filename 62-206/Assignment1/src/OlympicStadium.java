/*
 4. You are in the Olympic stadium in Beijing and are playing a game with your friend:
    of the stairs(step 50 out of 100); the winner is the person who gets to the top first. if you get to the bottom you are out. You can quit whenever you want, this program keeps track
    of your position, asks if you still want to play, tells you if you reach at the top or at the bottom and tosses the coin for you.

    Name : Asit Patel
    Student ID : 190309
 */

import java.util.Random;
import java.util.Scanner;



public class OlympicStadium {
    public static void main(String[] args) {
        //variable declaration
        int a,b=0, player1 = 50,player2 = 50, count = 0;
        String[] toss ={"Head","Tail"};
        Scanner scanner=new Scanner(System.in);

        //Rules for the game
        System.out.println("TOSS UP GAME");
        System.out.println("Player 1 is you");
        System.out.println("If coin toss is head then move two step up");
        System.out.println("If coin toss is tail then move one step up");
        System.out.println("First to reach 100 is the winner");
        System.out.println("Starting position is 50 for all");

        while(b==0) {
            // counter
            count++;
            System.out.println ();
            System.out.println ("You played this game: " + count);

            //player 1 turn
            Random random = new Random();
            System.out.println("----- Player 1 Turn -----");
            System.out.print("Toss: ");

            a = random.nextInt(2);//player 1 toss
            System.out.println(toss[a]);

            //necking for head or tail

            if(toss[a].equalsIgnoreCase("Head")) {
                player1 = player1 + 2;
                System.out.println("Player 1 position "+player1);
            }

            if(toss[a].equalsIgnoreCase("Tail")) {
                player1 = player1 - 1;
                System.out.println("Player 1 position "+player1);
            }

            //player 2 turn
            System.out.println("----- Player 2 Turn -----");
            System.out.print("Toss: ");

            a = random.nextInt(2);
            System.out.println(toss[a]);

            // head or tail
            if(toss[a].equalsIgnoreCase("Head")) {
                player2 = player2 + 2;
                System.out.println("Player 2 position "+player2);
            }

            if(toss[a].equalsIgnoreCase("Tail")) {
                player2 = player2 - 1;
                System.out.println("Player 2 position "+player2);
            }
    
            System.out.println ();

            //necking if player retained 100;
            if(player1>100) {
                System.out.println("Player 1 is the winner");
                System.out.println ();
                break;
            }

            if(player2>100) {
                System.out.println("Player 2 is the winner");
                System.out.println ();
                break;
            }

            //asking if the user wants to continue the game
            System.out.print("Do you want to continue 0:Yes 1:No ");
            b = scanner.nextInt();

            System.out.println ();
            System.out.println ();
        }
    }
}