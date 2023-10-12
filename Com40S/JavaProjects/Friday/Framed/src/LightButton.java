
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class LightButton extends JButton {

    private static final int MAX_SIZE = 50;
    private int row = 0, col = 0;
    //private boolean isLit;

    public LightButton(int r, int c) {
        row = r;
        col = c;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(MAX_SIZE, MAX_SIZE));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isLit() {
        Color color = getBackground();
        return (color.equals(Color.CYAN));
    }

    public void turnOn() {
        setBackground(Color.CYAN);
    }

    public void turnOff() {
        setBackground(Color.BLACK);
    }

    public void toggle() {
        if (isLit()) { 
            turnOff();
        } else {
            turnOn();
        }
    }

}
