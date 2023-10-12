
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class Board extends JPanel implements ActionListener{
    //field vars
    private SpaceShip spaceShip;
   // private int SpaceShipX=40,SpaceShipY=60;
    private Timer timer;
    private final int DELAY = 10;
    
    public Board() {
        initBoard();
    }
    
    private void initBoard() {
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        spaceShip = new SpaceShip();
        
        timer = new Timer(DELAY,this);
        timer.start();
        
        addKeyListener(new TAdapter());
       
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    public void doDrawing(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        
        g2D.drawImage(spaceShip.getImage(),
                spaceShip.getX(), spaceShip.getY(), this);
        //System.out.println(SpaceShip.getMisile());
        if (spaceShip.getMissile()!=null){
            ArrayList<Missile> missiles = spaceShip.getMissile();
            //enhanced for loop
            for (Missile m : missiles) {
                g2D.drawImage(m.getImage(), m.getX(),m.getY(),this);
            }            
        }
        
    }

    private void updateMissiles() {
        ArrayList<Missile> missiles = spaceShip.getMissile();
        
        //regular for loop
        for (int i=0; i<missiles.size();i++){
            Missile missile = missiles.get(i);            
            if (missile.isVisible()) {
                missile.move();
            } else {
                missiles.remove(i);
            }
        }        
        
    }
     
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        step();
        updateMissiles();
        repaint();//
        
    }
    
    private void step() {
        
        spaceShip.move();
        
        repaint(spaceShip.getX()-1,spaceShip.getY()-1,
                spaceShip.getW()+2,spaceShip.getH()+2);
        //optimizing our window by only redrawing part of the window
    }
   
    private class TAdapter extends KeyAdapter{
        
        @Override
        public void keyReleased(KeyEvent e){
            spaceShip.keyReleased(e);            
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            spaceShip.keyPressed(e);      
           
        }
        
    }
    
}
