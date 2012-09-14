package question.google;

import java.util.HashMap;
import java.util.Random;
import org.junit.Test;

public class Cache
{
	@Test
	public void CacheTest()
	{
		Random rand = new Random(System.currentTimeMillis());
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(5);

		for (int i = 0; i < 100; i++)
		{
			int data = rand.nextInt(10);
			int action = rand.nextInt(2);

			switch (action)
			{
			case 0:
				Integer r = cache.Get(data);
				System.out.println("Get " + data + " returns " + r);
				break;
			case 1:
				cache.Put(data, data);
				System.out.println("Put " + data);
				break;
			}

			System.out.println(cache);
		}
	}
}

class LRUCache<K, T>
{
	Node<K, T> head;
	Node<K, T> tail;
	HashMap<K, Node<K, T>> map;
	int size;
	int currentSize;

	public LRUCache(int size)
	{
		head = new Node<K, T>(null, null);
		tail = new Node<K, T>(null, null);
		head.next = tail;
		tail.prev = head;
		map = new HashMap<K, Node<K, T>>();
		this.size = size;
		currentSize = 0;
	}

	public T Get(K key)
	{
		if (map.containsKey(key))
		{
			Node<K, T> node = map.get(key);
			Detach(node);
			Attach(node);
			return node.data;

		} else
			return null;
	}

	public void Put(K key, T data)
	{
		if (map.containsKey(key))
		{
			Node<K, T> node = map.get(key);
			Detach(node);
			map.remove(key);
			currentSize--;
		}

		if (currentSize == size)
		{
			Node<K, T> node = tail.prev;
			Detach(node);
			currentSize--;
			map.remove(node.key);
		}

		Node<K, T> node = new Node<K, T>(key, data);
		map.put(key, node);
		Attach(node);
		currentSize++;
	}

	private void Detach(Node<K, T> n)
	{
		n.prev.next = n.next;
		n.next.prev = n.prev;
	}

	private void Attach(Node<K, T> n)
	{
		n.next = head.next;
		head.next.prev = n;
		head.next = n;
		n.prev = head;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Node<K, T> n = head.next;

		while (n != tail)
		{
			sb.append("(").append(n.key).append(",").append(n.data).append(")->");
			n = n.next;
		}

		sb.append("\n");

		return sb.toString();
	}

}

class Node<K, T>
{
	Node<K, T> prev;
	Node<K, T> next;
	T data;
	K key;

	public Node(K key, T data)
	{
		this.key = key;
		this.data = data;
	}
}
