package entities;

public class Employee extends Person{
	private String email;
	private String position;
	private String location;
	
	//default constructor
	public Employee() {
		email="";
		position = "";
		location = "";
	}
	
	//constructor
	public Employee(String email,String position,String location) {
		this.email = email;
		this.position = position;
		this.location = location;
	}
	
	

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
