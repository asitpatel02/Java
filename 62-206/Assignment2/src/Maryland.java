public class Maryland extends State {
	Maryland(){
		//null constructor
	}
	public void printMe() {
		System.out.println("Read it.");
	}
	
	public static void main(String[] args) {
		Region east = new State();
		State md = new Maryland();
		Object obj = new Place();
		Place usa = new Region();
		
		//md is of type state and State is parent class of Mayland.
		//Thus md can hold instance of Maryland. Hence, When printMe() is called, it will
		//print Maryland instance's printMe() method. It will print: "Read it".
		md.printMe();
		
		//east is of type Region and Region is parent class of State.
		//Thus east can hold instance of State. Hence, When printMe() is called, it will
		//print State instance's printMe() method.It will print: "Ship it".
		east.printMe();
		
		//obj is of type Object and Object is parent class of Place.
		//Thus obj can hold instance of Place. Hence, When printMe() is called after casting it to Place ,
		//it will print Place instance's printMe() method.It will print: "Buy it".
		((Place)obj).printMe();
		
		//Reference obj is now pointing to reference md(of type State). md is holding instance of Maryland
		//Thus obj is now holding instance of Maryland. Hence, When printMe() is called, it will
		//print Maryland instance's printMe() method.It will print: "Read it".
		obj = md;
		((Maryland)obj).printMe();
		
		//Reference obj is now pointing to reference usa(of type Place) . usa is holding instance of Region
		//Thus obj is now holding instance of Region. Hence, When printMe() is called, it will
		//print Region instance's printMe() method.It will print: "Box it".
		obj =usa;
		((Place)obj).printMe();
		
		//Reference usa is now pointing to reference md(of type State) . md is holding instance of Maryland
		//Thus usa is now holding instance of Maryland. Hence, When printMe() is called, it will
		//print Maryland instance's printMe() method.It will print: "Read it".
		usa = md;
		((Place)usa).printMe();
	}
	
}

class State extends Region{
	State(){
		//null constructor
	}
	public void printMe() {
		System.out.println("Ship it.");
	}
	
}

class Region extends Place{
	Region(){
		//null constructor
	}
	
	public void printMe() {
		System.out.println("Box it.");
	}
	
}

class Place extends Object{
	Place(){
		//Null constructor
	}
	public void printMe() {
		System.out.println("Buy it.");
	}
}