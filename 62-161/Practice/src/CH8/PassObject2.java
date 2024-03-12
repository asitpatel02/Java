package CH8;
// Code Listing 8-6 pg#541

import java.awt.*;

public class PassObject2 {

	public static void main(String[] args) {

		//Create a Rectangle object
		Rectangle box = new Rectangle(12,5);

		//Display the object contents
		System.out.println("Contents of the box object");
		System.out.println("Length : " + box.getWidth() + " Width : " + box.getHeight());

		//Pass a reference to the object to eh changeRectangle method
		changeRectangle(box);

		//Display the objects contents again
		System.out.println("\nNow the contents of the box object are: ");
		System.out.println("Length : "+ box.getWidth() + " Width : " + box.getHeight());
	}

	public static void changeRectangle(Rectangle r){
		r.setSize(0,0);
	}

}
