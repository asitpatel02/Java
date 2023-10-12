
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class DiscountDeterminer {
    
    private final double DISCOUNT = 0.15;
    private double amount;

    public DiscountDeterminer(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public double calcDiscount(){
        if (getAmount()>2000){
            return getAmount()-(getAmount()*DISCOUNT);
        }
        else{
            return getAmount();
        }
    }

    @Override
    public String toString() {
        return "Bill after discount :: " + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                                                                .format(calcDiscount());
    }
    
    public static void main(String[] args) {
        DiscountDeterminer d1 = new DiscountDeterminer(500);
        //System.out.println(d1);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the original bill amount :: ");     
        d1.setAmount(in.nextDouble());    
        System.out.println(d1);
        
    }
    
}
