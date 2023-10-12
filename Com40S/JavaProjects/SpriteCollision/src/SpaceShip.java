
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author 312679-Shruti Panchal
 */
//spaceship extends sprite
public class SpaceShip extends Sprite {

    //instance
//    private int w, h;
//    private Image image;
//    private int dx, dy;
//    private int x = 40, y = 60;
//    private Missile misile;
    private ArrayList<Missile> missiles;
//    private boolean visible;

    private void loadImage() {//helper method

        ImageIcon ii = new ImageIcon("src/spaceShip.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);

    }

    public SpaceShip(int x, int y) {
        super(x, y);
        loadImage();
        missiles = new ArrayList<>();
        visible = true;
        gamePaused = false;
        gamePauseOver = false;
    }

    ///////////////////////////////////////////////////
    public void fire() {
        missiles.add(new Missile(x + w, y + h / 2));
        getBounds();
    }

    public ArrayList<Missile> getMissiles() {
        return missiles;
    }
//    public int getW() {
//        return w;
//    }
//    public int getH() {
//        return h;
//    }
//    public Image getImage() {
//        return image;
//    }
//    public int getX() {
//        return x;
//    }
//    public int getY() {
//        return y;
//    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    ///////////////////////////////////////////////////
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
        if (key == KeyEvent.VK_P) {
            if (gamePaused) {
                gamePaused = false;
                gamePauseOver = true;
            } else {
                gamePaused = true;
                gamePauseOver = false;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        dx = 0;
        dy = 0;

    }

    public void move() {
        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }
        if (y < 1) {
            y = 1;
        }
//restrict the ship going outside the screen
        if (y > 500) {
            y = 500;
        }

        if (x > 680) {
            x = 680;
        }
    }

}
