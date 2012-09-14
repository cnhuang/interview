package question.amazon;

public class PrintStarTree
{

	//http://www.careercup.com/question?id=12662674
	
	public static void main(String[] args)
	{
		Print(5);
	}
	
	public static void Print(int n)
	{
		Print_Sub(1,n,1);
	}
	
	public static void Print_Sub(int s, int e, int inc)
	{
		if(e%2 == 0)
			return;
		if(s < 0 )
			return;
		
		for(int i = 0 ; i < s ; i++)
			System.out.print("*");
		
		System.out.println();
		
		if(s == e && inc > 0)
			Print_Sub(e+inc*-1,1,inc*-1);
		else
			Print_Sub(s+inc,e,inc);
	}

}
