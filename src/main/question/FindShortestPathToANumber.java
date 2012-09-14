package question;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class FindShortestPathToANumber
{
	/*
	 * @given a special series which starts from 1 and has the number @ position
	 * i == Sum of any 2 previous numbers (a number can be selected twice)
	 * 
	 * @Example : 1 2 3 or 1 2 2 or 1 2 4
	 * 
	 * @Find a quickest way to generate a number N
	 */

	// @Test
	public void FindTest()
	{
		ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> seed = new ArrayList<Integer>();
		seed.add(1);
		data.add(seed);
		ArrayList<Integer> result = Find(5, data);

		System.out.println(result);
	}

	public ArrayList<Integer> Find(int N, ArrayList<ArrayList<Integer>> data)
	{
		ArrayList<ArrayList<Integer>> newData = new ArrayList<ArrayList<Integer>>();

		for (ArrayList<Integer> arr : data)
		{
			for (int i = 0; i < arr.size(); i++)
			{
				for (int j = 0; j < arr.size(); j++)
				{
					int num = arr.get(i) + arr.get(j);

					if (!arr.contains(num) && num <= N)
					{
						ArrayList<Integer> tmp = (ArrayList<Integer>) arr.clone();
						tmp.add(num);

						if (num == N)
						{
							return tmp;
						} else
						{
							newData.add(tmp);
						}
					}
				}
			}
		}

		return Find(N, newData);
	}

	@Test
	public void FindWithTreeStructure()
	{
		ArrayList<MyNode> seed = new ArrayList<MyNode>();
		MyNode root = new MyNode(1, null);
		seed.add(root);
		MyNode result = FindWithTreeStructure(70, seed);

		while (result != null)
		{
			System.out.print(result.Value + " ");
			result = result.Parent;
		}
		System.out.println(".Done");
	}

	
	public MyNode FindWithTreeStructure(int N, ArrayList<MyNode> candidate)
	{
		System.out.println(candidate);
		ArrayList<MyNode> newCandidate = new ArrayList<MyNode>();

		for (MyNode n : candidate)
		{			
			MyNode n1 = n;
			HashSet<Integer> tmp = new HashSet<Integer>();

			while(n1 != null)
			{
				MyNode n2 = n;
				
				while(n2 != null)
				{
					int value = n1.Value+n2.Value;
					if(value == N)
					{
						return new MyNode(value, n);
					}
					else if(value < N && value > n.Value && !tmp.contains(value))
					{
						newCandidate.add(new MyNode(value, n));
						tmp.add(value);
					}
					else
						break;
					
					n2 = n2.Parent;
				}
				
				n1 = n1.Parent;
			}					
		}
		
		if(newCandidate.size() == 0)
			return null;

		return FindWithTreeStructure(N, newCandidate);
	}
}

class MyNode
{
	int Value;
	MyNode Parent;

	public MyNode(int value, MyNode p)
	{
		Value = value;
		Parent = p;
	}

	public String toString()
	{
		return String.valueOf(Value);
	}
}
