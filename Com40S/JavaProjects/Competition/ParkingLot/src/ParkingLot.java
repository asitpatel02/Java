/**
 *
 * @author 312679-shruti panchal
 */
public class ParkingLot {
    private int[] monday = {1,0,1,0,0,1,0,0,1,0,1,0};
    private int[] tuesday = {1,0,0,1,0,0,0,0,0,1,1,1};
    
    public int findSpace() {
        int emptySpot=0;
        
        for (int i = 0; i < monday.length; i++) {           
                if (monday[i] == 0 && tuesday[i] == 0) {
                    System.out.println("space");
                    emptySpot += 1;                
            }
        }
        return emptySpot;
    }
    
    public static void main(String[] args) {
        ParkingLot p1 = new ParkingLot();
        System.out.println(p1.findSpace());
    }
    
}
