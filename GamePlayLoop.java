package codingFinalAlt;

import java.util.Random;

import javax.swing.JOptionPane;

import creatingPeople.Dealer;
import creatingPeople.Players;

public class GamePlayLoop {
	final String[] responses = {"1", "11"};
	final int bustNumber = 21;
	final int randomMax = 11;
	final int randomMin = 1;
	
	//Takes the current turn of the Player
	public void currentTurn(Players object, Dealer object1, String Action) {
		
		//Switch to check the Players Action
		switch(Action) {
		case "hitme":
			int newNumber = takeCard();
			String card = getCard(newNumber);
			if(newNumber == 1) {
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
			System.out.println(object.getCards());
			if(object.getCards() > bustNumber) {
				System.out.println("You lose!");
			}if(object.getCards() == bustNumber) {
				System.out.println("You win!");
			}
			break;
		case "stand":
			if(object1.getCards() > object.getCards()) {
				System.out.println("Sorry, I win this one.");
			}else {
				System.out.println("You Win!");
			}
			break;
		}
		
	}
	
	
	
	
	// card handling
	
	//get the Number of the card
	public int takeCard() {
		Random rng = new Random();
		int newCard = rng.nextInt(randomMin, randomMax);
		return newCard;
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
