package babybird;

import components.ScorePanel;
import components.TitleLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class BabyBird extends JFrame {

    private FlightPanel flightPanel = new FlightPanel(this);
    private ScorePanel scorePanel = new ScorePanel(0, Color.GREEN);
    private static final int LIVES = 4;
    private BirdNestPanel birdNestPanel;

    public BabyBird() {
        initGUI();
        setTitle("Baby Bird");
        setResizable(false);
        setLocation(1200, 100);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        pack();
    }

    private void initGUI() {
        TitleLabel titleLabel = new TitleLabel("Baby Bird");
        add(titleLabel, BorderLayout.PAGE_START);
        //main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel, BorderLayout.CENTER);
        //score        
        mainPanel.add(scorePanel);
        //flight
        mainPanel.add(flightPanel);
        //botton
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        add(bottomPanel, BorderLayout.PAGE_END);
        //bird nest
        Bird bird = flightPanel.getBird();
        BufferedImage birdImage = bird.getImage();
        birdNestPanel= new BirdNestPanel(birdImage,LIVES-1);
        bottomPanel.add(birdNestPanel);
        
    }

    public void addToScore(int points) {
        scorePanel.addToScore(points);
    }
    
    public void nextBird() {
        int birdsRemaining = birdNestPanel.removeBird();
        if (birdsRemaining <0) {
            String msg = "No more birds.  Play again?";
            int option = JOptionPane.showConfirmDialog(this, msg,"Play again?", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                birdNestPanel.setBirdCount(LIVES-1);
                scorePanel.reset();
                flightPanel.restart();
            } else {
                System.exit(0);
            }
            
        }
    }
    
    public static void main(String[] args) {
        //BabyBird b = new BabyBird();
        new BabyBird();

    }

}
