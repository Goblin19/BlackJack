package creatingPeople;

public class Dealer extends Names {
	public int dealerCards = 0;
	
	//Overloaded constructor for the dealer
	public Dealer(String firstname, String lastname) {
		super(firstname, lastname);
	}
	
	//card Number setter
		public void setCards(int cardNumber) {
			this.dealerCards = cardNumber;
		}
		
	//card Number Getter
	public int getCards() {
		return this.dealerCards;
	}
	

}
