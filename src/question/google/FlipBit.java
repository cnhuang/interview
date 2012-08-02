package question.google;

public class FlipBit
{

	//http://www.careercup.com/question?id=12590665
	//given n, m. Flip nth bit of m
	public static void main(String[] args)
	{
		int n = 3;
		int m = 8;
		
		int tmp = m;
		
		if( (tmp >> (n-1) & 1) == 1)
			tmp &=~(1 << (n-1)) ;
		else
			tmp |=(1 << (n-1)) ;
		
		System.out.println(tmp);
		
		System.out.println(m ^= (1<<n-1));
	}

}
