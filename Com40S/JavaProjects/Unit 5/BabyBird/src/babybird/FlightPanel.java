package babybird;

import commonmethods.FileIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.FontMetrics;

/**
 *
 * @author 312679-shruti panchal
 */
public class FlightPanel extends JPanel {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    private static final int SEPARATION = 40;
    private static final String THUD = "thud.wav";
    private BabyBird babyBird;
    private Bird bird = new Bird(HEIGHT);
    private Timer timer;
    private int count = 0;
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private FontMetrics fm;
    private static final Font BIG_FONT = new Font(Font.DIALOG, Font.BOLD, 30);

    public FlightPanel(BabyBird b) {
        this.babyBird = b;
        setFont(BIG_FONT);
        fm = getFontMetrics(BIG_FONT);
        setFocusable(true);
        requestFocusInWindow(true);
        //listeners
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {   //keyPressed spam-keyReleased !spam wings
                char key = e.getKeyChar();
                if (key == ' ') {
                    bird.startFlapping();
                    //bird.move();
                    //repaint();
                }
            }
        });
        //timer
        timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timedAction();
            }
        });
        walls.add(new Wall(fm));

        timer.start();
    }

    public Bird getBird() {
        return bird;
    }

    private void timedAction() {
        int changeY = bird.getChangeY();

        //move bird
        bird.move();
        
        //flicker free
        int paintX = bird.getX();
        int paintY = bird.getY();
        if (changeY > 0) {
            changeY -= paintY;
        }
        int paintWidth = bird.getWidth();
        int paintHeight = bird.getHeight()+Math.abs(changeY);
        repaint(paintX,paintY,paintWidth,paintHeight);
        //

        //move wall
        for (int i = 0; i < walls.size(); i ++) {
            Wall wall = walls.get(i);
            wall.move();
            
            //flicker free
            paintX = wall.getX();
            paintY = wall.getY();
            paintWidth = wall.getWidth() - wall.getChangeX();
            paintHeight = HEIGHT;
            repaint(paintX,paintY,paintWidth,paintHeight);
            //
            
            if (wall.isPastWindowEdge()) {
                walls.remove(i);
                int points = wall.getPoints();
                babyBird.addToScore(points);
            }
        }    
                
        //check collision
        Wall firstWall = walls.get(0);
        Rectangle birdBounds = bird.getBounds();
        Rectangle topWallBounds = firstWall.getTopBounds();
        Rectangle bottomWallBounds = firstWall.getBottomBounds();
        if (birdBounds.intersects(topWallBounds) || birdBounds.intersects(bottomWallBounds)) {
            //FileIO.playClip(this, THUD);
            //timer.stop();
            nextLife();            
        }
        
        //add another wall?
        count++;
        if (count > SEPARATION) {
            Wall wall = new Wall(fm);
            walls.add(wall);
            count = 0;
        }
        
        //repaint
        //repaint(); comment out b/c add in the code for flicker free

    }//End timedAction

    private void nextLife() {
        FileIO.playClip(this, THUD);
        babyBird.nextBird();
        count = 0;
        walls.clear();
        Wall wall = new Wall(fm);
        walls.add(wall);
        repaint();
    }

    public void restart() {
        count = 0;
        bird = new Bird(HEIGHT);
        walls.clear();
        Wall wall = new Wall(fm);
        walls.add(wall);
        repaint();
    }

    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public void paintComponent(Graphics g) {
        //bkg         
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //paint bird and walls
        bird.draw(g);
        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            wall.draw(g);
        }
    }

}
