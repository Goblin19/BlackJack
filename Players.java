package creatingPeople;


//Players Class extends the Names Class
public class Players extends Names {
	
	public String firstname;
	public String lastname;
	public int money = 0;
	public int currentCards = 0;
	
	//Players Overloaded Constructor
	public Players(String firstname, String lastname) {
		super(firstname, lastname);
		
	}
	
	//Setting the money for the people
	public void setMoney(int money) {
		this.money = money;
	}
	
	//Getting the money for the people
	public int getMoney() {
		return this.money;
	}
	
	//card Number setter
	public void setCards(int cardNumber) {
		this.currentCards =  cardNumber;
	}
	
	//card Number Getter
	public int getCards() {
		return this.currentCards;
	}
	
}
