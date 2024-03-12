package Assignment_5;

// Invalid Month exception
public class InvalidMonthNumberException extends Exception{
	public InvalidMonthNumberException(int number){
		super("Error : Cannot be less than 1 and greater than 12!");
	}
}
