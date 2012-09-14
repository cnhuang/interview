package question;

import java.util.ArrayList;
import java.util.List;

public class Parentheses
{

	public static void main(String[] args)
	{
		int n = 3;
		M_Recursive(n);
		System.out.println("=======================");
		M_For(n);
	}

	public static void M_Recursive(int n)
	{
		Recursive(n,0,0,"");
	}
	
	private static void Recursive(int n, int left, int right, String result)
	{		
		if(left == n && right == n)
			System.out.println(result);
		
		if(left > right && right < n)
			Recursive(n,left,right+1, result+")");
		
		if(left < n)
			Recursive(n,left+1,right, result+"(");			
	}
	
	public static void M_For(int n)
	{
		List<String> result = new ArrayList<String>();
		result.add("");
		
		for(int i = 0 ; i < n*2 ; i++)
		{
			List<String> tmp = new ArrayList<String>();
			for(String str : result)
			{				
				int left = 0;
				int right = 0;
				
				for(int j = 0 ; j < str.length() ; j++)
					if(str.charAt(j) == '(')
						left++;
					else
						right++;

				if(left > right && right < n)
				{
					tmp.add(str+")");
				}
				
				if(left < n)
				{
					tmp.add(str+"(");
				}
			}
			
			result = tmp;
		}
		
		for(String str: result)
			System.out.println(str);
	}
}
