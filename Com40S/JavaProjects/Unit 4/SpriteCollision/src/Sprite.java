
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class Sprite {

    protected int x, y, dx, dy, w, h;
    protected Image image;
    protected boolean visible;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public Image getImage() {
        return image;
    }

    public boolean isVisible() {
        return visible;
    }

}
