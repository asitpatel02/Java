import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/*
 * FRIDAY GAME-Pong
 */
/**
 *
 * @author 312679- Oct 12 2018
 * //logical operation-&&,||,!//relational operators-<,>,<=,>=,=,!=//
 */
public class Pong extends JComponent implements
        ActionListener, MouseMotionListener, KeyListener {
    //import and implement
    
    private int paddleY;
    private int paddleX;
    private int paddleY2;
    private int paddleX2;
    private int ballY;
    private int ballX;
    private int ballYSpeed;
    private int ballXSpeed;
    private int score;
    private int score2;
    private boolean gameOver;

    public Pong() {
        paddleY = 510;
        paddleX = 0;
        paddleY2 = 10;
        paddleX2 = 15;
        ballY = 280;
        ballX = (int)((770-15+1)*Math.random()+15);
        ballYSpeed = 10;
        ballXSpeed = 8;
        score = 0;
        score2 = 0;
        gameOver = false;
        
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Pong Game");
        Pong game = new Pong();
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);

        //timer listener
        Timer t = new Timer(50, game);
        t.start();

        //mouse listener
        window.addMouseMotionListener(game);
        window.addKeyListener(game);
        
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //draw the sky
        g.setColor(new Color(143, 239, 214));
        g.fillRect(0, 0, 800, 600);

        //draw the paddle        
        g.setColor(new Color(110, 61, 23));
        g.fillRect(paddleX, paddleY, 150, 15);
        //2nd paddle
        g.fillRect(paddleX2, paddleY2, 150, 15);

        //draw the ball    
        g.setColor(new Color(136, 77, 255));
        g.fillOval(ballX, ballY, 30, 30);
        
        //draw the score
        g.setColor(new Color(0, 51, 102));
        g.setFont(new Font("ComicSans",Font.PLAIN, 30));
        g.drawString(("P1 Score: "+score), 25, 550); 
        g.drawString(("P2 Score: "+score2), 25, 50); 
        if (gameOver==true){
            g.setFont(new Font("ComicSans",Font.BOLD,60));
            g.drawString(("GAME OVER"), 220, 315); 
        }
        
    }

    //timer code
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        
        if (ballY >= paddleY+15 || ballY <= 5){
            gameOver=true;
        }
        if (gameOver==false){
            ballX += ballXSpeed;
            ballY += ballYSpeed;
            
         
        if (ballY >= paddleY-30 && ballX<= paddleX + 150 && ballY >=150) { 
            ballYSpeed *= -1;//&&=and
            score+=1; 
        }
        if (ballX >=800-30) {
            ballXSpeed *= -1;
        }
//        if (ballY<=0) {
//            ballYSpeed *= -1;
//        }
        if (ballX<=0) {
            ballXSpeed *= -1;
        }           
        }        
        if (ballY <= paddleY2 && ballX <= paddleX2+150 && ballX >= paddleX2){
            ballYSpeed *= -1;
            score2+=1;
        }
            repaint();
        
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        //left click and drag - click and drag
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        if (!gameOver) {
            paddleX = e.getX() - 75;
        }
        
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        if (!gameOver) {
            if (paddleX2 > -75){
        if (e.getKeyCode()==KeyEvent.VK_LEFT) {
            paddleX2 -=10;
        }
        }
        if (paddleX2 < 775){
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
            paddleX2 +=10;
        }
        }
        }
        
                
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
        
                //repaint();
    }
}
