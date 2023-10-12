package components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author 312679-Shruti Panchal;
 * Font.decode("arial")+""
 */
public class ScorePanel extends JPanel {

    private static final Font SMALL_FONT = new Font(Font.DIALOG, Font.PLAIN, 12);
    private static final Font BIG_FONT = new Font(Font.DIALOG, Font.BOLD, 36);
    private int initialScore;
    private int score = 0;   
    private JLabel scoreLabel = new JLabel("0");
 
    public ScorePanel(int initialScore, Color color) {
        this.initialScore = initialScore;
        setBackground(color); 
        JLabel scoreTitleLabel = new JLabel("Score:: ");
        scoreTitleLabel.setFont(SMALL_FONT);
        add(scoreTitleLabel);
        scoreLabel.setFont(BIG_FONT);
        add(scoreLabel);
    }

    public void addToScore(int point) {
        score += point;
        scoreLabel.setText(score + "");
    }

    public void reset() {
        score=initialScore;
        scoreLabel.setText(score + "");
    }

}
