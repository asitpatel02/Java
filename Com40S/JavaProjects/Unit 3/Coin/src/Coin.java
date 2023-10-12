/**
 *
 * @author 312679-Shruti Panchal
 */
public class Coin {

    private double value;
    private String year;
    private int faceUp;

    public Coin(double value, String year) {
        this.value = value;
        this.year = year;
        this.faceUp = getFaceUp();
    }

    public double getValue() {        
        return value;
    }

    public String getYear() {
        return year;
    }

    public int getFaceUp() {
        return faceUp;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Coin{" + "value=" + value + ", year=" + year + ", faceUp=" +
                faceUp + '}';
    }

    public int flipCoin() {
        return (int) ((1 - 0 + 1) * Math.random() + 0);
    }

    public String returnValue() {
        String coin="";
        if (this.value==0.01) {
            coin="Penny";            
        }
        else if (this.value==0.05) {
            coin="Nickel";            
        }
        else if (this.value==0.10) {
            coin="Dime";            
        }
        else if (this.value==0.25) {
            coin="Quarter";            
        }
       return coin;
    }
    
    public void displayCoinFlipped() {
       if (flipCoin() == 0) {
                System.out.println(returnValue() + " flipped: heads");
            } else {
                System.out.println(returnValue() + " flipped: tails");
            }  

    }

}