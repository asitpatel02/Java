class Purple {
	
	protected int i = 0;
	
	public Purple() {
		
		System.out.println("Purple() running and i = " + i);
		
	}
	
	public Purple(int i) {
		
		this.i = i;
		
		System.out.println("Purple(i) running and i = " + i);
		
	}
	
	
	
}

class Violet extends Purple {
	
	Violet() {
		
		System.out.println("Violet(i) running and i = " + i);
		
	}
	
	Violet(int i) {

//super (i);
		
		System.out.println("Violet(i) running and i = " + i);
		
	}
	
}

class Inheritance2 {
	
	public static void main(String[] args) {
		
		new Violet();
		
		new Violet(1);
		
	}
	
}