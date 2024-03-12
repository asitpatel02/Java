package Assignments_5;

import java.util.Random;

public class Coin {

    // private string statement
    private String sideUp;

    // toss method
    public void toss(){

        // random number generate
        Random random = new Random();

        // integer variable
        int randomNumber;

        // random number generate only 0 and 1
        randomNumber = random.nextInt(2);

        // if statement
        if (randomNumber == 0){
            // if random number are 0 then print tails
            sideUp = "tails";
        } else {
            // else random number are 1 then print heads
            sideUp = "heads";
        }
    }

    // get string method
    public String getSideUp(){
        return sideUp;
    }

    // class call
    public Coin(){
        toss();
    }
}