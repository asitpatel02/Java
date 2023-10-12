
import java.util.Scanner;

/**
 *
 * @author 312679-Shruti Panchal JavaExam - RainFall
 */
public class RainFall {

    private int years = 0;
    private int[][] rainfall;

    public RainFall() {
        setYears(getNumYears());
        loadRainfall();
        System.out.println(this);
    }

    public int getNumYears() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of years to collect data for: ");
        int y = in.nextInt();
        //System.out.println("");        
        return y;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void loadRainfall() {
        Scanner in = new Scanner(System.in);
        //int x = in.nextInt();
        System.out.println("Entering monthly rainfall");
        rainfall = new int[getMonths()][2];
        for (int i = 0; i < rainfall.length; i++) {            
            rainfall[i][0] = i;
            System.out.print("Enter rainfall for year "+years+
                    ", month " + i + ": ");        
            //change i to i+1
            rainfall[i][1] = in.nextInt();
            //System.out.println("");
        }        
        System.out.println("------------------------");
    }

    public int getMonths() {
        return years * 12;
    }

    public int getTotalRainfall() {
        int totalRain = 0;
        for (int i = 0; i < rainfall.length; i++) {
            totalRain += rainfall[i][1];
        }
        return totalRain;
    }

    public double getAverage() {
        return getTotalRainfall() / getMonths();
    }

    @Override
    public String toString() {
        return "Total number of months: " + getMonths()
                + "\nTotal inches of rainfall: " + getTotalRainfall()
                + "\nAverage rainfall: " + getAverage();
    }
    
}
