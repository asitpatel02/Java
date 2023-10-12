
import java.awt.Rectangle;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 312679
 */
public class Alien extends Sprite {

    private final int ALIEN_SPEED = 15;
    private final int INITIAL_X = 800;

    public Alien(int x, int y) {
        super(x, y);
        initAlien();       
    }

    public void initAlien() {
        loadImage("src/pumpkin.png");
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;

    }
}
