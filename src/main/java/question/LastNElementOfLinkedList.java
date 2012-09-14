package question;

import atom.LinkedListNode;

public class LastNElementOfLinkedList
{
	//@crack code interview p 106
	public static void main(String[] args)
	{
		LinkedListNode node = CreateLinkedList(10);
		Print(node);
		Find(node,1);
		Find(node,10);
		Find(node,5);
		Find(node,0);
		Find(node,12);
	}
	
	public static void Find(LinkedListNode head, int lastN)
	{
		
		System.out.println("Find "+lastN);
		
		if(lastN < 1)
		{
			System.out.println("No solution");
			return;
		}
			
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		
		
		while (n1 != null)
		{
			n1 = n1.Next;
						
			if(lastN <= 0)
			{
				n2 = n2.Next;
			}
			
			lastN--;				
		}
		
		if(lastN > 0)
			System.out.println("No solution");
		else
			System.out.println(n2.Data);
			
		
	}

	public static LinkedListNode CreateLinkedList(int n)
	{		
		if(n <= 0)
			return null;
		
		LinkedListNode head = new LinkedListNode(n);
		LinkedListNode c = head;
		
		for(int i = n-1 ; i > 0 ; i--)
		{
			c.Next = new LinkedListNode(i);
			c = c.Next;
		}
		return head;
	}

	public static void Print(LinkedListNode head)
	{
		LinkedListNode n = head;
		while (n != null)
		{
			System.out.print(n.Data+",");
			n = n.Next;
		}

		System.out.println();
	}

}
