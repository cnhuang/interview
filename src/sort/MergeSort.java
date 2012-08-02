package sort;

import java.util.*;

import org.junit.Test;

public class MergeSort
{

	@Test
	public void SortTest()
	{
		Integer[] input = new Integer[] { 4, 1, -1, 23, 45, 23, 23, 77, 4, 7, 21, 654, 23, 0 };

		System.out.println(Sort(Arrays.asList(input)));
	}

	public List<Integer> Sort(List<Integer> input)
	{
		if (input.size() < 2)
			return input;
		else
		{
			return Merge(Sort(input.subList(0, input.size() / 2)),
					Sort(input.subList(input.size() / 2, input.size())));
		}

	}

	private List<Integer> Merge(List<Integer> l1, List<Integer> l2)
	{
		List<Integer> r = new ArrayList<Integer>();
		int s1 = 0;
		int s2 = 0;

		while (s1 < l1.size() || s2 < l2.size())
		{
			if (s1 == l1.size())
			{
				r.addAll(l2.subList(s2, l2.size()));
				break;
			}

			if (s2 == l2.size())
			{
				r.addAll(l1.subList(s1, l1.size()));
				break;
			}

			if (l1.get(s1) > l2.get(s2))
			{
				r.add(l1.get(s1++));
			} else
			{
				r.add(l2.get(s2++));
			}
		}

		return r;
	}

	@Test
	public void IterativeSortTest()
	{
		int[] input = new int[] { 4, 1, -1, 23, 45, 23, 23, 77, 4, 7, 21, 654, 23, 0 };
		System.out.println(Arrays.toString(IterativeSort(input)));
	}

	public int[] IterativeSort(int[] data)
	{
		int increment = 1;
		do
		{
			int[] tmp = new int[data.length];
			int tmpIndex = 0;
			
			increment *= 2;		

			for (int i = 0; i < data.length; i += increment)
			{
				int index1 = i;
				int index2 = i + increment / 2;
				
				//System.out.print("(" + index1 + "," + (i + increment) + ")");				
				
				while(index1 < (i + increment / 2) || index2 < Math.min(data.length, i + increment) )
				{					
					if(index1 == (i + increment / 2))
					{
						tmp[tmpIndex++] = data[index2++];						
					}
					else if(index2 == Math.min(data.length, i + increment))
					{
						tmp[tmpIndex++] = data[index1++];		
					}
					else if( data[index2] < data[index1])
					{
						tmp[tmpIndex++] = data[index2++];		
					}
					else
						tmp[tmpIndex++] = data[index1++];	
					
				}				
				
				//System.out.print("|");				
			}
			
			data =tmp;
			//System.out.println();
			//System.out.println(Arrays.toString(data));

		} while (increment < data.length);
		
		return data;

	}
}
