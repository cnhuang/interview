package test.practice.google;

import java.util.*;
import java.util.concurrent.locks.*;
import org.junit.Test;

public class Multithread
{
	@Test
	public void TestSynchronizedQueue()
	{
		MyQueue queue = new SynchronizedQueue(5);
		Test(queue);
	}

	@Test
	public void TestLockQueue()
	{
		MyQueue queue = new LockQueue(5);
		Test(queue);
	}

	public void Test(MyQueue queue)
	{
		Reader[] rs = new Reader[10];
		Writer[] ws = new Writer[10];
		List<Thread> ts = new ArrayList<Thread>();
		for (int i = 0; i < rs.length; i++)
		{
			rs[i] = new Reader(i, queue);
			Thread t = new Thread(rs[i]);
			t.start();
			ts.add(t);
		}

		for (int i = 0; i < ws.length; i++)
		{
			ws[i] = new Writer(i, queue);
			Thread t = new Thread(ws[i]);
			t.start();
			ts.add(t);
		}

		for (Thread t : ts)
		{
			try
			{
				t.join();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

abstract class MyQueue
{
	protected Queue<Integer> _q;
	protected int size;

	public MyQueue(int size)
	{
		_q = new LinkedList<Integer>();
		this.size = size;
	}

	public abstract int Read();

	public abstract void Write();
}

class SynchronizedQueue extends MyQueue
{

	public SynchronizedQueue(int size)
	{
		super(size);
	}

	synchronized public int Read()
	{
		while (_q.size() == 0)
		{
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{

				e.printStackTrace();
			}
		}

		int data = _q.poll();
		this.notifyAll();
		return data;
	}

	synchronized public void Write()
	{
		while (_q.size() == size)
		{
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		_q.add(_q.size());
		this.notifyAll();
	}
}

class LockQueue extends MyQueue
{
	Lock lock = new ReentrantLock();

	public LockQueue(int size)
	{
		super(size);
	}

	public int Read()
	{
		do
		{
			boolean locked = lock.tryLock();
			if (locked)
			{
				if (_q.size() == 0)
					lock.unlock();
				else
				{
					int data = _q.poll();
					lock.unlock();
					return data;
				}
			} else
			{
				try
				{
					Thread.sleep(100);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} while (true);
	}

	public void Write()
	{
		do
		{
			boolean locked = lock.tryLock();
			if (locked)
			{
				if (_q.size() == size)
					lock.unlock();
				else
				{
					_q.add(_q.size());
					lock.unlock();
					return;
				}
			} else
			{

				try
				{
					Thread.sleep(100);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} while (true);
	}
}

class Reader implements Runnable
{
	protected MyQueue _q;
	protected int id;
	Random rand = new Random(System.currentTimeMillis());

	public Reader(int id, MyQueue queue)
	{
		this.id = id;
		_q = queue;
	}

	public void DoSomething()
	{
		System.out.println("Reader " + id + " read " + _q.Read());
	}

	@Override
	public void run()
	{

		for (int i = 0; i < 100; i++)
		{
			DoSomething();
			try
			{
				Thread.sleep(rand.nextInt(100));
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class Writer extends Reader
{

	public Writer(int id, MyQueue queue)
	{
		super(id, queue);
	}

	@Override
	public void DoSomething()
	{
		_q.Write();
		System.out.println("Writer " + id + " Write ");
	}

}
