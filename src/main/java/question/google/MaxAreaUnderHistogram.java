package question.google;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class MaxAreaUnderHistogram
{

	@Test
	public void FindTest()
	{
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Find(data);
		data = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Find(data);
		data = new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1 };
		Find(data);
		data = new int[] { 9, 8, 7, 6, 5, 6, 7, 8, 9 };
		Find(data);
		data = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
		Find(data);
	}

	public void Find(int[] data)
	{
		Stack<Integer> stack = new Stack<Integer>();
		int[] area = new int[data.length];

		for (int i = 0; i < data.length; i++)
		{
			while (!stack.isEmpty())
			{
				if (data[stack.peek()] >= data[i])
				{
					// pop out non-blocking bars
					stack.pop();
				} else
					//see the blocking bar
					break;
			}

			if (stack.isEmpty())
			{
				// all on the left is valid
				area[i] = i;
			} else
			{
				area[i] = i - stack.peek() - 1;
			}

			stack.push(i);
			// System.out.println(stack);
		}

		System.out.println(Arrays.toString(area));
		stack.clear();
		for (int i = data.length - 1; i >= 0; i--)
		{
			// System.out.println(stack);
			while (!stack.isEmpty())
			{
				if (data[stack.peek()] >= data[i])
				{
					// valid
					stack.pop();
				} else
					break;
			}

			if (stack.isEmpty())
			{
				area[i] = (area[i] + 1 + (data.length - i - 1)) * data[i];
			} else
			{
				area[i] = (area[i] + 1 + stack.peek() - i - 1) * data[i];
			}

			stack.push(i);

		}

		int maxIndex = -1;

		for (int i = 0; i < data.length; i++)
		{
			if (maxIndex == -1 || area[i] > area[maxIndex])
			{
				maxIndex = i;
			}
		}

		System.out.println("Max Index = " + maxIndex + ", area = " + area[maxIndex]);
		System.out.println("Data " + Arrays.toString(data));
		System.out.println("Area " + Arrays.toString(area));
	}
}
