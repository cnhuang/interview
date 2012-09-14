package question;

import java.util.ArrayList;
import java.util.Random;

public class FindIntervalWithMaxOverlap
{

	/**
	 * http://www.careercup.com/question?id=12743699 Given a set of intervals,
	 * find the interval which has the maximum number of intersections.	 * 
	 */
	public static void main(String[] args)
	{
		// Get Test Data
		ArrayList<Interval> data = GetTestData(20);
		System.out.println(data.toString());

		int[] count = new int[data.size()];

		for (int i = 0; i < data.size(); i++)
			for (int j = i + 1; j < data.size(); j++)
			{
				Interval d1 = data.get(i);
				Interval d2 = data.get(j);
				if (!(d1.Start > d2.End || d2.Start > d1.End))
				{
					count[i]++;
					count[j]++;
				}
			}

		int maxIndex = -1;

		for (int i = 0; i < count.length; i++)
			if (maxIndex == -1 || count[i] > count[maxIndex])
				maxIndex = i;

		System.out.println("Max Interval =" + data.get(maxIndex) + "; Count = " + count[maxIndex]);
	}

	
	
	
	public static ArrayList<Interval> GetTestData(int n)
	{
		ArrayList<Interval> data = new ArrayList<Interval>();
		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < n; i++)
		{
			int n1 = 0;
			int n2 = 0;

			while (n1 == n2)
			{
				n1 = rand.nextInt(500);
				n2 = rand.nextInt(500);

				if (n1 > n2)
					data.add(new Interval(n2, n1));
				else
					data.add(new Interval(n1, n2));
			}
		}

		return data;
	}

}

class Interval
{
	public int Start;
	public int End;

	public Interval(int s, int e)
	{
		Start = s;
		End = e;
	}

	public String toString()
	{
		return "(" + Start + "," + End + ")";
	}
}