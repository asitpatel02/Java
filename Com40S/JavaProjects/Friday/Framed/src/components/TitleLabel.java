/**
 *
 */
package components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class TitleLabel extends JLabel {

    public TitleLabel(String title) {
        Font font = new Font("Comic Sans MS",Font.BOLD,40);
        setFont(font);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setOpaque(true);//to see the label color
        setHorizontalAlignment(CENTER);
        setText(title);
        
    }
}
