package Assignment_5;

// Invalid string exception
public class InvalidMonthNameException extends Exception{
	public InvalidMonthNameException(){
		super("Error : String cannot be empty!");
	}
}
