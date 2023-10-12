import gpdraw.DrawingTool;
import gpdraw.SketchPad;

import java.awt.*;

/*
 * using gpdraw library to make a square
 */

/**
 *
 * @author 312679
 */
public class DrawSquare {
    
    //instance vars
    private DrawingTool myPencil;
    private SketchPad myPaper;
    
    //constructor
    public DrawSquare(){
        //create the objects
        myPaper = new SketchPad(350,350);//width,height,delay
        myPencil = new DrawingTool(myPaper);
    }//end constructor
    
    //method
    /**
     * aldkjglkjljlkj
     */
    public void draw(){
        
        myPencil.forward(100);
        myPencil.setColor(Color.red);
        myPencil.turnRight();
        myPencil.forward(100);
        myPencil.turnRight();
        myPencil.forward(100);
        myPencil.turnRight();
        myPencil.forward(100);
        
        myPencil.up();
        myPencil.forward(100);
        myPencil.down();
        myPencil.setColor(Color.pink);
        myPencil.drawCircle(50);
        
        myPencil.up();
        myPencil.turnLeft();
        myPencil.forward(100);
        myPencil.turnLeft();
        myPencil.down();
        myPencil.setColor(Color.green);
        myPencil.fillOval(55,25);
        
        myPencil.up();
        myPencil.turnLeft();
        myPencil.forward(200);
        myPencil.down();
        myPencil.setColor(Color.black);
        myPencil.drawString("hello");
        
        myPencil.up();
        myPencil.turnRight();
        myPencil.forward(10);
        myPencil.down();
        myPencil.drawCircle(50);
        
        myPencil.up();
        myPencil.turnRight();
        myPencil.forward(200);
        myPencil.turnLeft();
        myPencil.forward(100);
        myPencil.down();
        myPencil.setWidth(15);
        myPencil.setColor(Color.blue);
        myPencil.drawCircle(65);
        myPencil.setDirection(110);
        myPencil.forward(25);
        
        
        
    }
    
    public static void main(String[] args) {
        DrawSquare sq = new DrawSquare();
        sq.draw();
    }
}
