package babybird;

import static babybird.FlightPanel.HEIGHT;
import static babybird.FlightPanel.WIDTH;
import commonmethods.FileIO;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author 312679-shruti panchal
 */
public class Wall {

    private static final String WALL_IMAGE_FILE = "wall.jpg";
    private static BufferedImage wallImg;
    private static int width = 72, height = 600;
    private static final int CHANGE_X = -10;
    private static final int TOP_MIN = 100;
    private static final int TOP_MAX = 300;
    private static final int GAP_MIN = 100;
    private static final int GAP_MAX = 240;
    private Random rand = new Random();
    private int x = WIDTH;
    private int bottomY;
    private int topHeight, bottomHeight;
    private BufferedImage topImg, bottomImg;
    private int points = 1;
    private static final int POINTS_OFFSET = 80;
    private String pointsString;
    private int pointsX;

    public Wall(FontMetrics fm) {
        if (wallImg == null) {
            wallImg = FileIO.readImageFile(this, WALL_IMAGE_FILE);
            width = wallImg.getWidth();
            height = wallImg.getHeight();
        }
        //int gap = 150;
        //topHeight = 100;        
        int range = GAP_MAX - GAP_MIN;
        int pick = rand.nextInt(range);
        int gap = pick + GAP_MIN;
        //calc ratio
        float ratio = (float) pick / range;
        //convert score to 1 to 10
        int intValue = (int) (ratio * 10);
        //turn the value into points 10 to 1 smallest has the most points
        points = 10 - intValue;
        pointsString = points+"";
        int pointsWidth = fm.stringWidth(pointsString);
        pointsX = width/2-pointsWidth/2;
        
        range = TOP_MAX - TOP_MIN;
        pick = rand.nextInt(range);
        topHeight = pick + TOP_MIN;
        bottomY = topHeight + gap;
        bottomHeight = HEIGHT - bottomY;
        topImg = wallImg.getSubimage(0, height - topHeight, width, topHeight);
        bottomImg = wallImg.getSubimage(0, 0, width, bottomHeight);
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return 0;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getChangeX() {
        return CHANGE_X;
    }
    
    public int getPoints() {
        return points;
    }

    public void draw(Graphics g) {
        if (wallImg == null) {
            g.setColor(Color.CYAN);
            g.fillRect(x, 0, width, topHeight);
            g.fillRect(x, bottomY, width, bottomHeight);
        } else {
            g.drawImage(topImg, x, 0, null);
            g.drawImage(bottomImg, x, bottomY, null);
        }
        g.setColor(Color.BLACK);
        g.drawString(pointsString, x+pointsX, bottomY+POINTS_OFFSET);
    }

    public void move() {
        x += CHANGE_X;
    }

    public boolean isPastWindowEdge() {
        int rightEdgeX = x + width;
        return (rightEdgeX < 0);
    }

    public Rectangle getTopBounds() {
        Rectangle bounds = new Rectangle(x, 0, width, topHeight);
        return bounds;
    }

    public Rectangle getBottomBounds() {
        Rectangle bounds = new Rectangle(x, bottomY, width, bottomHeight);
        return bounds;
    }

}
