package datastructure;

import atom.LinkedListNode;

public class LinkedList
{
	//Todo
	// Garbage collection
	// Array to simulate linked list P210
	
	//Done
	// delete
	// reverse

	LinkedListNode Head = null;
	LinkedListNode Tail = null;

	public LinkedList Add(LinkedListNode n)
	{
		if (Head == null)
		{
			Head = n;
			Tail = n;
		} else
		{
			Tail.Next = n;
			Tail = n;
		}
		
		return this;
	}

	public LinkedList Add(int i, LinkedListNode n)
	{
		int count = 0;
		LinkedListNode c = Head;
		LinkedListNode p = null;

		do
		{
			if (count == i)
			{
				if (p == null)
				{
					Head = n;

					if (c == null)
						Tail = n;
					else
						n.Next = c;
				} else
				{
					p.Next = n;
					n.Next = c;

					if (c == null)
						Tail = n;
				}
			}

			if (c == null)
				break;
			else
			{
				p = c;
				c = c.Next;
			}
			count++;

		} while (true);

		return this;
	}
	
	public void Delete(int n)
	{
		int count = 0;
		LinkedListNode c = Head;
		LinkedListNode p = null;

		while (c != null)
		{
			if (count == n)
			{
				if (p == null)
					Head = c.Next;
				else
					p.Next = c.Next;

				if (Tail == c)
				{
					if (p == null)
						Tail = null;
					else
						Tail = p;
				}
				break;
			}

			if (c.Next != null)
			{
				p = c;
				c = c.Next;
			} else
				break;

			count++;
		}
	}

	public void Reverse()
	{
		LinkedListNode pre = null;
		LinkedListNode cur = null;
		LinkedListNode nex = null;
		
		cur = Head;
		Tail = cur;
		
		while(cur != null)
		{
			nex = cur.Next;
			cur.Next = pre;
			pre = cur;
			cur = nex;			
		}
		
		Head = pre;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Head:").append(Head).append(", Tail:").append(Tail).append(", Data:");
		
		LinkedListNode l = Head;
		
		while(l != null)
		{
			sb.append(",").append(l);
			l = l.Next;
		}
		
		return sb.toString();
	}
	
	public static LinkedList GetTestList()
	{
		LinkedList ll = new LinkedList();
		ll.Add(new LinkedListNode(1)).Add(new LinkedListNode(2))
		.Add(new LinkedListNode(3)).Add(new LinkedListNode(4))
		.Add(new LinkedListNode(5)).Add(new LinkedListNode(6))
		.Add(new LinkedListNode(7)).Add(new LinkedListNode(8));
		
		return ll;		
	}
		
	public static void main(String[] args)
	{
		//Test Add
		System.out.println("Test Add To Tail");
		System.out.println(GetTestList());
		
		System.out.println("Test Add by index");
		LinkedList ll = new LinkedList();
		ll.Add(5,new LinkedListNode(5));
		ll.Add(0,new LinkedListNode(1));
		ll.Add(0,new LinkedListNode(0));
		ll.Add(2,new LinkedListNode(3));
		ll.Add(2,new LinkedListNode(2));
		System.out.println(ll);
		
		System.out.println("Test Delete by index");
		ll = GetTestList();
		ll.Delete(0);
		System.out.println(ll);
		ll.Delete(7);
		System.out.println(ll);
		ll.Delete(6);
		System.out.println(ll);
		ll.Delete(2);
		System.out.println(ll);
		ll.Delete(0);
		ll.Delete(0);
		ll.Delete(0);
		ll.Delete(0);
		ll.Delete(0);
		System.out.println(ll);
		
		System.out.println("Test Reverse");
		ll = GetTestList();
		System.out.println(ll);
		ll.Reverse();
		System.out.println(ll);
		
	}

	
}

