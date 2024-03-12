package CH8;
// Code Listing 8-5 pg#539

import java.awt.*;

public class PassObject {

	public static void main(String[] args) {

		//create a rectangle object
		Rectangle box = new Rectangle(12,5);

		//pass a reference to the object the displayRectangle method
		displayRectangle(box);
	}

	public static void displayRectangle(Rectangle r){

		//display the length and width
		System.out.println("Length : " + r.getWidth() + " Width :" + r.getHeight());
	}
}
