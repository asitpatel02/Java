package Extra;

public class Test {
//	public static void main(String[] args) {


		public static long geometric(int a,int n)
		{
			if (n == 0)
				return 1;
			else
				return ((long)Math.pow(a, n) + geometric(a,n - 1));
		}


		public static void main(String[] args)
		{
			System.out.println(geometric(2,3));
		}
	}

//	}
