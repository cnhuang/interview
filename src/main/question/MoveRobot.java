package question;

import java.util.*;

public class MoveRobot
{

	// Crack code interview p 170
	public static void main(String[] args)
	{
		System.out.println(Move(2, 2));
	}

	public static int Move(int x, int y)
	{
		return MoveHelper(x, y, new Stack<String>());
	}

	public static int MoveHelper(int x, int y, Stack<String> path)
	{
		int count = 0;

		if (0 == x && 0 == y)
		{
			System.out.print("Path:");
			for (String s : path)
			{
				System.out.print(s);
			}
			System.out.println();
			return 1;
		}

		if (0 < x)
		{
			path.add("R");
			count += MoveHelper(x - 1, y, path);
			path.pop();
		}

		if (y > 0)
		{
			path.add("D");
			count += MoveHelper(x, y - 1, path);
			path.pop();
		}

		return count;

	}

}
