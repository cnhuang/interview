package question;

import java.util.Random;

public class ThreeDynamicStackUsingOneArray
{
	// Crack code interview p112
	public static void main(String[] args) throws Exception
	{
		Random rand = new Random(System.currentTimeMillis());
		ThreeDynamicStackUsingOneArray stacks = new ThreeDynamicStackUsingOneArray(
				100);
		int[][] d = new int[3][300];
		int[] index = new int[3];

		for (int i = 0; i < 300; i++)
		{
			int data = i;
			int stack = rand.nextInt(3);
			d[stack][index[stack]] = i;
			index[stack]++;
			stacks.Add(stack + 1, data);
		}

		for (int i = 0; i < 3; i++)
		{
			System.out.println("Stack" + (i + 1) + " from cache:");
			for (int j = index[i] - 1; j >= 0; j--)
				System.out.print(d[i][j] + ",");
			System.out.println();

			System.out.println("Stack" + (i + 1) + " from queue:");
			int tmp = stacks.index[i + 1];
			while (tmp != -1)
			{
				StackNode sn = stacks._arr[tmp];
				System.out.print(sn.Data + ",");
				tmp = sn.PreIndex;
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();

		stacks = new ThreeDynamicStackUsingOneArray(10);
		for (int i = 0; i < 30; i++)
		{
			stacks.Add(1, i);
			System.out.println(stacks);
		}

		try
		{
			stacks.Add(1, 10);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			stacks.Add(2, 10);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			stacks.Add(3, 10);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		for (int i = 0; i < 30; i++)
		{			
			System.out.println(" Pop "+stacks.Pop(1)+" " + stacks);
		}
		
		try
		{
			stacks.Pop(1);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			stacks.Pop(2);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			stacks.Pop(3);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		stacks = new ThreeDynamicStackUsingOneArray(10);
		for (int i = 0; i < 20; i++)
		{
			stacks.Add(1, i);
			System.out.println(stacks);
		}
		for (int i = 0; i < 10; i++)
		{			
			System.out.println(" Pop "+stacks.Pop(1)+" " + stacks);
		}
		for (int i = 0; i < 20; i++)
		{
			stacks.Add(1, i);
			System.out.println(stacks);
		}

	}

	public StackNode[] _arr;
	public int[] index =
	{ -1, -1, -1, -1 };
	int count = 0;

	public ThreeDynamicStackUsingOneArray(int singleStackSize)
	{
		_arr = new StackNode[singleStackSize * 3];
	}

	public void Add(int s, int data) throws Exception
	{
		int free = -1;
		if (count < _arr.length)
		{
			free = count++;
		}
		else if (index[0] != -1)
		{
			free = index[0];
			index[0] = _arr[free].PreIndex;
		}

		if (free != -1)
		{
			_arr[free] = new StackNode(index[s], data);
			index[s] = free;
		}
		else
			throw new Exception("Overflow");
	}

	public int Pop(int s) throws Exception
	{
		if (index[s] == -1)
			throw new Exception("No Data");

		StackNode data = _arr[index[s]];
		_arr[index[s]] = new StackNode(index[0], -1);
		index[0] = index[s];
		index[s] = data.PreIndex;
		return data.Data;
	}

	public int Peek(int s) throws Exception
	{
		if (index[s] == -1)
			throw new Exception("No Data");
		else
			return _arr[index[s]].Data;
	}

	public String toString()
	{
		return String.format("Count=%d, Index=[%d,%d,%d,%d]", count,index[0],index[1],index[2],index[3]);
	}
}

class StackNode
{
	public int PreIndex;
	public int Data;

	public StackNode(int index, int data)
	{
		PreIndex = index;
		Data = data;
	}
}
