public class Box<T> {
	
	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get () {     // Hint: think about this line
		return  t;
	}
	
	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<> ();
		Box<String> stringBox = new Box<> ();
		
		integerBox.add(10);
		stringBox.add("Hello World");
		
		System.out.printf("Integer Value :%d\n\n", integerBox.get());
		System.out.printf("String Value :%s\n", stringBox.get());
	}
}
