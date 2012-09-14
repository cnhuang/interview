package question.amazon;

public class SearchSorted3DArray
{

	// http://www.careercup.com/question?id=12666670
	public static void main(String[] args)
	{
		int[][][] arr =
		{
		{
		{ 11, 12, 13 },
		{ 14, 15, 16 },
		{ 17, 18, 19 } },

		{
		{ 21, 22, 23 },
		{ 24, 25, 26 },
		{ 27, 28, 29 } },

		{
		{ 31, 32, 33 },
		{ 34, 35, 36 },
		{ 37, 38, 39 } } };

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
				{
					System.out.print("Find " + arr[i][j][k] + ":");
					Search(arr, arr[i][j][k]);
				}
	}

	public static void Search(int[][][] arr, int target)
	{
		int deep = arr.length;

		for (int i = deep - 1; i >= 0; i--)
		{
			if (arr[i][0][0] <= target)
			{
				Search(arr, target, i);
				return;
			}
		}

		System.out.println("Not Found");
	}

	public static void Search(int[][][] arr, int target, int z)
	{
		int x =  arr.length - 1;
		int y = 0;

		while (x >= 0 && y < arr[0].length)
		{
			if (arr[z][y][x] == target)
			{
				System.out.println("Find arr[" + z + "][" + y + "][" + x
						+ "] = " + arr[z][y][x]);
				return;
			}
			else if (arr[z][y][x] < target)
				y++;
			else
				x--;
		}
		System.out.println("Not Found");
	}

}
