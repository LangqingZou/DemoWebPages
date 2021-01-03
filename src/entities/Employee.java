package entities;

/**
 * The Employee program implements an employee entity.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/

public class Employee extends Person{
	private String email;
	private String position;
	private String location;
	
	/**
	 * This is the default constructor which creates an employee with default attributes.
	 * @param Nothing.
	 * @return Nothing.
	 **/
	public Employee() {
		email="";
		position = "";
		location = "";
	}
	
	/**
	 * This is the constructor which creates an employee.
	 * @param email The email of the new employee.
	 * @param position The position of the new employee.
	 * @param location The location of the new employee.
	 * @return Nothing.
	 **/
	public Employee(String email,String position,String location) {
		this.email = email;
		this.position = position;
		this.location = location;
	}
	
	@Override
	/**
	 * This function returns the email of employee.
	 * @param Nothing.
	 * @return String Ruturns the email of employee.
	 **/
	public String getEmail() {
		return email;
	}

	@Override
	/**
	 * This function sets the email of employee.
	 * @param email The email of an employee.
	 * @return Nothing.
	 **/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This function returns the position of employee.
	 * @param Nothing.
	 * @return String Ruturns the position of employee.
	 **/
	public String getPosition() {
		return position;
	}

	/**
	 * This function sets the position of employee.
	 * @param position The position of an employee.
	 * @return Nothing.
	 **/
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * This function returns the location of employee.
	 * @param Nothing.
	 * @return String Ruturns the location of employee.
	 **/
	public String getLocation() {
		return location;
	}

	/**
	 * This function sets the location of employee.
	 * @param location The location of an employee.
	 * @return Nothing.
	 **/
	public void setLocation(String location) {
		this.location = location;
	}

	
}
