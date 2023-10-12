
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JApplet;

/**
 *
 * @author 312679-SHRUTI PANCHAL
 */
public class BallBounce extends JApplet {

    Random rand = new Random();
    private int r;// = rand.nextInt();
    private int gr;// = rand.nextInt();
    private int b;// = rand.nextInt();
    Color randomColor;
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    
    private int x=100;
    private int y=150;
    private int xVel=1;
    private int yVel=1;
    
    
    public void init() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        //g.fillOval(10, 10, 20, 20);

//        for (int i = 0; i < 200; i+=25) {
//            r = rand.nextInt();
//            gr = rand.nextInt();
//            b = rand.nextInt();            
//            randomColor = new Color(r, gr, b);
//            
//            g.setColor(new Color((int)(Math.random() * 0x1000000)));
//            g.fillOval(10 + i, 10 + i, 20, 20);
//        }
//
        for (int i=0; i<2000; i++) {
            //erase old ball
            g.setColor(Color.WHITE);
            g.fillOval(x, y, 20, 20);
            
            //find a new location
            x+=xVel;
            y+=yVel;
            
            //bounce
            //right side
            if (x>300) {
                xVel = -1*xVel;
                //g.setColor(new Color((int)(Math.random() * 0x1000000)));
            }
            //left side
            if (x<50)xVel = -1*xVel; 
            //g.setColor(new Color((int)(Math.random() * 0x1000000)));
            
            //top and botton
            if (y<5||y>150)yVel = -1*yVel;  
            //g.setColor(new Color((int)(Math.random() * 0x1000000)));
                
            //draw the new ball
                        
            if ((i%10)==0) {
                g.setColor(new Color((int)(Math.random() * 0x1000000)));
            }            
            g.fillOval(x, y, 20, 20);
            
            //slow down in a cheesy way
            for (int j=0; j< 400; j++){              
                System.out.println(x+" "+y);
            }
            
        }
    }//end paint

}//End class
