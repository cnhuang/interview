package question;

import java.util.HashSet;
import atom.LinkedListNode;

public class RemoveDuplicateCharFromUnsortedLinkedList
{

	// Crack code interview P 105
	public static void main(String[] args)
	{
		String str = "jfldkgjl34kjlkfjg";
		LinkedListNode n = CreateLinkedList(str);
		Print(n);
		M_HasBuffer(n);
		Print(n);
		n = CreateLinkedList(str);
		M_HasBuffer(n);
		Print(n);
		n = CreateLinkedList(str);
		M_HasBuffer2(n);
		Print(n);
	}

	public static void M_HasBuffer(LinkedListNode head)
	{
		LinkedListNode n = head;
		boolean[] b = new boolean[255];

		b[n.Data] = true;

		while (n.Next != null)
		{
			if (!b[n.Next.Data])
			{
				b[n.Next.Data] = true;
				n = n.Next;
			}
			else
			{
				n.Next = n.Next.Next;
			}
		}
	}

	public static void M_HasBuffer2(LinkedListNode head)
	{
		LinkedListNode n = head;
		HashSet<Integer> ht = new HashSet<Integer>();
		ht.add(head.Data);
		
		while (n.Next != null)
		{
			if (!ht.contains(n.Next.Data))
			{
				ht.add(n.Next.Data);
				n = n.Next;
			}
			else
			{
				n.Next = n.Next.Next;
			}
		}
	}

	
	public static void M_NoBuffer(LinkedListNode head)
	{
		LinkedListNode n = head.Next;
		LinkedListNode c = head;
		
		while(n != null)
		{
			LinkedListNode tmp = head;
			
			while(tmp != n)
			{
				if(tmp.Data == n.Data)
					break;
				tmp = tmp.Next;
			}
			
			if(tmp == n)
			{
				c.Next = n;
				c = c.Next;
			}
			
			n = n.Next;
		}
		
		c.Next = null;		
	}

	public static LinkedListNode CreateLinkedList(String str)
	{
		char[] cs = str.toCharArray();
		LinkedListNode head = new LinkedListNode(cs[0]);
		LinkedListNode tmp = head;
		for (int i = 1; i < cs.length; i++)
		{	
			tmp.Next = new LinkedListNode(cs[i]);
			tmp = tmp.Next;
		}

		return head;
	}

	public static void Print(LinkedListNode head)
	{
		LinkedListNode n = head;
		while (n != null)
		{
			System.out.print((char) n.Data);
			n = n.Next;
		}

		System.out.println();
	}

}
