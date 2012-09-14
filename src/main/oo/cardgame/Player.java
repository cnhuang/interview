package oo.cardgame;

import java.util.*;

public class Player
{
	String name;
	List<Card> cards;
	
	public Player(String name)
	{
		this.name = name;
		cards = new ArrayList<Card>();
	}
	
	public String Name()
	{
		return name;
	}
	
	
	public List<Card> Cards()
	{
		return cards;
	}
	
}
