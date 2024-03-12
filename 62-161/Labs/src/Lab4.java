public class Lab4 {

	//main function
	public static void main(String[] args) {

		int [][]list = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

		// function call and display data returned
		System.out.println("Total: " + getTotal(list));
		System.out.println("Average: " + getAverage(list));
		System.out.println("Row 2 value: " + getRowTotal(list,2));
		System.out.println("Column 3 Total: " + getColumnTotal(list,3));
		System.out.println("Highest value in row 1 is: " + getHighest(list,1));
		System.out.println("Lowest value in row 2 is: " + getLowest(list,2));
	}

	//returns sum of elements of array
	public static int getTotal(int [][]numbers){

		int tot=0;
		//loop repeats until list ends
		for (int[] number : numbers)
			for (int i : number) tot += i;
			return tot;
	}

	//returns average
	public static double getAverage(int [][]numbers){
		double avg;
		avg = getTotal(numbers)/12;
		return avg;
	}

	public static int getRowTotal(int [][]numbers,int index){

		int tot=0;

		//loop repeats until list ends
		for (int col=0;col<4;col++)
			//Accumulates sum of numbers
			tot+=numbers[index][col];
		return tot;
	}

	public static int getColumnTotal(int [][]numbers,int index){

		int tot=0;

		// loop repeats until list ends
		//Accumulates sum of numbers
		for (int[] number : numbers) tot += number[index];
		return tot;
	}

	//returns highest value in row
	public static int getHighest(int [][]numbers,int row){
		int high=numbers[row][0];
		//loop repeats until list ends
		for (int i=1;i<4;i++)
			if (numbers[row][i]>high)
			high=numbers[row][i];
		return high;
	}

	//returns lowest value in row
	public static int getLowest(int [][]numbers,int row){
		int low=numbers[row][0];
		//loop repeats until list ends
		for (int i=1;i<4;i++)
			if (numbers[row][i]<low)
				low=numbers[row][i];
		return low;
	}
}// end lab4