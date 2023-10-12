
import components.TitleLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * click rules::
    corner lights toggles the four lights in that corner
    clicking a middle side lights that column
    clicking the center lights all above below left and right(center column and row)
*Goal::
    light everything exept the center
 */
/**
 *
 * @author 312679- Game:: Framed:)
 */
public class Framed extends JFrame {

    private static final int GRID_SIZE = 3;
    private LightButton lightButton[][];

    public Framed() {
        setTitle("Framed");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();
        newGame();
        pack();
    }

    private void initGUI() {
        //title label
        TitleLabel titleLabel = new TitleLabel("Framed");
        add(titleLabel, BorderLayout.PAGE_START);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        add(centerPanel, BorderLayout.CENTER);
        lightButton = new LightButton[GRID_SIZE][GRID_SIZE];
        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
                lightButton[r][c] = new LightButton(r, c);
                lightButton[r][c].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet.");
                        LightButton button = (LightButton) e.getSource();
                        int row = button.getRow();
                        int col = button.getCol();
                        if (!checkWin()) {
                            toggleLights(row, col);
                        }
//                        else {
//                            System.out.println("You win!!!!!");
//                        }
                    }
                });
                centerPanel.add(lightButton[r][c]);
            }
        }
    }

    public boolean checkWin() {
        int win = 0;
        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
                if ((lightButton[r][c].isLit()) && !(lightButton[1][1].isLit())) {
                    win++;
                    //System.out.println("lit");
                }
            }
        }
        if (win == 8) {
            System.out.println("You win!!!");
        }
        return (win == 8);
    }

    private void toggleLights(int row, int col) {
        int r = row, c = col;
        lightButton[r][c].toggle();
        //top left corner
        if (r == 0 && c == 0) {
            lightButton[r][c + 1].toggle();
            lightButton[r + 1][c].toggle();
            lightButton[r + 1][c + 1].toggle();
//            for (int i = 0; i < GRID_SIZE / 2; i++) {
//                r++;
//                c++;
//                lightButton[row][c].toggle();
//                lightButton[r][col].toggle();
//                lightButton[r][c].toggle();
//            }
        }//top right corner
        if (r == 0 && c == 2) {
            lightButton[r][c - 1].toggle();
            lightButton[r + 1][c].toggle();
            lightButton[r + 1][c - 1].toggle();
        } // bottom left corner
        else if (r == 2 && c == 0) {
            lightButton[r][c + 1].toggle();
            lightButton[r - 1][c + 1].toggle();
            lightButton[r - 1][c].toggle();
        } // bottom right corner
        else if (r == 2 && c == 2) {
            lightButton[r][c - 1].toggle();
            lightButton[r - 1][c - 1].toggle();
            lightButton[r - 1][c].toggle();
        } // top row middle
        else if (r == 0 && c == 1) {
            lightButton[r][c + 1].toggle();
            lightButton[r][c - 1].toggle();
        } // bottom row middle
        else if (r == 2 && c == 1) {
            lightButton[r][c + 1].toggle();
            lightButton[r][c - 1].toggle();
        } // left col middle
        else if (r == 1 && c == 0) {
            lightButton[r + 1][c].toggle();
            lightButton[r - 1][c].toggle();
        } // right col middle
        else if (r == 1 && c == 2) {
            lightButton[r + 1][c].toggle();
            lightButton[r - 1][c].toggle();
        }// center
        else if (r == 1 && c == 1) {
            lightButton[r][c + 1].toggle();
            lightButton[r][c - 1].toggle();
            lightButton[r + 1][c].toggle();
            lightButton[r - 1][c].toggle();
        }
        checkWin();
    }

    private void newGame() {
        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
                lightButton[r][c].toggle();
            }
        }
        lightButton[1][1].toggle();
        Random rand = new Random();
        int numberOfTimes = rand.nextInt(20 - 10) + 10;
        //System.out.println(numberOfTimes);
        for (int i = 0; i < numberOfTimes; i++) {
            int row = rand.nextInt(GRID_SIZE);
            int col = rand.nextInt(GRID_SIZE);
            //System.out.println(row+";"+col);
            toggleLights(row, col);
        }

    }

    public static void main(String[] args) {
        new Framed();
    }

}
