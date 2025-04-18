package codingFinalAlt;

import java.util.Random;

import javax.swing.JOptionPane;

import creatingPeople.Dealer;
import creatingPeople.Players;

public class GamePlayLoop {
	final int bustNumber = 21;
	final int randomMax = 11;
	final int randomMin = 1;
	
	//Takes the current turn of the Player
	public void currentTurn(Players object, Dealer object1, String Action) {
		
		switch(Action) {
		case "hitme":
			int newNumber = takeCard();
			if(newNumber == 1) {
				
			}else {
				object.setCards(object.getCards() + newNumber);
			}
		}
		
		
		if(object.getCards() == bustNumber) {
			System.out.println("You Win!");
		}else if(object.getCards() > bustNumber) {
			System.out.println("Busted!");
		}else if(object1.getCards() > object.getCards()) {
			System.out.println("Sorry, I win this one.");
		}else if(object.getCards() > object1.getCards()) {
			System.out.println("You Win!");
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
		String suitGot = getSuit(suitCard);
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
	public String getSuit(int number) {
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
		
		
		/*
		 * int option = JOptionPane.showConfirmDialog(null, "You got and Ace of " + suitGot + "! do you want 1 or 11? (yes for 1, and no for 11)", "Aces!",JOptionPane.YES_NO_OPTION);
			if(option == 0) {
				
			}else {
				
			}
		 * 
		 * 
		 * 
		 * 
		 */
	}

}
