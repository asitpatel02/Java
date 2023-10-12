import java.util.Scanner;

public class Palindrome_Number {
	
	public static void main(String[] arg)
	{
		int num,x,y,rem;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number ");
		num=sc.nextInt();
		x=num;
		for(y=0;num>0;num/=10)
		{
			rem=num%10;
			y=(y*10)+rem;
		}
		if(y==x)
			System.out.println(x+" is a palindrome number ");
		else
			System.out.println(x+" is not a palindrome number ");
	}
}
