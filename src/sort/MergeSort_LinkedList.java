package sort;

import atom.LinkedListNode;

public class MergeSort_LinkedList
{

	public static void main(String[] args)
	{
		LinkedListNode h1 = new LinkedListNode(1);
		LinkedListNode tmp = h1;

		for (int i = 3; i < 100; i += 2)
		{
			tmp.Next = new LinkedListNode(i);
			tmp = tmp.Next;
		}

		LinkedListNode h2 = new LinkedListNode(0);
		tmp = h2;

		for (int i = 2; i < 100; i += 2)
		{
			tmp.Next = new LinkedListNode(i);
			tmp = tmp.Next;
		}
		
		LinkedListNode r = Sort(h1,h2);
		
		while(r != null)
		{
			System.out.print(r.Data+",");
			r = r.Next;			
		}
		
		System.out.println();
	}
	
	public static LinkedListNode Sort(LinkedListNode h1, LinkedListNode h2)
	{
		if(h1 == null)
			return h2;
		
		if(h2 == null)
			return h1;
				
		LinkedListNode head = null;
		LinkedListNode tmp = null;
		
		while(true)
		{			
			if(h1 == null)
			{
				tmp.Next = h2;
				return head;				
			}
			else if(h2 == null)
			{
				tmp.Next = h1;
				return head;
			}
			else
			{
				LinkedListNode winner;
				if(h1.Data > h2.Data)
				{
					winner = h2;
					h2 = h2.Next;
				}
				else
				{
					winner = h1;
					h1 = h1.Next;
				}
				
				if(tmp == null)
				{
					head = winner;
					tmp = winner;
				}
				else
				{
					tmp.Next = winner;
					tmp = tmp.Next;
				}
			}
		}
	}
}
