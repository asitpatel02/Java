// RetailClass Runner
public class Lab1_1 {
    public static void main(String[] args) {
        Lab1 item1 = new Lab1("Jacket", 12, 59.95);
        Lab1 item2 = new Lab1("Designer Jeans", 40, 34.95);
        Lab1 item3 = new Lab1("Shirt", 20, 24.95);

        System.out.println("\t\t Description \t\t Units on Hand \t Price");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Item #1\t "+item1.getDescription()+"\t\t\t\t "+item1.getUnitsOnHand()+"\t\t\t\t "+item1.getPrice());
        System.out.println("Item #2\t "+item2.getDescription()+"\t\t "+item2.getUnitsOnHand()+"\t\t\t\t "+item2.getPrice());
        System.out.println("Item #3\t "+item3.getDescription()+"\t\t\t\t "+item3.getUnitsOnHand()+"\t\t\t\t "+item3.getPrice());
    }
}
