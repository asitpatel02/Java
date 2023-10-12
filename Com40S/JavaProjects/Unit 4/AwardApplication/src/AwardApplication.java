
/**
 * Unit 4 - Test(AwardApplication)
 * @author 312679-shruti panchal
 * Nov 22, 2018
 */
public class AwardApplication {

    private int numAwards;

    public AwardApplication(int numAwards) {
        this.numAwards = numAwards;
    }

    //default constructor
    public AwardApplication() {
        this.numAwards = 0;
    }

    public int getNumAwards() {
        return numAwards;
    }

    public void setNumAwards(int numAwards) {
        this.numAwards = numAwards;
    }

    public String displayMessage() {      
        if (getNumAwards() >= 14) {
            return "Gold Medal";           
        } else if (getNumAwards() >= 10) {
            return "Silver Medal";
        } else if (getNumAwards() >= 5) {
            return "Bronze Medal";
        } else {
            return "You did not qualify for an overall participation medal.";
        }
    }

    @Override
    public String toString() {
        return getNumAwards() + " - " + displayMessage();
    }

    public static void main(String[] args) {
        AwardApplication a1 = new AwardApplication();
        System.out.println(a1);
        AwardApplication a2 = new AwardApplication(4);
        System.out.println(a2);
        AwardApplication a3 = new AwardApplication(8);
        System.out.println(a3);
        AwardApplication a4 = new AwardApplication(11);
        System.out.println(a4);
        AwardApplication a5 = new AwardApplication(15);
        System.out.println(a5);

    }

}
