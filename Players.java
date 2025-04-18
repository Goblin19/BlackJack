package creatingPeople;


//Players Class extends the Names Class
public class Players extends Names {
	
	public String firstname;
	public String lastname;
	public int score = 0;
	public int currentCards = 0;
	
	//Players Overloaded Constructor
	public Players(String firstname, String lastname) {
		super(firstname, lastname);
		
	}
	
	//Setting the score for the people
	public void setScore(int score) {
		this.score = score;
	}
	
	//Getting the score for the people
	public int getScore() {
		return this.score;
	}
	
	//card Number setter
	public void setCards(int cardNumber) {
		this.currentCards =  cardNumber;
	}
	
	//card Number Getter
	public int getCards() {
		return this.currentCards;
	}
	
	public String scoreToString() {
		int score = getScore();
		String currentScore = "Current Score: " + score;
		return currentScore;
	}
	
}
