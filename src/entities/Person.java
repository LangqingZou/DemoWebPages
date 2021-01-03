package entities;

/**
 * The Person program implements a person entity.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	private String password;
	
	/**
	 * This is the default constructor which creates a person with default attributes.
	 * @param Nothing.
	 * @return Nothing.
	 **/
	public Person() {
		firstName = "";
		lastName = "";
		address = "";
		email = "";
		phone = "";
		password = "";
	}
	
	/**
	 * This is the constructor which creates a person.
	 * @param firstName The firstName of the new guest.
	 * @param lastName The lastName of the new guest.
	 * @param phone The phone of the new guest.
	 * @param address The address of the new guest.
	 * @param email The email of the new guest.
	 * @param password The password of the new guest.
	 * @return Nothing.
	 **/
	public Person(String firstName,String lastName,String phone,String address,String email,String password ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * This function returns the email of person.
	 * @param Nothing.
	 * @return String Ruturns the email of person.
	 **/
	public String getEmail() {
		return email;
	}
	
	/**
	 * This function sets the email of person.
	 * @param email The email of a person.
	 * @return Nothing.
	 **/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This function returns the password of person.
	 * @param Nothing.
	 * @return String Ruturns the password of person.
	 **/
	public String getPassword() {
		return password;
	}

	/**
	 * This function sets the password of person.
	 * @param password The password of a person.
	 * @return Nothing.
	 **/
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This function returns the first name of person.
	 * @param Nothing.
	 * @return String Ruturns the first name of person.
	 **/
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * This function sets the first name of person.
	 * @param firstName The first name of a person.
	 * @return Nothing.
	 **/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * This function returns the last name of person.
	 * @param Nothing.
	 * @return String Ruturns the last name of person.
	 **/
	public String getLastName() {
		return lastName;
	}

	/**
	 * This function sets the last name of person.
	 * @param lastName The last name of a person.
	 * @return Nothing.
	 **/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * This function returns the address of person.
	 * @param Nothing.
	 * @return String Ruturns the address of person.
	 **/
	public String getAddress() {
		return address;
	}
	
	/**
	 * This function sets the address of person.
	 * @param address The address of a person.
	 * @return Nothing.
	 **/
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * This function returns the phone number of person.
	 * @param Nothing.
	 * @return String Ruturns the phone number of person.
	 **/
	public String getPhone() {
		return phone;
	}
	
	/**
	 * This function sets the phone number of person.
	 * @param phone The phone number of a person.
	 * @return Nothing.
	 **/
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
