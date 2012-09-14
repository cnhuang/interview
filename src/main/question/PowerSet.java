package question;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{

	public static void main(String[] args)
	{
		String str = "abcde";
		M_Recursive(str);
		M_For(str);
	}

	static int Count = 0;

	public static void M_Recursive(String s)
	{
		Count = 0;
		char[] result = new char[s.length()];
		Recursive(s, 0, result, 0);
		System.out.println(Count);
	}

	private static void Recursive(String s, int cursor, char[] result, int count)
	{
		if (cursor == s.length())
		{
			for (int i = 0; i < count; i++)
				System.out.print(result[i]);
			System.out.println();
			Count++;
		} else
		{
			result[count] = s.charAt(cursor);
			Recursive(s, cursor + 1, result, count + 1);
			Recursive(s, cursor + 1, result, count);
		}
	}

	public static void M_For(String s)
	{
		List<String> result = new ArrayList<String>();
		
		if(s != null)
		{
			result.add("");
			
			for(int i = 0 ; i < s.length() ; i++)
			{
				List<String> tmp = new ArrayList<String>();				
				for(int j = 0 ; j < result.size() ; j++)
				{
					tmp.add(result.get(j)+s.charAt(i));
				}
				result.addAll(tmp);
			}
		}
		
		for(String str :result)
			System.out.println(str);
		
		System.out.println(result.size());
	}

}
