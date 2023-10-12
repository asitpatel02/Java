
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class Missile extends Sprite {

    private final int BOARD_WIDTH = 800;
    private final int MISSILE_SPEED = 15;

    public Missile(int x, int y) {
        super(x, y);
        initMissile();
    }

    public void initMissile() {
        String[] s = new String[5];
        s[0] = "src/m.png";
        s[1] = "src/m1.png";
        s[2] = "src/m2.png";
        s[3] = "src/m3.png";
        s[4] = "src/m4.png";

        int i = (int) ((4 - 0 + 1) * Math.random() + 0);
        loadImage(s[i]);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    public void move() {
        x += MISSILE_SPEED;
        if (x >= BOARD_WIDTH) {
            visible = false;
        }

    }
}
