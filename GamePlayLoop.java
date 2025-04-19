package codingFinalAlt;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

import Awards.winningScore;
import cards.DeckSetup;
import creatingPeople.Dealer;
import creatingPeople.Players;

public class GamePlayLoop {
	//initializing variables
	public boolean busted = false;
	final String[] responses = {"1", "11"};
	final int bustNumber = 21;
	final int randomMax = 11;
	final int randomMin = 1;
	winningScore winning = new winningScore();
	DeckSetup setup = new DeckSetup();
	Stack<Integer> Deck =  setup.Shuffle();
	
	//Takes the current turn of the Player
	public int currentTurn(Players object, Dealer object1, GamePanel object3, MenuPanel object4, String Action) {
		//reset busted
		busted = false;
		//Switch to check the Players Action
		switch(Action) {
		case "hitme":
			int newNumber = takeCard(Deck);
			int dealerNumber = takeCard(Deck);
			String card = getCard(newNumber);
			String dealerCard = getCard(dealerNumber);
			object1.setCards(object1.getCards() + dealerNumber);
			if(newNumber == 1) {
				//JOptionPane used
				int option = JOptionPane.showOptionDialog(null, "You got an " + card + "! do you want 1 or 11?", "Aces!",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, null);
				if(option == 0) {
					object.setCards(object.getCards() + newNumber);
				}else {
					newNumber = 11;
					object.setCards(object.getCards() + newNumber);
				}
			}else {
				object.setCards(object.getCards() + newNumber);
			}
			
			if(object4.currentText.equals(" ")) {
				object4.currentText = dealerCard + "\n" + "current cards number: " + object1.getCards();	
				object4.text.setText(object4.currentText);
			}else {
				object4.currentText = object4.currentText + "\n" + dealerCard+ "\n" + "current cards number: " + object1.getCards();
				object4.text.setText(object4.currentText);
			}
			if(object3.currentText.equals(" ")) {
				object3.currentText = card + "\n" + "current cards number: " + object.getCards();
				object3.text.setText(object3.currentText);
			}else {
				object3.currentText = object3.currentText + "\n" + card+ "\n" + "current cards number: " + object.getCards();
				object3.text.setText(object3.currentText);
			}
			
			
			//checking at the end of the game
			if(object.getCards() > bustNumber) {
				busted = true;
				object4.text.setText("You buseted sorry.");
				return 1;
			}if(object.getCards() == bustNumber) {
				object4.text.setText("You Win!");
				return 2;
			}
			break;
		case "stand":
			if(object1.getCards() > object.getCards()) {
				object4.text.setText("Sorry, I win this one.");
				busted = true;
				return 1;
			}else {
				object4.text.setText("You Win!");
				int Scorechange = winning.Wonround(busted);
				int ScoreNew = object.getScore() + Scorechange;
				object.setScore(ScoreNew);
				return 2;
			}
		}
		object3.score.setText(object.scoreToString());
		return 0;
	}
	
	
	
	
	// card handling
	
	//get the Number of the card
	public int takeCard(Stack<Integer> S) {
		try {
			int poppedNumber = S.pop();
			return poppedNumber;
		}catch(EmptyStackException e) {
			Shuffle();
			int poppedNumber = Deck.pop();
			return poppedNumber;
		}
	}
	
	public void Shuffle(){
		this.Deck = setup.Shuffle();
	}
	
	//Get the name of the card
	public String getCard(int number) {
		Random suit = new Random();
		int suitCard = suit.nextInt(1,5);
		String suitGot = getSuit();
		if(number == 1) {
			return "Ace of " + suitGot;
		}else if(number == 2){
			return "2 of " + suitGot;
		}else if(number == 3){
			return "3 of " + suitGot;
		}else if(number == 4){
			return "3 of " + suitGot;
		}else if(number == 5){
			return "5 of " + suitGot;
		}else if(number == 6){
			return "6 of " + suitGot;
		}else if(number == 7){
			return "7 of " + suitGot;
		}else if(number == 8){
			return "8 of " + suitGot;
		}else if(number == 9){
			return "9 of " + suitGot;
		}else{
			if(suitCard == 1) {
				return "10 of " + suitGot;
			}else if(suitCard == 2) {
				return "Jack of" + suitGot;
			}else if (suitCard == 3) {
				return "Queen of " + suitGot;
			}else {
				return "King of " + suitGot;
			}
		}
	}
	
	//Gets the suit of the card
	public String getSuit() {
		Random rng = new Random();
		int number = rng.nextInt(1,5);
		if(number == 1) {
			return "hearts";
		}else if(number == 2) {
			return "clubs";
		}else if(number == 3) {
			return "spades";
		}else if(number == 4) {
			return "diamonds";
		}else {
			return "didn't work";
		}
		
	}

}
