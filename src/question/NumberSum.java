package question;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberSum
{
	static Comparator<Integer> Compare = new Comparator<Integer>()
	{
		@Override
		public int compare(Integer o1, Integer o2)
		{
			return o1 - o2;
		}
	};
	
	public static void main(String[] args)
	{
		int sum = 0;
		Integer[] numbers = {5,7,2,8,3,4,-2,5,-2,-45,-3,-1,17,28};
		List<Integer> input = Arrays.asList(numbers);
		TwoNumbers.M1_TwoEnd(input, sum);
		ThreeNumbers.M1_TwoEnd(input, sum);
	}
}

class ThreeNumbers
{
	public static void M1_TwoEnd(List<Integer> numbers, int sum)
	{
		Collections.sort(numbers, NumberSum.Compare);

		int k = 0;
		while(numbers.get(k) <= sum)
		{
			int i = k+1; 
			int j = numbers.size()-1;
			
			while(j > i)
			{
				int count = numbers.get(j)+numbers.get(i)+numbers.get(k);
				
				if(count == sum)
				{
					System.out.println(String.format("%d,%d,%d",numbers.get(k), numbers.get(j),numbers.get(i)));
					i++;
					j--;
				}
				else if(count > 0)
				{
					j--;
				}
				else
				{
					i++;
				}
			}
			
			k++;
		}
	}	
}

class TwoNumbers
{
	public static void M1_TwoEnd(List<Integer> numbers, int sum)
	{
		Collections.sort(numbers, NumberSum.Compare);

		int i = 0 ; 
		int j = numbers.size()-1;
		
		while(j > i)
		{
			int count = numbers.get(j)+numbers.get(i);
			
			if(count == sum)
			{
				System.out.println(String.format("%d,%d", numbers.get(j),numbers.get(i)));
				i++;
				j--;
			}
			else if(count > 0)
			{
				j--;
			}
			else
			{
				i++;
			}
		}
	}	
}