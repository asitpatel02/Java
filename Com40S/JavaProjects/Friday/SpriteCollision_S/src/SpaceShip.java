
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class SpaceShip{
    //instance
    private int w, h; 
    private Image image;
    private int dx, dy;
    private int x=40, y=60;
    private Missile misile;
    private ArrayList<Missile> missiles;
    

    private void loadImage() {//helper method
        
        ImageIcon ii = new ImageIcon("src/spaceShip.png");
        image = ii.getImage();
        
        w = image.getWidth(null);
        h = image.getHeight(null);
        
    }
    
    public SpaceShip() {
        //super(x, y);
        loadImage();
        missiles=new ArrayList<>();
    }
    
                            ///////////////////////////////////////////////////

      public void fire() {
        missiles.add(new Missile(x+w,y+h/2));
    }
      
    public ArrayList<Missile>  getMissile(){
        return missiles;
    }
    
    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
                            ///////////////////////////////////////////////////
    public void move() {
        x+=dx;
        y+=dy;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT){ dx =-2;}
        if (key == KeyEvent.VK_RIGHT){ dx =2;}
        if (key == KeyEvent.VK_UP){ dy =-2;}
        if (key == KeyEvent.VK_DOWN){ dy =2;}     
        
         if (key == KeyEvent.VK_SPACE){
                fire();
            }
        
    }
    public void keyReleased(KeyEvent e) {
        //int key = e.getKeyCode();        
//        if (key == KeyEvent.VK_LEFT){ dx =0;}
//        if (key == KeyEvent.VK_RIGHT){ dx =0;}
//        if (key == KeyEvent.VK_UP){ dy =0;}
//        if (key == KeyEvent.VK_DOWN){ dy =0;}               
        dx=0;
        dy=0;     

    }
    
    public Rectangle getBounds(int x,int y){
        Rectangle rect = new Rectangle(x,y);
        return rect;
    }
    
    
    
}
