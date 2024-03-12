package Assignments_5;

public class StockDemo {

    public static void main(String[] args) {

        //Use the no-arg constructor.
        Stock stock1 = new Stock("XYZ",23.17);

        Stock stock2 = new Stock("ABC", 12.31);



        System.out.println("Trading Symbol" + "\t\t\t Share Price" );
        System.out.println(stock1.getName() + "\t\t\t\t\t\t " + stock1.getNum());
        System.out.println(stock2.getName() + "\t\t\t\t\t\t " + stock2.getNum());

    }
}
