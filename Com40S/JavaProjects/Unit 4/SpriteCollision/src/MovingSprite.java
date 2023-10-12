
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author 312679- Shruti Panchal
 */
public class MovingSprite extends JFrame{
    
    public static void main(String[] args) throws IOException {
        MovingSprite s1 = new MovingSprite();
        s1.setVisible(true);
    }

    public MovingSprite() throws IOException {
        initUI();
    }      
     
  
    
    private void initUI() throws IOException {
        add(new Board()); //this is how you add items to a JFrame
        
        setTitle("Moving sprite");
        setSize(800,600);
        
        setLocationRelativeTo(null); //starts form in center of monitor
        setResizable(false);        
        //stop execution when closing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
}
