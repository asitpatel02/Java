
// RetailClass
public class Lab1 {

    private String description;
    private int unitsOnHand;
    private double price;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitsOnHand(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitsOnHand() {
        return unitsOnHand;
    }

    public double getPrice() {
        return price;
    }

    public Lab1(String descriptionGiven, int unitsOnHandGiven, double priceGiven){
        description=descriptionGiven;
        unitsOnHand=unitsOnHandGiven;
        price=priceGiven;
    }
}