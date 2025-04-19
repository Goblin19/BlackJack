package creatingPeople;
//Extends parent Class
public class Dealer extends Names {
	public int dealerCards = 0;
	
	//Overloaded constructor for the dealer
	public Dealer(String firstname, String lastname) {
		super(firstname, lastname);
	}
	
	//Overloaded constructor
	public Dealer(String firstname) {
		super(firstname);
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
