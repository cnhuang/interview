package utility;

public class UtilMgr {

	public static void Print(Object[] os)
	{
		for(Object o : os)
			System.out.print(o+",");
		
	}
	
	public static void Print(int[] arr)
	{
		for(int o : arr)
			System.out.print(o+",");
		
	}
	
	public static void PrintBits(int n)
	{
		String s = "";
		
		while(n != 0)
		{
			s = String.valueOf(n & 1)+s;
			n /= 2;
		}
		
		System.out.println(s);
	}
	
	public static int BitStringToInt(String s)
	{
		char[] c = s.toCharArray();
		int n = 0;
		
		for(int i = c.length -1 ; i >= 0 ; i--)
		{
			if(c[i] == '1')
				n |= 1 << (c.length-1-i);
		}
		
		return n;
	}
}
