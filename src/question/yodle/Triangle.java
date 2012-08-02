package question.yodle;

import java.net.URL;
import java.util.*;
import java.io.*;

public class Triangle
{

	// http://www.yodle.com/downloads/puzzles/triangle.html
	public static void main(String[] args)throws Exception
	{
		System.out.println(Find(ReadInput(), 0,1, new Hashtable<Integer,Integer>()));
		
		Integer[] data = new Integer[]{5,9,6,4,6,8,0,7,1,5};
		System.out.println(Find(Arrays.asList(data), 0,1, new Hashtable<Integer,Integer>()));
	}
	
	public static int Find(List<Integer> input, int index, int level, Hashtable<Integer,Integer> cache)
	{			
		if(index >= input.size())
			return 0;

		if(cache.containsKey(index))
			return cache.get(index);
		
		int result = Math.max(Find(input,index+level,level+1,cache),Find(input,index+level+1,level+1,cache))+input.get(index);
		cache.put(index, result);
		return result;		
	}

	public static List<Integer> ReadInput() throws Exception
	{
		List<Integer> list = new ArrayList<Integer>();
		
		URL url = new URL("http://www.yodle.com/downloads/puzzles/triangle.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String str;
		while ((str = in.readLine()) != null)
		{
			String[] tmp = str.trim().split("\\s+");
			for(String s : tmp)
				if(null != s && !s.equals(""))
				list.add(Integer.parseInt(s));
		}
		in.close();
		return list;
	}
}
