package CH8;
// Code Listing 8-1 pg#533

public class Countable {

	private static int instanceCount = 0;

	public Countable(){
		instanceCount++;
	}

	public int getInstanceCount(){
		return instanceCount;
	}
}
