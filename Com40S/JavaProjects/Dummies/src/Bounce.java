/*
*Dummies chapter 1: follow the bouncing ball
*/

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author 312679
 */
public class Bounce extends Applet implements Runnable{
//instance variables(globle)
    private Thread ticker;
    private boolean running = false;
    
    private Ball ball;
    private int width,height;
    
    private Image offScreenImage;
    private Graphics offscr;
        
    
    public void init() {
        //width=size().width;
        //height=size().height;
        ball= new Ball(100,20,1.5f,2.3f,12,Color.RED);
    }

    public void paint(Graphics g){
        offScreenImage=createImage(400,400);
        offscr=offScreenImage.getGraphics();
                
        ball.draw(offscr);
        g.drawImage(offScreenImage, 0, 0, null);
        
    }
    
    public void update(Graphics g){
        paint(g);
    }

    @Override
    public void run() {
        while (running){
            repaint();
        }
        try {
            ticker.sleep(1000/15);
            
        }
        catch (InterruptedException e){}
        
    }//end run
    
    public synchronized void start(){
        if (ticker==null || !ticker.isAlive()){
            running=true;
            ticker=new Thread(this);
            ticker.setPriority(Thread.MIN_PRIORITY+1);
            ticker.start();
        }
    }//end start
    
    public synchronized void stop(){
        running=false;
    }//end stop
    
}
