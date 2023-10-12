
import java.awt.Rectangle;


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
        loadImage("src/missile.png");
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    public void move() {
        x+=MISSILE_SPEED;
        if (x>=BOARD_WIDTH) {
            visible = false;      
        }
        
    }
}