package cards;

import java.util.Stack;
import java.util.Random;

public class DeckSetup {
	public Stack<Integer> Deck = new Stack<Integer>();
	private int count = 0;
	public Random card;
	
	public Stack<Integer> Shuffle(){
		count = 0;
		card = new Random();
		while(count < 53) {
			int number = card.nextInt(1,11);
			Deck.add(number);
			count++;
		}
		return Deck;
	}
}
