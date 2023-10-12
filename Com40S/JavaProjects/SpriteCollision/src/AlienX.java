
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shruti
 */
public class AlienX extends Alien{

    private final int INITIAL_X = 800;
    
    public AlienX(int x, int y) {
        super(x, y);
    }
    
    public String image() {
        return "src/asteroid.gif_c200";
    }
    
    public void initAlienX() {
        loadImage(image());
    }        

    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 3;

    }
}
