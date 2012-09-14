package sort;

public class InsertionSort
{
	public static void main(String[] args)
	{
		int[] i = new int[] {3,5,2,6,3,54,65,8,7,12,3,5,6};
		Sort(i);
	}
	
	public static void Sort(int[] data)
	{
		for (int i = 1; i < data.length; i++)
		{
			int index = i;
			for (int j = i - 1; j >= 0; j--)
			{
				if (data[index] < data[j])
				{
					int tmp = data[index];
					data[index] = data[j];
					data[j] = tmp;
					index = j;
				}
			}
		}

		for (int i : data)
			System.out.print(i + ",");
		
		System.out.println();
	}
}
