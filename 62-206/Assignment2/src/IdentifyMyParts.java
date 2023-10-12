public class IdentifyMyParts
{
	public static int x=7;
	public int y=3;
	
	public static void main(String args[])
	{
		IdentifyMyParts a=new IdentifyMyParts();
		IdentifyMyParts b=new IdentifyMyParts();
		a.y=5;
		b.y=6;
		a.x=1;
		b.x=2;
		System.out.println("a.y = "+a.y); // a.y = 5 - it is the newly assigned value
		System.out.println("b.y = "+b.y);   // b.y = 6 - it is the newly assigned value
		System.out.println("a.x = "+a.x);   // a.x = 2 - it is the newly assigned value
		System.out.println("b.x = "+a.x);   // b.x = 2 - it is the newly assigned value
		
		System.out.println("IdentifyMyParts.x = "+IdentifyMyParts.x);

// IdentifyMyParts.x = 2 , can use class with class variable to assign value
	}
}