
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * Dummies Games
 */

/**
 *
 * @author 312679
 */
public class Ball {
    private Color color;
    private float x,y,dx,dy;
    private int size;
    
    public Ball(float x, float y, float dx, float dy, int size, Color color){
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
        this.size=size;
        this.color=color;        
    }
        
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)x,(int)y,size,size);
    }
    
    public void move(Rectangle bounds){
        //add velocity dx and dy to get new position
        
    }
}
