package entities;

public class Guest extends Person{
	private String email;
	
	//default constructor
	public Guest() {
		email="";
	}
	
	public Guest(String email) {
		this.email = email;
	}
	
	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
}
