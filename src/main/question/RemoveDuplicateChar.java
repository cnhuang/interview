package question;

public class RemoveDuplicateChar
{
	//Cracking code interview p.97
	public static void main(String[] args)
	{
		char[] c = "fklsdjfl;kjflskjdr".toCharArray();
		M_InPlace(c);
		M_ExtraSpace(c);

	}
	
	public static void M_InPlace(char[] c)
	{
		if(c == null)
			return;
		if(c.length < 2)
			return;
		
		int tail = 1;
		
		for(int i = 1 ; i < c.length ; i++)
		{
			int j = 0;
			for(; j < tail ; j++)
			{
				if(c[i] == c[j])
					break;
			}
			
			if(j == tail)
			{
				c[tail++] = c[i];
			}
		}
		
		System.out.println(String.valueOf(c).substring(0,tail));		
	}
	
	public static void M_ExtraSpace(char[] c)
	{
		if(c == null)
			return;
		if(c.length < 2)
			return;
		
		boolean[] arr = new boolean[256];
		int tail = 1;
		arr[c[0]] = true;
			
		for(char cc : c)
			if(!arr[cc])
			{
				arr[cc] = true;
				c[tail++] = cc;
			}
		
		System.out.println(String.valueOf(c).substring(0,tail));		
	}

}
