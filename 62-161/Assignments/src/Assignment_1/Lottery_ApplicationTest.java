package Assignment_1;

import java.util.Scanner;

public class Lottery_ApplicationTest {

    // start main method
    public static void main(String[] args) {

        // Variables
        final int Number_Of_Lottery_Number = 5;
        Scanner input = new Scanner(System.in);
        int UserLotteryNumber;
        int [] UserLotteryNumbers = new int [Number_Of_Lottery_Number];
        int [] MatchedNumbers;
        int [] LotteryNumbers;
        int NumberOfMatchedNumbers = 0;

        Lottery_Application WorldLottery = new Lottery_Application(Number_Of_Lottery_Number);

        for (int CurrentLotteryNumberIndex = 0; CurrentLotteryNumberIndex < Number_Of_Lottery_Number; CurrentLotteryNumberIndex++){
            System.out.print("Please Enter Lottery Number " + (CurrentLotteryNumberIndex+1) + " : ");
            UserLotteryNumber = input.nextInt();
            UserLotteryNumbers[ CurrentLotteryNumberIndex ] = UserLotteryNumber;
        } // close for loop

        WorldLottery.GetUserLotteryNumbers(UserLotteryNumbers);
        MatchedNumbers = WorldLottery.CompareLotteryNumber();
        LotteryNumbers =  WorldLottery.GetLotteryNumber();

        // print lottery numbers from random numbers
        System.out.println("Today's Lottery Numbers are: ");
        for (int lotteryNumber : LotteryNumbers) {
            System.out.print(lotteryNumber + " ");
        }

        System.out.println();
        //display user enter lottery number
        System.out.println("Your Numbers are: ");
        for (int userLotteryNumber : UserLotteryNumbers) {
            System.out.print(userLotteryNumber + " ");
        }

        System.out.println();

        // try to match number between enter by user and generate by random number
        System.out.println("Matched Numbers: ");
        for (int CurrentMatchedNumberIndex = 0; CurrentMatchedNumberIndex < MatchedNumbers.length; CurrentMatchedNumberIndex++){
            if (MatchedNumbers[CurrentMatchedNumberIndex] !=-1 ){
                System.out.println(MatchedNumbers[CurrentMatchedNumberIndex] + " ( Slot "+ (CurrentMatchedNumberIndex + 1) + "), ");
                NumberOfMatchedNumbers = NumberOfMatchedNumbers +1;
            }// close if
        }// close for loop

        if (NumberOfMatchedNumbers == Number_Of_Lottery_Number){
            System.out.println("You're a GRAND PRIZE WINNER. you matched all numbers and won $1 million dollars. now go and enjoy!");
        }else if(NumberOfMatchedNumbers == 1) {
            System.out.println("You matched " + NumberOfMatchedNumbers + " number.");
        }else {
            System.out.println("You matched " + NumberOfMatchedNumbers + " numbers.");
        }
    } // close main method
} // close class