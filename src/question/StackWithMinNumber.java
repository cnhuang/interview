package question;

import java.util.Stack;

public class StackWithMinNumber
{
	Stack<Integer> s;
	Stack<Integer> s_min;

	public StackWithMinNumber()
	{
		s = new Stack<Integer>();
		s_min = new Stack<Integer>();
	}

	public void Push(int i)
	{
		s.add(i);
		if (s_min.size() == 0 || s_min.peek() >= i)
			s_min.add(i);
	}

	public int Min()
	{
		if (s_min.size() > 0)
			return s_min.peek();
		else
			return Integer.MIN_VALUE;
	}

	public int Pop()
	{
		int i = s.pop();
		if (i == s_min.peek())
			s_min.pop();

		return i;
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]
		{ 3, 5, 2, 6, 3, 54, 2, 65, 8, 7, 12, 3, 1, 5, 6 };
		StackWithMinNumber stack = new StackWithMinNumber();
		for (int i : arr)
		{
			stack.Push(i);
			System.out.println("Push " + i + ", Min=," + stack.Min());
		}

		for (int i = 0; i < arr.length; i++)
		{
			System.out.println("Pop " + stack.Pop() + ", Min=," + stack.Min());
		}
	}
}
