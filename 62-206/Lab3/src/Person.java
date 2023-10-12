import java.util.Scanner;

public interface Person {
	public boolean equalTo(Person other);
	public String getName();
	public int getAge();
}
class Person1 implements Person{
	private final int age;
	private final String name;
	
	Person1(int a,String n){
		age = a;
		name = n;
	}
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean equalTo(Person other) {
		return age == other.getAge () && name.equals (other.getName ());
	}
		public void display(){
			System.out.print ("Name: " + name +"\n");
			System.out.print ("Age: " + age +"\n");
		}
	}
	
	class Main{
		public static void main(String[] args) {
			Scanner input = new Scanner (System.in);
			String Name1, Name2;
			int age1, age2;
			
			System.out.print ("Enter the First Person Name: ");
			Name1 = input.nextLine ();
			
			System.out.print ("Enter the Second Person Name: ");
			Name2 = input.nextLine ();
			
			System.out.print ("Enter the First Person age: ");
			age1 = input.nextInt ();
			
			System.out.print("Enter Second Person age: ");
			age2 = input.nextInt ();
			
			Person1 p1 = new Person1 (age1,Name1);
			Person1 p2 = new Person1 (age2,Name2);

			System.out.println ();
			System.out.println ("First Person Details");
			p1.display();
			System.out.println ();
			System.out.println ("Second Person Details");
			p2.display();
			
			System.out.println ();
			System.out.println ("Both are same :" + p1.equalTo (p2));
		}
	}