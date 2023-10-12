

public class Fibonacci1 {

	public static long  LinearFibonacci(int k) {

		if (k == 1 || k ==0)
			return k;
		else {
			return LinearFibonacci(k - 1) + LinearFibonacci(k-2);
		}

	}

	public static void main (String[] args) {
		System.out.println(LinearFibonacci(52));
	}
}
