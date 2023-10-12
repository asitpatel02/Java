 class Gen<T> {
	
	T ob; // declare an object of type T
	
	Gen(T o) {
		
		ob = o;
		
	}
	
	T getob() {
		
		return ob;
		
	}
	
	void showType() {
		
		System.out.println("Type of T is " + ob.getClass().getName());
		
	}
	
}

public class GenDemo {
	
	public static void main(String args[]) {
		
		
		
		Gen<Integer> iOb;
		
		iOb = new Gen<Integer>(88);
		
		iOb.showType();
		
		int v = iOb.getob();
		
		System.out.println("value: " + v);
		
		Gen<Double> dOb;
		
		dOb = new Gen<Double>(8.8);
		
		dOb.showType();
		
		double dou = dOb.getob();
		
		System.out.println("value: " + dou);
		
		System.out.println();
		
		Gen<String> strOb = new Gen<String>("Generics Test");
		
		strOb.showType();
		
		String str = strOb.getob();
		
		System.out.println("value: " + str);
		
		System.out.println();
		
	}
	
}