package creatingPeople;

public class Names {
	
	public String firstName;
	public String lastName;
	
	//names Constructor
	public Names(String firstname, String lastname) {
		this.firstName = firstname;
		this.lastName = lastname;
			
	}
		
	//Names setters
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
		
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	
	//Names getters
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

}
