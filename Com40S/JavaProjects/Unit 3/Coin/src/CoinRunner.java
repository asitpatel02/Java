/**
 *
 * @author 312679-Shruti Panchal
 */
public class CoinRunner {
    
    public static void main(String[] args) {
        Coin c1 = new Coin(0.25, "2000");
        System.out.println(c1);
        c1.displayCoinFlipped();
        Coin c2 = new Coin(0.05, "1999");
        c2.displayCoinFlipped();
    }

}
