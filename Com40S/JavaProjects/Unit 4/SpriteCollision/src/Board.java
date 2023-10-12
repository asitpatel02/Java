
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class Board extends JPanel implements ActionListener {

    //field vars
    private SpaceShip spaceShip;
    private int SpaceShipX=40,SpaceShipY=60;
    private Timer timer;
    private final int DELAY = 10;
    private ArrayList<Alien> aliens;
    private boolean inGame;
    private final int NUM_ALIENS = 10;
    private int pos[][];
    private String backgroundSound;
    private InputStream in;
    private AudioStream audioStream;

    public Board() throws IOException {
        initBoard();
        initAliens();
    }

    private void initBoard() throws IOException {
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        spaceShip = new SpaceShip(40,60);

        timer = new Timer(DELAY, this);
        timer.start();

        aliens = new ArrayList<>();
        initAliens();
        inGame = true;

        addKeyListener(new TAdapter());

        playSound();
    }

    private void initAliens() {
        aliens = new ArrayList<>();
        pos = new int[NUM_ALIENS][2];

        for (int i = 0; i < NUM_ALIENS; i++) {
            int x = (int) ((3000 - 850 + 1) * Math.random() + 850);
            int y = (int) ((600 - 0 + 1) * Math.random() + 0);
            pos[i][0] = x;
            pos[i][1] = y;
            //System.out.println(pos[i][0]+";"+pos[i][1]);      
            aliens.add(new Alien(pos[i][0], pos[i][1]));
        }
//        for (int i = 0; i<NUM_ALIENS;i++){         
//            int y=(int)((600-0+1)*Math.random());            
//            pos[i][1]=y;
//            System.out.println(pos[i][0]+";"+pos[i][1]);            
//        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            doDrawing(g);
        } else {
            drawGameOver(g);
        }

    }

    public void doDrawing(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        if (spaceShip.isVisible()) {
            g2D.drawImage(spaceShip.getImage(),
                    spaceShip.getX(), spaceShip.getY(), this);
        }
        //System.out.println(SpaceShip.getMisile());
        if (spaceShip.getMissiles() != null) {
            ArrayList<Missile> missiles = spaceShip.getMissiles();
            //enhanced for loop
            for (Missile m : missiles) {
                if (m.visible) {
                    g2D.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
        }
        for (Alien a : aliens) {
            if (a.visible) {
                g2D.drawImage(a.getImage(), a.getX(), a.getY(), this);
                g.setColor(Color.WHITE);
                g.drawString("Aliens left: " + aliens.size(), 5, 15);
            }
        }
    }//end doDrawing

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (800 - fm.stringWidth(msg)) / 2, 600 / 2);
    }
    
    private void updateMissiles() {
        ArrayList<Missile> missiles = spaceShip.getMissiles();

        //regular for loop        
        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);
            if (missile.isVisible()) {
                missile.move();
            } else {
                missiles.remove(i);
            }
        }

    }

    private void updateAliens() {

        if (aliens.isEmpty()) {
            inGame = false;
            return;
        }

        for (int i = 0; i < aliens.size(); i++) {

            Alien a = aliens.get(i);

            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }

        }

    }

    public void checkCollisions() {
        ArrayList<Missile> ms = spaceShip.getMissiles();

        Rectangle rectShip = spaceShip.getBounds();
        for (Alien a : aliens) {
            Rectangle rectAlien = a.getBounds();
            if (rectShip.intersects(rectAlien)) {
                spaceShip.setVisible(false);
                a.visible = false;
                inGame = false;
                //timer.stop();
            }
        }
        for (Missile m : ms) {
            Rectangle rectM = m.getBounds();
            for (Alien a : aliens) {
                Rectangle rectA = a.getBounds();
                if (rectM.intersects(rectA)) {
                    m.visible = false;
                    a.visible = false;
                    System.out.println("hello");
                }
            }
        }

    }//end checkCollision

    public void inGame() {
        if (!inGame) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        inGame();
        upDateShip();
        updateMissiles();
        updateAliens();
        checkCollisions();
        repaint();//
    }

    private void upDateShip() {

        spaceShip.move();

        repaint(spaceShip.getX() - 1, spaceShip.getY() - 1,
                spaceShip.getW() + 2, spaceShip.getH() + 2);
        //optimizing our window by only redrawing part of the window
    }

    private void playSound() throws FileNotFoundException, IOException {
        backgroundSound = "src/sound.wav";
        //open the sound file
        in = new FileInputStream(backgroundSound);
        
        //create an audiostream
        audioStream = new AudioStream(in);
        
        //play the audio
        AudioPlayer.player.start(in);
                
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);

        }

    }

}
