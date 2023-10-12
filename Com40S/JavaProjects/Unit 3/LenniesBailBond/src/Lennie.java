import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author 312679-Shruti Panchal
 */
public class Lennie {
    private String collateral;
    private double bail;

    public Lennie(double bail) {
        this.collateral = getCollateral();
        this.bail = bail;
    }

    public String getCollateral() {
        return collateral;
    }

    public double getBail() {
        return bail;
    }

    public double getFee() {
        return getBail()*0.10;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }
    
    public void displayInfo() {
        System.out.println("The Fee for your " + getCollateral() + " is: " +
                        NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                        .format(getFee()));
    }

    @Override
    public String toString() {
        return "Lennie{" + "collateral=" + collateral + ", bail=" + bail + '}';
    }
    
}