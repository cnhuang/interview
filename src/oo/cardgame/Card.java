package oo.cardgame;

public class Card
{
	public enum Suit
	{
		Spade (1), Club (2), Heart (3), Diamond(4);
		int value;
		private Suit(int v) {value = v;}		
	};
	
	private int number;
	private Suit suit;
	
	public Card(int number, Suit suit)
	{
		this.number = number;
		this.suit = suit;
	}
	
	public int Value()
	{
		return this.number;
	}
	
	public Suit Suit()
	{
		return suit;
	}
}
