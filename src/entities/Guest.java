package entities;

/**
 * The Guest program implements a guest entity.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/

public class Guest extends Person{
	private String email;
	
	/**
	 * This is the default constructor which creates a guest with default attributes.
	 * @param Nothing.
	 * @return Nothing.
	 **/
	public Guest() {
		email="";
	}
	
	/**
	 * This is the constructor which creates a guest.
	 * @param email The email of the new guest.
	 * @return Nothing.
	 **/
	public Guest(String email) {
		this.email = email;
	}
	
	@Override
	/**
	 * This function returns the email of guest.
	 * @param Nothing.
	 * @return String Ruturns the email of guest.
	 **/
	public String getEmail() {
		return email;
	}

	@Override
	/**
	 * This function sets the email of guest.
	 * @param email The email of a guest.
	 * @return Nothing.
	 **/
	public void setEmail(String email) {
		this.email = email;
	}
	
}
