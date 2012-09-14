package question;

import java.util.ArrayList;

public class MergeIntervals
{

	/**
	 * http://www.careercup.com/question?id=13014685 Given a set of non
	 * overlapping intervals
	 * 
	 * @Example1 (1,4) (6,10) (14, 19) and another interval (13, 17) merge them
	 *           as (1,4) (6,10) (13,19)
	 * @Example2 (1,5) (6, 15) (20, 21) (23, 26) (27, 30) (35, 40) New interval
	 *           (14, 33) Output should be (1,5) (6, 33) (35, 40)
	 */
	public static void main(String[] args)
	{
		ArrayList<Interval> data = new ArrayList<Interval>();
		data.add(new Interval(1, 4));
		data.add(new Interval(6, 10));
		data.add(new Interval(14, 19));
		ArrayList<Interval> result = Merge(data, new Interval(13, 17));
		System.out.println(result);

		data = new ArrayList<Interval>();
		data.add(new Interval(1, 5));
		data.add(new Interval(6, 15));
		data.add(new Interval(20, 21));
		data.add(new Interval(23, 26));
		data.add(new Interval(27, 30));
		data.add(new Interval(35, 40));
		result = Merge(data, new Interval(14, 33));
		System.out.println(result);
	}

	public static ArrayList<Interval> Merge(ArrayList<Interval> data, Interval newInterval)
	{
		ArrayList<Interval> result = new ArrayList<Interval>();

		for (int i = 0; i < data.size(); i++)
		{
			Interval d = data.get(i);
			boolean intersection = !(newInterval.End < d.Start || d.End < newInterval.Start);

			// No merge and no intersection
			if (!intersection)
			{
				// if new interval go first, End
				if (newInterval.End < d.Start)
				{
					result.add(newInterval);
					result.addAll(data.subList(i, data.size()));
					return result;
				}
				// d go first
				else
				{
					result.add(d);
				}
			}
			// intersection => generate new interval
			else
			{
				int s = Math.min(d.Start, newInterval.Start);
				int e = Math.max(d.End, newInterval.End);
				newInterval = new Interval(s, e);
			}
		}

		result.add(newInterval);
		return result;
	}

}
