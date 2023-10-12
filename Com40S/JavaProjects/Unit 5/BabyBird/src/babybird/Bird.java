package babybird;

import commonmethods.FileIO;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author 312679-shruti panchal
 */
public class Bird {

    private static final String BIRD_FLAP_UP = "babyBirdFlapUp.gif";
    private static final String BIRD_FLAP_DOWN = "babyBirdFlapDown.gif";
    private static final String BIRD_FLAP_GLIDE = "babyBirdGlide.gif";
    private static final int FLAP_UP = 0;
    private static final int FLAP_GLIDE = 1;
    private static final int FLAP_DOWN = 2;
    private BufferedImage[] birds = new BufferedImage[3];
    private int width, height, x = 10, y = 10, panelHeight;
    private int flap = FLAP_GLIDE;
    private boolean flapping = false;
    private static final float GRAVITY = 0.5f;
    private float changeY = 0;
    private static final int FLAP_FORCE = -8;

    public Bird(int h) {
        birds[FLAP_UP] = FileIO.readImageFile(this, BIRD_FLAP_UP);
        birds[FLAP_DOWN] = FileIO.readImageFile(this, BIRD_FLAP_DOWN);
        birds[FLAP_GLIDE] = FileIO.readImageFile(this, BIRD_FLAP_GLIDE);
        width = birds[FLAP_UP].getWidth();
        height = birds[FLAP_UP].getHeight();
        panelHeight = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getChangeY() {
        return (int)changeY;
    }
        
    public void startFlapping() {
        flapping = true;
        changeY = FLAP_FORCE;
    }

    public BufferedImage getImage() {
        return birds[FLAP_GLIDE];
    }
 
    public void move() {

        int changeYInt = (int) changeY;
        int distanceFromTop = y + height + changeYInt;
        
        
        if (distanceFromTop > panelHeight) {
            y = panelHeight - height;
            changeY = 0;
        } else {
            y += changeY;
            changeY += GRAVITY;
            if (changeY > 0) {     
                flapping = false;
            } 
        }

        if (flapping) {
            flap++;
            flap %= 3;  //when flap=3 it becomes 1
        } else {
            flap = FLAP_GLIDE;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(birds[flap], x, y, null);
    }
    
    public Rectangle getBounds() {
        Rectangle bounds = new Rectangle(x,y,width,height);
        return bounds;
    }

}
