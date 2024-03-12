package Assignment_1;

import java.util.Random;

public class Lottery_Application {

    private final int [] LotteryNumbers; // lottery numbers
    private int [] UserLotteryNumbers; // enter by user lottery number

    public void GetUserLotteryNumbers(int [] UserLotteryNumberGiven){
        UserLotteryNumbers = UserLotteryNumberGiven;
    } // close GetUserLotteryNumbers

    public int [] GetLotteryNumber(){
        return LotteryNumbers;
    } // close GetLotteryNumber

    // compare lottery number between random generation and enter by user
    public int []   CompareLotteryNumber(){
        int [] MatchedNumbers = new int[LotteryNumbers.length]; //0 0 0 0 0

        for (int CurrentMatchedNumberIndex = 0; CurrentMatchedNumberIndex < MatchedNumbers.length; CurrentMatchedNumberIndex++){
            MatchedNumbers[CurrentMatchedNumberIndex] = -1;// -1 -1 -1 -1 -1
        } //close for loop

        for (int CurrentUserLotteryNumberIndex = 0; CurrentUserLotteryNumberIndex < UserLotteryNumbers.length; CurrentUserLotteryNumberIndex++){
            if (UserLotteryNumbers[CurrentUserLotteryNumberIndex] == LotteryNumbers[CurrentUserLotteryNumberIndex]){
                MatchedNumbers[CurrentUserLotteryNumberIndex] = UserLotteryNumbers[CurrentUserLotteryNumberIndex];
            } //close if statement
        } // close for loop
        return MatchedNumbers;
    } // close CompareLotteryNumber

    public Lottery_Application(int NumberOfLotteryNumbers){

        // random generator
        Random random = new Random();

        LotteryNumbers = new int [NumberOfLotteryNumbers];

        for (int CurrentLotteryNumberIndex = 0; CurrentLotteryNumberIndex < LotteryNumbers.length; CurrentLotteryNumberIndex++){
            LotteryNumbers[CurrentLotteryNumberIndex] = random.nextInt(10);
        } // close for loop
    } // close Lottery_Application
} // close Lottery_Application class
