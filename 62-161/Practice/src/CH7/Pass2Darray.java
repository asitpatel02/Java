package CH7;//Code Listing 7-20 pg#498

public class Pass2Darray {

	public static void main(String[] args) {

		int[][] numbers = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12} };

		//Display the contents of the array
		System.out.println("Here are the values int he array.");

		showArray(numbers);
		System.out.println();

		//Display the sum of the array's values
		System.out.println("The sum of the values is " + arraySum(numbers));
	}

	private static void showArray(int[][] array){

		for (int[] ints : array) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
		}
	}

	private static int arraySum(int[][] array){

		int total = 0; //Accumulator

		for (int[] ints : array) {
			for (int anInt : ints) {
				total += anInt;
			}
		}
		return total;
	}
}
