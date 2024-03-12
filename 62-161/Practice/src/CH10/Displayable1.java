package CH10;
// code listing 10-35 pg#713

public interface Displayable1 {
	default void display(){
		System.out.println("This is the default display method.");
	}
}
