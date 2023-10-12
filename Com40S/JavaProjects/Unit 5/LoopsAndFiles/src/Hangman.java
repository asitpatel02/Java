
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 312679-shruti panchal
 */
public class Hangman {

    private String word, guess = "", guessLetters = "";
    private char[] wordArr;
    private char[] wordShow;
    private char c;
    private boolean running;
    private int stickManLife;
    private String[][] stickMan;

    public Hangman() {
        init();
    }

    public void init() {
        word = getRandomWord(fileName(pickTheme()));
        wordArr = word.toCharArray();
        //System.out.println(wordArr);
        wordShow = new char[wordArr.length];
        running = false;
        stickManLife = 0;
        stickMan = new String[][]{
            {" ", "_", "_", "_", "_", "_", "_", " "},
            {" ", "|/", "", " ", " ", " ", "|", " "},
            {" ", "|", " ", " ", " ", " ", " ", " "},
            {" ", "|", " ", " ", " ", " ", " ", " "},
            {" ", "|", " ", " ", " ", " ", " ", " "},
            {" ", "|", " ", " ", " ", " ", " ", " "},
            {" ", "|", " ", " ", " ", " ", " ", " "},
            {" ", "|", " ", " ", " ", " ", " ", " "},
            {" ", "|", " ", " ", " ", " ", " ", " "},
            {"=", "=", "=", " ", " ", " ", " ", " "},};
    }

    public void drawBody() {
        switch (stickManLife) {
            case 7:
                stickMan[6][5] = "\\";
            case 6:
                stickMan[6][5] = "/";
            case 5:
                stickMan[5][6] = "|";
            case 4:
                stickMan[4][6] = "|";
            case 3:
                stickMan[3][7] = "\\";
            case 2:
                stickMan[3][5] = "/";
            case 1:
                stickMan[2][6] = "O";
                break;
        }

    }

    public String getRandomWord(String file) {
        FileReader fr = new FileReader(file);
        return fr.rndWord();
    }

    public void showWord() {
        for (int i = 0; i < wordShow.length; i++) {
            wordShow[i] = '_';
        }
        System.out.print("The word is...  ");
        System.out.println(wordShow);
        running = true;
    }

//    private void showWord(char[] c) {        
//        System.out.println(c);
//    }
    public void inputGuess() {
        boolean life = true;
        Scanner in = new Scanner(System.in);
        System.out.print("Make a Guess:: ");
        guess = in.next().toUpperCase();

        if (guess.length() > 1) {
            System.out.println("invalid input");
            inputGuess();
        } else {
            c = guess.charAt(0);
            if (c < 'A' || c > 'Z') {
                System.out.println("invalid input");
                inputGuess();
            } else {
                if (guessLetters.contains(guess)) {
                    System.out.println("used letter");
                    inputGuess();
                } else {
                    for (int i = 0; i < wordArr.length; i++) {
                        if (wordArr[i] == c) {
                            wordShow[i] = c;
                            life = false;
                        } else if (!life == false) {
                            life = true;
                        } //stickManLife++;
                        //System.out.println(stickManLife);
                        //return;
                    }
                    if (life) {
                        stickManLife++;
                    }
                }
                guessLetters += guess;
                System.out.println(wordShow);
//                checkWin();

            }
        }
    }//end inputGuess

    public void checkWin() {
        int correct = 0;
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] == wordShow[i]) {
                correct++;
            }
        }
        if (correct == wordArr.length) {
            System.out.println("you win");
            running = false;
        } else if (stickManLife == 7) {
            System.out.println("you lose");
            running = false;
        }
//        else {
//            inputGuess();
//        }
    }

    public void showUsedLetters() {
        if (guessLetters == "") {

        } else {
            System.out.println("Guessed Letters:: " + guessLetters);
        }
    }

    public void gameLoop() {
        while (running) {
            drawBody();
            for (int r = 0; r < 10; r++) {
                for (int c = 0; c < 8; c++) {
                    System.out.print(stickMan[r][c]);
                }
                System.out.println("");
            }
            //System.out.println(wordShow);
            showUsedLetters();
            inputGuess();
            checkWin();
        }
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return getWord();
    }

    public int pickTheme() {
        Scanner in = new Scanner(System.in);
        System.out.print("0: random\n1: countries\nPick a Theme::");
        return in.nextInt();
    }

    public String fileName(int i) {
        switch (i) {
            case 0:
                return "src/data.dat";
//            break;
            case 1:
                return "src/countries.dat";
//            break;
            default:
                System.out.println("Invalid choice: Choosing random");
                return "src/data.dat";
//            break;
        }
    }

    public static void main(String[] args) {
        Hangman hm = new Hangman();
        System.out.println(hm);
        hm.showWord();
        hm.gameLoop();
    
    }
}
