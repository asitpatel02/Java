public class NestedSwitchExample {
	
	public static void main(String[] args){
		int i = 0, j =1;
		if(i == 0){
			if(j == 0){
				System.out.println("i is 0, j is 0");
			}
			else if(j == 1) {
				System.out.println("i is 0, j is 1");
			}
			else{
				System.out.println("nested default case!");
			}
		}
		else{
			System.out.println("No matching case found!");
		}
	}
}
