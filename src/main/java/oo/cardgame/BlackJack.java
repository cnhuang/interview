package oo.cardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BlackJack
{
	List<Player> players;
	Deck deck;

	public BlackJack()
	{
		players = new ArrayList<Player>();
	}

	public void Start() throws IOException
	{
		for (Player p : players)
		{
			Deliver(p, 2);
		}

		for (Player p : players)
		{
			Ask(p);			
		}
	}
	
	public void Ask(Player p) throws IOException
	{
		int point = Point(p.Cards());

		System.out.print("Player " + p.name);
		System.out.print(", Cards ");

		for (Card c : p.cards)
		{
			System.out.print("[" + c.Suit() + "," + c.Value() + "] ");
		}

		System.out.println(", Total " + point + " Points");
		
		if (point == 21)
		{
			System.out.println("You Win");
		}
		else if (point > 21)
		{
			System.out.println("You Lose");
		}
		else
		{
			System.out.println("More?");
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);
			String s =in.readLine();
			
			if(s.equalsIgnoreCase("Y"))
			{
				Deliver(p,1);
				Ask(p);
			}
		}
	}
	

	public int Point(List<Card> cards)
	{
		int p = 0;

		for (Card c : cards)
		{
			if (c.Value() >= 10)
			{
				p += 10;
			}
			else if (c.Value() == 1)
			{
				p += 11;
			}
			else
				p += c.Value();
		}

		return p;
	}

	public void Deliver(Player p, int n)
	{
		if (deck == null)
		{
			deck = new Deck();
			deck.Shuffle();
		}

		while (n != 0)
		{
			List<Card> cards = deck.Deliver(n);
			p.cards.addAll(cards);
			n -= cards.size();
			if (deck.cards.size() == 0)
				deck.Reload(true);
		}

	}

	public void AddPlayer(Player p)
	{
		players.add(p);
	}
	
	public static void main(String[] args) throws IOException
	{
		BlackJack bj = new BlackJack();
		bj.AddPlayer(new Player("abc"));
		bj.AddPlayer(new Player("bcd"));
		bj.AddPlayer(new Player("cde"));
		bj.Start();
	}
}
