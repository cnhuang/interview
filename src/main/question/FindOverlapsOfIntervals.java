package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FindOverlapsOfIntervals
{
	/*
	 * @Input: an array of intervals (1,3) (4,9) ...
	 * 
	 * @Output: find overlaps of each interval
	 */

	public void Find(TimeInterval[] intervals)
	{
		List<Time> times = new ArrayList<Time>();

		for (TimeInterval intval : intervals)
		{
			times.add(new Time(intval.Start, true));
			times.add(new Time(intval.End, false));
		}

		Collections.sort(times, new Comparator<Time>()
		{

			@Override
			public int compare(Time arg0, Time arg1)
			{
				return arg0.Value - arg1.Value;
			}
		});

		System.out.println(times);
		
		Time current = null;
		int count = 0;
		
		for(Time t : times )
		{
			if(current == null || current.Value != t.Value)
			{
				if(current != null)
					System.out.println(count);
				System.out.print("Time "+t.Value+" Count ");	
				current = t;
			}
			
			if(t.IsStart)
				count++;
			else 
				count--;
		}
		
		System.out.println(count);

	}
	
	@Test
	public void FindTest()
	{
		Find(GetTestData(20));
	}
	
	public static TimeInterval[] GetTestData(int n)
	{
		ArrayList<TimeInterval> data = new ArrayList<TimeInterval>();
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
					data.add(new TimeInterval(n2, n1));
				else
					data.add(new TimeInterval(n1, n2));
			}
		}

		TimeInterval[] ts = new TimeInterval[data.size()];
		return data.toArray(ts);
	}
	
}

class Time
{
	int Value;
	boolean IsStart;

	public Time(int value, boolean start)
	{
		Value = value;
		IsStart = start;
	}

	public String toString()
	{
		return String.format("%s-%d", IsStart ? "S" : "E", Value);
	}
}

class TimeInterval
{
	int Start;
	int End;

	public TimeInterval(int s, int e)
	{
		Start = s;
		End = e;
	}
}
