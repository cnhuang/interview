package question;

import org.junit.Test;

import atom.LinkedListNode;

public class CircularLinkedList
{

	/*
	 * @ Google phone interview question
	 * 
	 * @ Given a sorted circular linkedlist, insert a number into it
	 * 
	 * @ Find a number in a sorted circular linkedlist
	 */

	public LinkedListNode Insert(LinkedListNode node, int data)
	{
		if (node == null)
		{
			node = new LinkedListNode(data);
			node.Next = node;
			return node;
		} else if (node.Next == node)
		{
			LinkedListNode n = new LinkedListNode(data);
			node.Next = n;
			n.Next = node;
			return node;
		} else
		{
			LinkedListNode pre = node;
			LinkedListNode next = node.Next;

			while (true)
			{
				 // within 2 numbers
				if ((data >= pre.Data && data <= next.Data)
						// see the gap, pre = max, next = min. so if (data > pre) => Max or data < next (Min)
						|| ((next.Data < pre.Data) && (data < next.Data || data > pre.Data)))
				{
					LinkedListNode n = new LinkedListNode(data);
					pre.Next = n;
					n.Next = next;
					return node;
				}

				pre = next;
				next = next.Next;
			}
		}
	}

	@Test
	public void InsertTest1()
	{
		for (int i = 0; i <= 5; i++)
		{
			System.out.print("Insert Data = " + i);

			for (int j = 0; j < 4; j++)
			{
				LinkedListNode head = GetTestData1();

				for (int k = 0; k < j; k++)
					head = head.Next;

				System.out.println(", Start at " + head.Data);
				Insert(head, i);
				System.out.print("Result= ");
				Print(head);
				System.out.println();
			}
		}
	}

	@Test
	public void InsertTest2()
	{
		for (int i = 0; i <= 2; i++)
		{
			System.out.print("Insert Data = " + i);
			LinkedListNode head = GetTestData2();
			Insert(head, i);
			System.out.print(" Result= ");
			Print(head);
			System.out.println();
		}
	}

	public LinkedListNode Find(int target, LinkedListNode node)
	{
		if (node == null)
			return null;

		LinkedListNode n1 = node;

		do
		{
			if (n1.Data == target)
				return n1;

			n1 = n1.Next;
		} while (n1 != node);

		return null;
	}

	@Test
	public void FindTest()
	{
		LinkedListNode n = GetTestData1();

		for (int i = 0; i <= 5; i++)
			System.out.println("Find " + i + " => " + Find(i, n));
	}

	public LinkedListNode GetTestData1()
	{
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		n1.Next = (n2);
		n2.Next = (n3);
		n3.Next = (n4);
		n4.Next = (n1);
		return n1;
	}

	public LinkedListNode GetTestData2()
	{
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(1);
		LinkedListNode n3 = new LinkedListNode(2);
		LinkedListNode n4 = new LinkedListNode(2);
		n1.Next = (n2);
		n2.Next = (n3);
		n3.Next = (n4);
		n4.Next = (n1);
		return n1;
	}

	public void Print(LinkedListNode node)
	{
		LinkedListNode cur = node;
		do
		{
			System.out.print(cur.Data + " ");
			cur = cur.Next;
		} while (cur != node);
		System.out.println();
	}

}
