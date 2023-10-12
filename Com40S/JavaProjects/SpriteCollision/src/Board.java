
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *Sprite Collision
 * @author 312679-Shruti Panchal
 * Mods::
 *          spaceship extends sprite
 *          stops at the edges
 *          levels
 *          lives
 *          different missiles
 *          pause the game          
 */
public class Board extends JPanel implements ActionListener {

    //field vars
    private SpaceShip spaceShip;
    private int SpaceShipX = 40, SpaceShipY = 60;
    private Timer timer, t2;
    private final int DELAY = 10;
    private ArrayList<Alien> aliens;
    private ArrayList<AlienX> alienX;
    private boolean inGame, alienOver, gameWon;
    private int numAliens = 3, lives = 3, level = 1;
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

        spaceShip = new SpaceShip(40, 60);

        timer = new Timer(DELAY, this);
        timer.start();

        aliens = new ArrayList<>();
        alienX = new ArrayList<>();
        initAliens();
        inGame = true;
        gameWon = false;
//        alienOver = false;

        addKeyListener(new TAdapter());
        t2 = new Timer(DELAY, this);
        //playSound();
    }

    private void initAliens() {
        aliens = new ArrayList<>();
        alienX = new ArrayList<>();

        pos = new int[numAliens][2];

        for (int i = 0; i < numAliens; i++) {
            int x = (int) ((1000 - 850 + 1) * Math.random() + 850);
            int y = (int) ((500 - 0 + 1) * Math.random() + 0);
            pos[i][0] = x;
            pos[i][1] = y;
//            alienX.add(new AlienX(pos[i][0], pos[i][1]));
            aliens.add(new Alien(pos[i][0], pos[i][1]));
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            doDrawing(g);
        } else {
            drawGameOver(g);
        }
        if (!spaceShip.isGamePaused()) {
            doDrawing(g);
        } else {
            drawGamePaused(g);
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
      
//        if (alienOver) {
//            for (AlienX a : alienX) {
//                if (a.visible) {
//                    g2D.drawImage(a.getImage(), a.getX(), a.getY(), this);
//                    g.setColor(Color.WHITE);
//                }
//            }            
//        } else {
      for (Alien a : aliens) {
            if (a.visible) {
                g2D.drawImage(a.getImage(), a.getX(), a.getY(), this);
                g.setColor(Color.WHITE);
            }
        }

//}
        g.drawString("Level:: " + level + "..." + aliens.size() + " Aliens are coming", 5, 15);
            g.drawString("Lives:: " + lives, 180, 15);
            g.drawString("'Space'_Shoot   'Arrows'_Move   'p'_Pause", 540, 15);
}

    private void drawGameOver(Graphics g) {
        String msg;
        if (gameWon) {
            msg = "Game Won";
        } else {
            msg = "Game Over";
        }
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (800 - fm.stringWidth(msg)) / 2, 600 / 2);
    }

    private void drawGamePaused(Graphics g) {

        String msg = "Game Paused";
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
            level++;
            numAliens += 2;
            if (numAliens <= 10) {
                initAliens();
            } else {
//                initAliens();
//                alienOver = true;
                inGame = false;
            }
            return;
        }
//        if (alienX.isEmpty()) {
//            initAliens();
//            inGame = false;
//            return;
//        }
        for (int i = 0; i < aliens.size(); i++) {
            Alien a = aliens.get(i);
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
        }
//        for (int i = 0; i < alienX.size(); i++) {
//            AlienX a = alienX.get(i);
//            if (a.isVisible()) {
//                a.move();
//            } else {
//                alienX.remove(i);
//            }
//        }
    }

    public void checkCollisions() {
        ArrayList<Missile> ms = spaceShip.getMissiles();

        Rectangle rectShip = spaceShip.getBounds();
        for (Alien a : aliens) {
            Rectangle rectAlien = a.getBounds();
            if (rectShip.intersects(rectAlien)) {
                a.visible = false;
                //lives--;
                if (lives < 2) {
                    inGame = false;
                    spaceShip.setVisible(false);
                }
                lives--;
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
//
//            int alienLife =3;
//            for (Missile m : ms) {
//            Rectangle rectM = m.getBounds();
//            for (AlienX a : alienX) {
//                Rectangle rectA = a.getBounds();
//                if (rectM.intersects(rectA)) {
//                    alienLife--;
//                    m.visible = false;
//                    a.visible = false;
//                    System.out.println("hello");
//                }
//            }
//        }
//        
    }//end checkCollision

    public void inGame() throws IOException {
        if (!inGame) {
            //playSound();
            timer.stop();
        }
        playSound();
        if (spaceShip.isGamePaused()) {
            //spaceShip.setGamePaused(gamePaused);
            System.out.println(spaceShip.isGamePaused());
            timer.stop();
            t2.start();
            //timer.addActionListener(this);
        }
        if (spaceShip.isGamePauseOver()) {
            timer.start();
            t2.stop();
            System.out.println(spaceShip.isGamePauseOver());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (timer.isRunning()) {
            try {
                //throw new UnsupportedOperationException("Not supported yet.");
                //To change body of generated methods, choose Tools | Templates.
                inGame();
            } catch (IOException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
            upDateShip();
            updateMissiles();
            updateAliens();
            checkCollisions();
            repaint();//
        } else {
            try {
                inGame();
            } catch (IOException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            playSound();
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void upDateShip() {

        spaceShip.move();

        repaint(spaceShip.getX() - 1, spaceShip.getY() - 1,
                spaceShip.getW() + 2, spaceShip.getH() + 2);
        //optimizing our window by only redrawing part of the window
    }

    private void playSound() throws FileNotFoundException, IOException {
//        backgroundSound = "src/s3.wav";
//        //open the sound file
//        in = new FileInputStream(backgroundSound);
//
//        //create an audiostream
//        audioStream = new AudioStream(in);
//
//        //play the audio
//        if (inGame && !spaceShip.isGamePaused()) {
//            AudioPlayer.player.start(audioStream);
//        } else {
//            System.out.println(!inGame);
//            AudioPlayer.player.stop(audioStream);
//        }

    }

//    private static class ActionListner implements ActionListener {
//
//        public ActionListner() {
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    }
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
