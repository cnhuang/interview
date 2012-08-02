package oo.cardgame;

import java.util.*;
import oo.cardgame.Card.Suit;

public class Deck
{
	static Random rand = new Random(System.currentTimeMillis());

	List<Card> cards;

	public Deck()
	{
		cards = new ArrayList<Card>();
		Reload(false);
	}

	public void Reload(boolean shuffle)
	{
		for (Suit s : Suit.values())
			for (int i = 1; i <= 13; i++)
			{
				cards.add(new Card(i, s));
			}
		
		if(shuffle)
			Shuffle();
	}

	public void Shuffle()
	{
		for (int i = 0; i < cards.size(); i++)
		{
			int index = rand.nextInt(cards.size() - i);
			cards.add(cards.remove(index));
		}
	}

	public Card Deliver()
	{		
		if (cards.size() > 0)
			return cards.remove(0);
		return null;
	}
	
	public List<Card> Deliver(int n)
	{
		List<Card> c = new ArrayList<Card>();
		
		if (cards.size() > 0)
			for(int i = 0 ; i < n && cards.size() > 0; i++)
			c.add(cards.remove(0));
		
		return c;
	}
}
