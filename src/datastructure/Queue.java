package datastructure;

public class Queue
{
	int[] Data;
	int head = -1;
	int tail = -1;

	public Queue(int size)
	{
		Data = new int[size];
	}
	
	public int Size()
	{
		if(head == -1)
			return 0;
		else
		{
			if(tail < head)
				return Data.length-(head-tail-1);
			else
			return (tail-head+1);
		}
	}

	public void Add(int data) throws Exception
	{
		if(head == -1)
		{			
			head = 0;
			tail = 0;
			Data[head] = data;
			return;
		}
		
		if (((tail + 1) % Data.length ) != head)
		{			
			tail++;
			tail %= Data.length;
			Data[tail] = data;
		}
		else
			throw new Exception("Overflow");
	}

	public int Remove() throws Exception
	{
		if (head != -1)
		{
			int data = Data[head];
			Data[head] = -1;
			
			if(tail == head)
			{
				tail = -1;
				head = -1;
			}
			else
			{
				head++;
				head %= Data.length;
			}
			
			return data;
		}
		else 
			throw new Exception("No Data Available");
	}
	
	public String toString()
	{		
		StringBuffer sb = new StringBuffer();
		sb.append("Size:").append(Size()).append(", Data:");
		for(int i : Data)
			sb.append(i).append(",");
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("Reliability");
		Queue q = new Queue(10);
		
		for(int i = 0 ; i < 100 ; i++)
		{
			if(i%10 == 0)
				System.out.println(q);
			
			if( (i/10) % 2 == 0)
				q.Add(i);
			else
				q.Remove();
		}
		System.out.println(q);
		
		for(int i = 0 ; i < 10 ; i++)
			q.Add(i);
		for(int i = 0 ; i < 5 ; i++)
			q.Remove();
		for(int i = 0 ; i < 3 ; i++)
			q.Add(i);
		System.out.println(q);
	}
}
