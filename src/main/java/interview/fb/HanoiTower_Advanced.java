package interview.fb;

import java.io.*;
import java.util.*;

public class HanoiTower_Advanced
{
	@SuppressWarnings("rawtypes")
	static List<Stack> pegs;
	static List<Disc> discs;
	
	
	public static void main(String[] args) throws Exception
	{
		ReadInput();
		for(int i = discs.size() -1 ; i >= 0 ; i++ )
		{
			Move(discs.get(i));
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void ReadInput() throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String[] l1 = br.readLine().split(" ");
		 String[] l2 = br.readLine().split(" ");
		 String[] l3 = br.readLine().split(" ");
		 
		 discs = new ArrayList<Disc>(Integer.parseInt(l1[0]));
		 pegs = new ArrayList<Stack>(Integer.parseInt(l1[1])+1);
		 for(int i = 0 ; i < pegs.size() ; i++)
		 {
			 pegs.add(i+1,new Stack());
		 }
		 
		 for(int i = 0 ; i < l2.length ; i++)
		 {
			 Disc d = (new HanoiTower_Advanced()).new Disc();
			 d.size = i+1;
			 d.now = Integer.parseInt(l2[i]);
			 d.dest = Integer.parseInt(l3[i]);
			 discs.add(i+1,d);
		 }
		 
		 for(int i = discs.size() - 1; i >= 0 ; i++)
		 {
			 pegs.get(discs.get(i).now).add(discs.get(i));
		 }
	}
	
	public static void Move(Disc d)
	{
		if(d.now == d.dest)
			return;
		
		//the disc is on the top
		if(pegs.get(d.now).peek().equals(d))
		{
			
		}
		
	}

	class Disc
	{
		int now;
		int dest;
		int size;		
	}
}
