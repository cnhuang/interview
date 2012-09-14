package question;

import java.util.Random;
import java.util.Stack;

public class SortStack
{

	public static void main(String[] args)
	{
		Sort(GenerateTestStack());
	}
	
	
	public static void Sort(Stack<Integer> s)
	{	
		Stack<Integer> s2 = new Stack<Integer>();
		
		while(!s.isEmpty())
		{
			int i1 = s.pop();
			if(s2.isEmpty() || s2.peek() >= i1)
				s2.add(i1);
			else
			{
				do
				{
					s.add(s2.pop());
				}while(!s2.isEmpty() && s2.peek() <= i1);				
				s2.add(i1);
			}
			
			System.out.println(s.size()+","+i1+","+ (s2.isEmpty()? "-" :s2.peek()));
		}
		
		while(!s2.isEmpty())
		{
			System.out.println(s2.pop());
		}
		System.out.println();
	}
	
	public static Stack<Integer>  GenerateTestStack()
	{
		Random rand = new Random(System.currentTimeMillis());
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i = 0 ; i < 100 ; i++)
			s.add(rand.nextInt(1));
		
		return s;
	}

}
