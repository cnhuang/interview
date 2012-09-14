package question;

import java.util.*;
import org.junit.Test;

public class CircusTower
{
	// Crack code interview p158
	@Test
	public void RecursiveTest()
	{
		Stack<Person> r = Recursive(GetTestData(), new Stack<Person>(), 0);
		for (int i = 0; i < r.size(); i++)
			System.out.println(r.get(i));
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	public Stack<Person> Recursive(List<Person> ppl, Stack<Person> current, int index)
	{
		if (current == null)
			current = new Stack<Person>();

		if (index == ppl.size())
			return current;

		Person candidate = ppl.get(index);
		Person top = current.isEmpty() ? null : current.peek();

		Stack<Person> best;

		if (top == null || (top.Height >= candidate.Height && top.Weight >= candidate.Weight))
		{
			best = (Stack<Person>) current.clone();
			best.add(candidate);
			best = Recursive(ppl, best, index + 1);

		} else
		{
			// start a new seq
			best = new Stack<Person>();
			best.add(candidate);
			best = Recursive(ppl, best, index + 1);
		}

		// skip the existing seq
		Stack<Person> tmp2 = Recursive(ppl, current, index + 1);

		if (tmp2.size() > best.size())
			best = tmp2;

		return best;
	}

	int count = 0; 
	
	@Test
	public void DynamicProgrammingTest()
	{
		count = 0;
		List<Person> r = DynamicProgramming(GetTestData());
		for (int i = 0; i < r.size(); i++)
			System.out.println(r.get(i));
		System.out.println(count);
	}

	public List<Person> DynamicProgramming(List<Person> ppl)
	{
		HashMap<Integer, List<Person>> cache = new HashMap<Integer, List<Person>>();
		List<Person> max = new ArrayList<Person>();

		for (int i = 0; i < ppl.size(); i++)
		{
			List<Person> tmp = DynamicProgrammingHelper(ppl, i, cache);
			if (tmp.size() > max.size())
				max = tmp;
		}

		return max;
	}

	@SuppressWarnings("unchecked")
	public List<Person> DynamicProgrammingHelper(List<Person> ppl, int index, HashMap<Integer,List<Person>> cache )
	{
		if(cache.containsKey(index))
			return cache.get(index);
			
		List<Person> max = new ArrayList<Person>();
		Person candidate = ppl.get(index);
		for(int i = 0 ; i < index ; i++)
		{
			count++;
			Person p = ppl.get(i);
			if(p.Height > candidate.Height && p.Weight > candidate.Weight)
			{
				List<Person> tmp = DynamicProgrammingHelper(ppl,i,cache);
				if(tmp.size() > max.size())
					max = (List<Person>) ((ArrayList<Person>)tmp).clone();
			}
		}
		
		max.add(candidate);
		cache.put(index, max);
		return max;
	}

	public List<Person> GetTestData()
	{
		List<Person> ppl = new ArrayList<Person>();
		ppl.add(new Person(55, 80));
		ppl.add(new Person(170, 150));
		ppl.add(new Person(56, 90));
		ppl.add(new Person(75, 120));
		ppl.add(new Person(60, 95));
		ppl.add(new Person(68, 110));
		ppl.add(new Person(60, 100));
		return ppl;
	}

}

class Person
{
	public int Height;
	public int Weight;

	public Person(int h, int w)
	{
		Height = h;
		Weight = w;
	}

	public String toString()
	{
		return String.format("(%d,%d)", Height, Weight);
	}
}
