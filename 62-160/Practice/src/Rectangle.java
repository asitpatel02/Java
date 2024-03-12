public class Rectangle {

    private double length;
    private double width;

    public Rectangle(){
        length = 1.0;
        width = 1.0;
    }

    public Rectangle(double len, double w){
        length = len;
        width = w;
    }

    public void setLength(double len){
        length = len;
    }

    public void setWidth(double w){
        width = w;
    }

    public double getLength(){
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea(){
        return length*width;
    }
}