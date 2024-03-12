public class lab10Q1 {

    private int yearModel;
    private String make;
    private int speed;

    // set methods
    public void setYearModel(){
        this.yearModel = 2019;
    }

    public void setMake(){
        this.make = "Porshe";
    }

    public void setSpeed() {
        this.speed = 200;
    }

    // get methods
    public int getYearModel(){
        return yearModel;
    }

    public String getMake(){
        return make;
    }

    public int getSpeed(){
        return speed;
    }

    // accelerate method
    public void Accelerate(){
        speed += 5;
    }

    // brake method
    public void Break(){
        speed -= 5;
    }

    public lab10Q1(){
        setYearModel();
        setMake();
        setSpeed();
    }
}