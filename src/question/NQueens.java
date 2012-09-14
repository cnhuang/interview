package question;

import org.junit.Test;
import java.util.*;

public class NQueens
{
	/*
	 * http://www.careercup.com/question?id=13014684
	 * 
	 * Write an Algorithm and then code for N Queens problem. If there is no
	 * solution print "No Solution" or else print the board giving out positions
	 * of Queens on the board
	 */
	
	
	@Test
	public void Find()
	{
		int n = 8;
		boolean b = Find(n,0,new int[n], new boolean[n]);
		
		if(!b)
			System.out.println("No Solution");
		
	}
	
	public boolean Find(int n, int index, int[] columns, boolean rows[])
	{
		if(index == n)
		{
			if(CheckResult(columns))
			{	
				PrintResult(columns);
				return true;
			}
			return false;
		}		
		else
		{
			boolean result = false;
			for(int i = 0 ; i < n ; i++ )
			{
				if(!rows[i])
				{
					rows[i] = true;
					columns[index] = i;
					result |= Find(n,index+1,columns,rows);
					rows[i] = false;
				}
			}
			
			return result;
		}
	}
	
	public boolean CheckResult(int[] columns)
	{
		for(int i = 0 ; i < columns.length ; i++)
		{
			for(int j = i+1 ; j < columns.length ; j++)
			{
				if(Math.abs(i-j) == Math.abs(columns[i]-columns[j]))
					return false;
			}
		}
		return true;
	}
	
	public void PrintResult(int[] columns)
	{
		System.out.println("===============   Solution ==================");
		System.out.println(Arrays.toString(columns));
		char[][] board = new char[columns.length][columns.length];
		
		for(int i = 0 ; i < columns.length ; i++)
		{
			board[columns[i]][i] = 'Q';
		}
		
		for(int i = 0 ; i < columns.length ; i++)
		{
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
