package CH16;
// code listing 16-7 pg#1096

public class FibNumbers {

	public static void main(String[] args) {
		System.out.println("The first 10 number is the Fibonacci series are: ");

		for (int i = 0; i < 10; i++)
			System.out.print(fbi(i) + " ");
		System.out.println();
	}

	public static int fbi(int n){
		if (n == 0)
			return 0;
		else if (n ==1)
			return 1;
		else return fbi(n-1) + fbi(n-2);
	}
}
