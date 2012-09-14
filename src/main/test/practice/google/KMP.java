package test.practice.google;

public class KMP
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String strSource = "ABC ABCDABAABCDABCDABDE";
		String strTarget = "ABCDABD";
		System.out.println(KMP_Mathch(strTarget, strSource));
	}

	public static String Match(String target, String source)
	{
		int nextIndex = -1;
		for (int i = 0; i < source.length();)
		{
			int j = 0;

			for (; j < target.length(); j++)
			{
				System.out.println(String.format("New Index: Target %d Source %d NewStart %d", j,
						i, nextIndex));

				if (source.length() - i < target.length() - j)
					return "";

				if (j != 0 && source.charAt(i) == target.charAt(0) && nextIndex == -1)
					nextIndex = i;

				if (source.charAt(i) == target.charAt(j))
				{
					i++;
				} else
				{
					if (nextIndex == -1)
						i++;
					break;
				}
			}

			if (j == target.length())
				return source.substring(i - j, i);

			if (nextIndex != -1)
			{
				i = nextIndex;
				nextIndex = -1;
			}

		}

		return "";
	}

	public static String KMP_Mathch(String target, String source)
	{
		//next start point of source
		int nextIndex = -1;
		//start point of matched string
		int head = 0;
		//index of target string
		int count = 0;

		for (int i = 0; i < source.length(); i++)
		{			
			//if not match
			if (source.charAt(i) != target.charAt(count))
			{
				//if there is a recorded starting point
				if(nextIndex != -1)
				{
					i = nextIndex;
					nextIndex = -1;				
				}				
				
				//reset count
				count = 0;
				
			} else
			{				
				count++;
				
				//if matched length == target length
				if (count == target.length())				
					return source.substring(head, head+count);
				
				else
				{
					//if there is no start point && current char can be a start point && target index != 0
					if(nextIndex == -1 && count != 1 && source.charAt(i) == target.charAt(0) )
					{
						nextIndex = i;
					}
					
					//if target index == 1, reset head
					if(count == 1)
						head = i;
				}							
			}
		}
		
		return null;
	}

}
