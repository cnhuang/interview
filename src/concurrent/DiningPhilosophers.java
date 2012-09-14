package concurrent;

import java.util.concurrent.locks.*;

public class DiningPhilosophers
{

	public static void main(String[] args)
	{
		int count = 5;
		Chopstick[] chopsticks = new Chopstick[count];
		for (int i = 0; i < count; i++)
			chopsticks[i] = new Chopstick();

		Philosopher[] profs = new Philosopher[count];
		for (int i = 0; i < count; i++)
		{
			profs[i] = new SmartPhilosopher(i, chopsticks[i], chopsticks[(i + 1) % count]);
			Thread t = new Thread(profs[i]);
			t.start();
		}
	}

}

// will cause deadlock
class Philosopher implements Runnable
{
	protected Chopstick _left;
	protected Chopstick _right;
	protected String _name;
	protected int _count = 10;

	public Philosopher(int name, Chopstick left, Chopstick right)
	{
		_left = left;
		_right = right;
		_name = "Prof. " + name;
	}

	protected boolean Eat()
	{
		System.out.println(_name + " try to pickup.");
		Pickup();
		System.out.println(_name + " eating.");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{

			e.printStackTrace();
		}
		System.out.println(_name + " putdown.");
		Putdown();
		System.out.println(_name + " leave.");
		return true;
	}

	protected void Pickup()
	{
		_left.Pickup();
		_right.Pickup();
	}

	protected void Putdown()
	{
		_left.Putdown();
		_right.Putdown();
	}

	@Override
	public void run()
	{
		for (int i = 0; i < _count; i++)
		{
			if(!Eat())
				i++;
		}

	}
}

class SmartPhilosopher extends Philosopher
{
	public SmartPhilosopher(int name, Chopstick left, Chopstick right)
	{
		super(name, left, right);
	}

	protected boolean Eat()
	{
		System.out.println(_name + " try to pickup.");
		if (tryPickup())
		{
			System.out.println(_name + " eating.");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{

				e.printStackTrace();
			}
			System.out.println(_name + " putdown.");
			Putdown();
			System.out.println(_name + " leave.");
			return true;
		}
		return false;
	}

	protected boolean tryPickup()
	{
		if (!_left.tryPickup())
			return false;
		else if (!_right.tryPickup())
		{
			_left.Putdown();
			return false;
		}

		return true;
	}
}

class Chopstick
{
	private Lock _lock;

	public Chopstick()
	{
		_lock = new ReentrantLock();
	}

	public void Pickup()
	{
		_lock.lock();
	}

	public boolean tryPickup()
	{
		return _lock.tryLock();
	}

	public void Putdown()
	{
		_lock.unlock();
	}

}
