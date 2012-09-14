package concurrent;

public class MultiThread
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int reader = 10;
		int writter = 10;
		Queue q = new Queue(20);
		
		for(int i = 0 ; i < reader ; i++)
		{
			Thread t = new Thread(new Reader(q,i));
			t.start();
		}
		
		for(int i = 0 ; i < writter ; i++)
		{
			Thread t = new Thread(new Writter(q,i));
			t.start();
		}

	}
	
	

}

class Queue
{
	int[] data;
	int index = 0;
	
	public Queue(int size)
	{
		data = new int[size];
	}
	
	synchronized int Read()
	{
		while(index == 0)
		{
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		int d = data[index--];
		this.notifyAll();
		return d;
	}
	
	synchronized void Write(int i)
	{
		while(index == data.length)
		{
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		data[index++] = i;
		this.notifyAll();
	}
}


class Reader implements Runnable
{
	
	Queue _queue;
	int _id;
	
	public Reader(Queue queue, int id)
	{
		_queue = queue;
		_id = id;
	}
	
	protected void Read()
	{
		System.out.println("Reader "+_id+" Read "+_queue.Read());
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			Read();
			try
			{
				Thread.sleep(500);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
}



class Writter implements Runnable
{
	Queue _queue;
	int _id;
	
	public Writter(Queue queue, int id)
	{
		_queue = queue;
		_id = id;
	}
	
	protected void Write()
	{
		_queue.Write(_id);
		System.out.println("Writter "+_id+" Writter "+_id);
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			Write();
			try
			{
				Thread.sleep(500);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
}