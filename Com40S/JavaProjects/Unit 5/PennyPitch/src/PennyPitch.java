
import java.util.Scanner;
/**
 *
 * @author 312679-shruti panchal
 */
public class PennyPitch {

    private String[][] board;

    public PennyPitch() {
        board = new String[5][5];
        initBoard();
    }

    public void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "";
            }
        }
    }

    public void randPrizes(String prize) {
        for (int i = 0; i < 3; i++) {
            int r = (int) ((3 - 0 + 1) * Math.random() + 0);
            int c = (int) ((4 - 0 + 1) * Math.random() + 0);
            while (!board[r][c].equals("")) {
                r = (int) ((4 - 0 + 1) * Math.random() + 0);
                c = (int) ((4 - 0 + 1) * Math.random() + 0);
            }
            board[r][c] = prize;
        }
    }

    public void drawBoard() {
        randPrizes(" Puzzle");
        randPrizes("Poster");
        randPrizes("  Ball ");
        randPrizes(" Doll ");
        randPrizes(" Game");
        pennyToss();
        for (int i = 0; i < board.length; i++) {
            //System.out.println("[");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("[");
                System.out.format("%-7s", board[i][j]);
                System.out.print("]");
            }
            System.out.println("");
        }
        prizeWon();
    }

    public void pennyToss() {
        for (int i = 0; i < 10; i++) {
            int r = (int) ((4 - 0 + 1) * Math.random() + 0);
            int c = (int) ((4 - 0 + 1) * Math.random() + 0);
            while (board[r][c].contains("@")) {
                r = (int) ((4 - 0 + 1) * Math.random() + 0);
                c = (int) ((4 - 0 + 1) * Math.random() + 0);
            }
            //board[r][c] = "@" + board[r][c];
            //board[r][c].charAt(0)='@';
            board[r][c]="@" +board[r][c].trim();
        }
    }

    public void prizeWon() {

        int z = 0, d = 0, b = 0, g = 0, p = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j].contains("@Puzzle")) {
                    //System.out.println("Puzzle");
                    z++;
                }
                if (board[i][j].contains("@Poster")) {
                    //System.out.println("Poter");
                    p++;
                }
                if (board[i][j].contains("@Ball")) {
                    //System.out.println("Ball");
                    b++;
                }
                if (board[i][j].contains("@Doll")) {
                    //System.out.println("Doll");
                    d++;
                } else if (board[i][j].contains("@Game")) {
                    //System.out.println("Game");
                    g++;
                }//end ifs               
            }
        }//end fors

        if (z == 3) {
            System.out.println("Won Puzzle");
        }
        if (d == 3) {
            System.out.println("Won Doll");
        }
        if (b == 3) {
            System.out.println("Won Ball");
        }
        if (p == 3) {
            System.out.println("Won Poster");
        }
        if (g == 3) {
            System.out.println("Won Game");
        }
        if (z < 3 && p < 3 && b < 3 && d < 3 && g < 3) {
            System.out.println("Won Nothing");
        }

    }

    public static void main(String[] args) {
        PennyPitch p1 = new PennyPitch();
        p1.drawBoard();        
    }
}

