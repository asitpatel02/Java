//import java.util.Scanner;
//
//class Person implements Comparable<Person>
//{
//	private String name;
//	private int age;
//
//	public Person(String name)
//	{
//		this.name = name;
//	}
//
//	public String getName()
//	{
//		return name;
//	}
//	public Person(int age)
//	{
//		this.age = age;
//	}
//
//	public int getage()
//	{
//		return age;
//	}
//	public String toString()
//	{
//		return "Name: " + name + "\t" + "Age: " + age;
//	}
//
//
//
//	@Override
//	public int compareTo(Person other)
//	{
//		int checkName = name.compareToIgnoreCase(other.name);
//
//		return checkName;
//	}
//}
//
//public class Person1
//{
//	public static void main(String args[])
//	{
//		Scanner s = new Scanner(System.in);
//		System.out.print("Enter first person name: ");
//		String firstName = s.next();
//
//		Person first = new Person(firstName);
//		System.out.print("Enter second person name: ");
//		String secondName = s.next();
//		Person second = new Person(secondName);
//		int n = second.compareTo(first);
//		if(n==0)
//		{
//			System.out.println("Both person are same");
//		}
//		else{
//			System.out.println("Both person are not same");
//		}
//	}
//}