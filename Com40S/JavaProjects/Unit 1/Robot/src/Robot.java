//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics2D;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
       //Graphics2D g = (Graphics2D)window;
      window.setColor(Color.BLUE);
      
      window.drawString("Robot LAB ", 35, 35 );

      //call head method
      head(window);
      //call other methods
      upperBody(window);
      lowerBody(window);
      Graphics2D g = (Graphics2D)window;
      sun(g);
   }

   public void head( Graphics window )
   {
      window.setColor(Color.YELLOW);

      window.fillOval(300, 100, 200, 100);
      
      window.setColor(Color.GREEN);
      window.fillOval(340, 120, 25, 25);
      window.fillOval(430, 120, 25, 25);
      window.setColor(Color.BLACK);
      window.fillOval(390, 145, 18, 12);
      window.setColor(Color.RED);
      //drawArc(int x,int y,int width,int height, int startAngle,int arcAngle)
      window.drawArc(342, 160, 110, 30, 185, 180);


		//add more code here
				
   }

   public void upperBody( Graphics window )
   {
       window.setColor(Color.BLUE);
       window.fillRect(340, 225, 115, 80);
       window.setColor(Color.RED);
       window.drawRect(340, 225, 115, 80);
       
       window.setColor(Color.BLACK);
       window.drawLine(340, 225, 250, 175);
       window.drawLine(455, 225, 560, 175);
		//add more code here
   }

   public void lowerBody( Graphics window )
   {
       window.setColor(Color.GRAY);
       window.fillRect(340, 320, 115, 80);
       window.setColor(Color.RED);
       window.drawRect(340, 320, 115, 80);
       
       window.setColor(Color.BLACK);
       window.drawLine(340, 400, 250, 480);
       window.drawLine(455, 400, 532, 480);
		//add more code here

   }
   
   public void sun ( Graphics2D window)
   {
       //write code to draw a sun
       window.setStroke(new BasicStroke(10));
       window.drawLine(455, 400, 532, 480);
       window.fillOval(100, 100, 200, 300);
   }
}