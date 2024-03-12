package Assignment_4;

public class AreaClass {

	static final double pi = Math.PI;                   // Constant Variable

	static double area(double radius){                  // area with method with radius as a parameter
		return pi*radius*radius;
	}

	static double area(double length, double width){     // area method with length and width as a parameters
		return length*width;
	}

	static double area(double radius, float height){    // area method with radius and height as a parameters
		return pi*radius*radius*height;
	}

}