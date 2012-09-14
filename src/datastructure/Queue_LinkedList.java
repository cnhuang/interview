package datastructure;

import atom.LinkedListNode;

public class Queue_LinkedList
{
	LinkedListNode head, tail;

	public Queue_LinkedList()
	{

	}
	
	public void Push(int i)
	{
		LinkedListNode n = new LinkedListNode(i);
		if(head == null)
		{
			head = n;
			tail = n;
		}
		else
		{
			tail.Next = n;
			tail = n;
		}
	}
	
	public int Poll()
	{
		if(head != null)
		{
			int data = head.Data;
			if(head == tail)
			{
				head = null;
				tail = null;
			}
			else
				head = head.Next;
			
			return data;
		}
		
		return Integer.MIN_VALUE;
	}
}
