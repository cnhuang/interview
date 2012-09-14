package question;

import java.util.ArrayList;
import java.util.List;

public class Permutation
{
	public static void main(String[] args)
	{
		String s = "abcde";
		M_Recursive(s);
		System.out.println(Count);
		M_For(s);
	}

	static int Count = 0;

	public static void M_Recursive(String str)
	{
		Count = 0;
		if (str == null)
			return;

		if (str.length() <= 1)
		{
			System.out.println(str);
			Count++;
		} else
		{
			boolean[] choose = new boolean[str.length()];
			char[] result = new char[str.length()];
			int cursor = 0;
			Recursive(str, choose, result, cursor);
		}

	}

	private static void Recursive(String str, boolean[] choose, char[] result,
			int cursor)
	{
		if (cursor == str.length())
		{
			System.out.println(result);
			Count++;
		}

		for (int i = 0; i < choose.length; i++)
		{
			if (!choose[i])
			{
				choose[i] = true;
				result[cursor] = str.charAt(i);
				Recursive(str, choose, result, cursor + 1);
				choose[i] = false;
			}
		}
	}

	public static List<String> M_For(String str)
	{
		List<String> result = new ArrayList<String>();

		if (str == null || str.length() == 0)
			return result;
		else
		{
			result.add(String.valueOf(str.charAt(0)));
			
			for(int i = 1 ; i < str.length() ; i++)
			{
				char t = str.charAt(i);
				
				List<String> tmp = new ArrayList<String>();
				
				for(int j = 0 ; j < result.size(); j++)
				{
					String tStr = result.get(j);
					
					for(int k = 0 ; k < tStr.length() ; k++)
					{
						tmp.add(tStr.substring(0,k)+t+tStr.substring(k,tStr.length()));
					}
					tmp.add(tStr+t);
				}
				
				result = tmp;
			}
		}
		
		for(String s : result)
			System.out.println(s);
		
		System.out.println(result.size());
		
		return result;
	}
}
