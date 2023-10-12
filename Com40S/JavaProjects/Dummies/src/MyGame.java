
// right click file and and click run file if no main class

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author 312679
 */
public class MyGame extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
        
    }
    
    public void paint(Graphics g){
        g.drawString("Hello World Wide Web!",10,30);
    }
    
    // TODO overwrite start(), stop() and destroy() methods
}
