package connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.Person;

/**
 * The PersonConn program implements a person connection, includes inserting a person
 * and checking email of a person.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/
public class PersonConn {
	private String sql;
	private Connection db;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	/**
	 * This is the constructor which creates a person connection.
	 * @param DBConnect
	 * @return Nothing.
	 **/
	public PersonConn(DBConnect dbconnect) {
		db = dbconnect.getConnection();
	}
	
	/**
	 * This function inserts a new person to person table in database.
	 * It returns true if inserting successfully and false otherwise.
	 * @param p The new person.
	 * @return Boolean 
	 * @exception Exception e on inserting a new person to person table in database error.
	 **/
	public boolean insertPerson(Person p) {
		try {
			sql =  "insert into person (firstname,lastname,phone,address,email,password) values (?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, p.getFirstName());
			preparedStatement.setString(2, p.getLastName());
			preparedStatement.setString(3, p.getPhone());
			preparedStatement.setString(4, p.getAddress());
			preparedStatement.setString(5, p.getEmail());
			preparedStatement.setString(6, p.getPassword());
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) { 
			System.out.println("Error while inserting new person.");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * This function returns the password of person.
	 * @param email The email of a person.
	 * @return String  
	 * @exception Exception e getting the password error.
	 **/
	public String getPassword(String email) {
		try {
			sql = "select password from demo.person where email = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
	    	if(resultSet.next()) {
	    		return resultSet.getString(1);
	    	}
		} catch (SQLException e) {
			System.out.println("Error while getting password.");
		}
		return "-1";
	}

}
