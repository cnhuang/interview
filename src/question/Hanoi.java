package question;

public class Hanoi
{

	public static void main(String args[])
	{		
		Integer N = new Integer(6);
		Run(N.intValue(), 3, 1, 2);
		System.exit(0);
	}

	static void Run(int n, int t, int f, int u)
	{
		if (n > 0)
		{
			Run(n - 1, u, f, t);
			Move(n, f, t);
			Run(n - 1, t, u, f);
		}
	}

	static void Move(int n, int from, int to)
	{
		System.out.print("move ");
		System.out.print(n);
		System.out.print(" : ");
		System.out.print(from);
		System.out.print(" --> ");
		System.out.println(to);
	}
}
