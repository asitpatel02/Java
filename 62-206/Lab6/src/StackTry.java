public class StackTry {
	
	private final String[] stackArray;
	
	private int top;
	
	public StackTry(int s) {
		stackArray = new String[s];
		top = -1;
	}
	
	public void push(String j) {
		stackArray[++top] = j;
	}
	
	public String pop() {
		return stackArray[top--];
	}
}
