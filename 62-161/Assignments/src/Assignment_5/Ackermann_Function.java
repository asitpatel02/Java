package Assignment_5;

public class Ackermann_Function {
	public static void main(String[] args) {
		System.out.println("Value of ackermann(0,0) :" + Ack(0,0));
		System.out.println("Value of ackermann(0,1) :" + Ack(0,1));
		System.out.println("Value of ackermann(1,1) :" + Ack(1,1));
		System.out.println("Value of ackermann(1,2) :" + Ack(1,2));
		System.out.println("Value of ackermann(1,3) :" + Ack(1,3));
		System.out.println("Value of ackermann(2,2) :" + Ack(2,2));
		System.out.println("Value of ackermann(3,2) :" + Ack(3,2));
		System.exit(0); // stop system
	}

	// Function definition
	public static int Ack(int i, int j){
		if (i==0)
			return j+1;
		else if (j==0)
			return Ack(i-1,1);
		else
			return Ack(i-1, Ack(i,j-1));
	}
}
