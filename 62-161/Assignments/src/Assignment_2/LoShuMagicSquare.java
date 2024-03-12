package Assignment_2;

public class LoShuMagicSquare {

	public static boolean isMagicSquare(int[][] arr){

		boolean valid = false;

		//set sum of row and col to zero
		int row1sum = 0;
		int row2sum = 0;
		int row3sum = 0;
		int col1sum = 0;
		int col2sum = 0;
		int col3sum = 0;

		//calculate the sum of rows
		for (int[] ints : arr){
			row1sum += ints[0];
		}

		for (int[] ints : arr){
			row2sum += ints[1];
		}

		for (int[] ints : arr){
			row3sum += ints[2];
		}

		// Calculate the sum of columns
		for (int[] ints : arr) {
			col1sum += ints[0];
		}

		for (int[] ints : arr) {
			col2sum += ints[1];
		}

		for (int[] ints : arr) {
			col3sum += ints[2];
		}

		//left diagonal sum
		int leftdiagonalsum = arr[0][0] + arr[1][1] + arr[2][2];

		//right diagonal sum
		int rightdiagonalsum = arr[0][2] + arr[1][1] + arr[2][0];

		//check if sum of rows and cols and diagonal sums are equal
		if ((row1sum == row2sum) && (row2sum == row3sum) && (row3sum == row1sum) && (col1sum == col2sum) && (col2sum == col3sum) && (col1sum == col3sum) && (leftdiagonalsum == rightdiagonalsum))
			valid = true;

		// return boolean variable
		return valid;
	}

	public static void main(String[] args) {

		//array of magic square
		int[][] magic = {
				{4,9,2},
				{3,5,7},
				{8,1,6}};

		//Print array in matrix from
		for (int[] ints : magic) {
			for (int col = 0; col < magic.length; col++) {
				System.out.printf("%-2d", ints[col]);
			}
			System.out.println();
		}

		//call method isMagicSquare with magic array
		System.out.println("Magic Square: " + isMagicSquare(magic));

		//array of normalArray
		int[][] normal = {
				{1,2,3},
				{4,5,6},
				{7,8,8}};

		//Print array in matrix from
		for (int[] ints : normal) {
			for (int col = 0; col < normal.length; col++) {
				System.out.printf("%-2d", ints[col]);
			}
			System.out.println();
		}

		//call method isMagicSquare with magic array
		System.out.println("Normal Square: " + isMagicSquare(normal));
	}
}
