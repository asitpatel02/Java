import java.util.Random;

public class lab9Q2 {

    public static boolean isEven(int num){
        if ((num % 2) == 0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        int randnumGenerated;
        int numOfEvenNumber = 0;
        int numOfOddNumber = 0;

        for (int currentNumber = 1; currentNumber <=100; currentNumber++){
            randnumGenerated = random.nextInt(10) + 1;
            if (isEven(randnumGenerated)){
                numOfEvenNumber += 1;
            } else {
                numOfOddNumber += 1;
            }
        }
        System.out.println("There were " + numOfEvenNumber + " even numbers and " + numOfOddNumber + " odd numbers");
    }
}
