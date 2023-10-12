package babybird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author 312679-shruti panchal
 */
public class BirdNestPanel extends JPanel {

    private static final int MARGIN = 20;
    private static final int SPACING = 20;
    private BufferedImage image;
    private int count = 0;
    private int birdWidth, birdHeight;
    private int width, height;

    public BirdNestPanel(BufferedImage image, int count) {
        this.image = image;
        this.count = count;
        birdWidth = image.getWidth();
        birdHeight = image.getHeight();
        width = birdWidth*count + MARGIN*2 + SPACING*(count-1);
        height=birdHeight+2*MARGIN;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);        
        for (int i = 0; i < count; i++) {
            int x = MARGIN+(i*(birdWidth+SPACING));
            g.drawImage(image, x, MARGIN, null);
        }
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(width,height);
    }
 
    public int removeBird() {
        count--;
        repaint();
        return count;
    }
    
    public void setBirdCount(int count) {
        this.count=count;
        repaint();
    }
    
}
