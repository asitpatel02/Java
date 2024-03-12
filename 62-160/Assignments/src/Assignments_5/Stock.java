package Assignments_5;

public class Stock {

    // private variables
    private String name;
    private double Num;

    // set method for Name
    public void setName(String nameGiven){
        this.name = name;
    }

    // sharePrice set method for Num
    public void setNum(double NumGiven){
        this.Num = 0.0;
    }

    // get method for string Name
    public String getName() {
        return name;
    }

    // get method for int Num
    public double getNum(){
        return Num;
    }

    // class call
    public Stock(String tradingSymbol, double sharePrice ){
        name = tradingSymbol;
        Num = sharePrice ;

    }

}
