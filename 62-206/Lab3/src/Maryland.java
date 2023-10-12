public class Maryland extends State {
	Maryland() { /* null constructor */ }
	public void printMe() { System.out.println("Read it."); }
	public static void main(String[] args) {
		Region mid = new State();
		State md = new Maryland();
		Object obj = new Place();
		Place usa = new Region();
		md.printMe();
		mid.printMe();
		((Place) obj).printMe();
		obj = md;
		((Maryland) obj).printMe();
		obj = usa;
		((Place) obj).printMe();
		usa = md;
		((Place) usa).printMe();
	}
}
class State  extends Region {
	State() { /* null constructor */ }
	public void printMe() { System.out.println("Ship it."); }
}
class Region extends Place {
	Region() { /* null constructor */ }
	public void printMe() { System.out.println("Box it."); }
}
class Place extends Object {
	Place() { /* null constructor */ }
	public void printMe() { System.out.println("Buy it."); }
}
