package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.Person;

public class PersonConn {
	private String sql;
	private Connection db;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	//constructor
	public PersonConn(DBConnect dbconnect) {
		db = dbconnect.getConnection();
	}
	
	public boolean insertPerson(Person p) {
		try {
			sql =  "insert into person (firstname,lastname,phone,address,email,password) values (?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, p.getFirstName());
			//System.out.println(person.getFirstName());
			preparedStatement.setString(2, p.getLastName());
			preparedStatement.setString(3, p.getPhone());
			preparedStatement.setString(4, p.getAddress());
			preparedStatement.setString(5, p.getEmail());
			preparedStatement.setString(6, p.getPassword());
			//System.out.println(preparedStatement.toString());
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) { 
			System.out.println("Error while inserting new person.");
			e.printStackTrace();
		}
		return false;
	}
	
	//return false if email already exist, return true otherwise.
//	public boolean checkEmail(String email) {
//		try {
//			sql = "select * from person where email = ?";
//			preparedStatement = db.prepareStatement(sql);
//			preparedStatement.setString(1, email);
//			resultSet = preparedStatement.executeQuery();
//	    	if(resultSet.next()) {
//	    		return false;
//	    	}
//		} catch (SQLException e) {
//			System.out.println("Error while checking person email.");
//			e.printStackTrace();
//		}
//		return true;
//	}
//	
	
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
			System.out.println("Error while getting pid.");
		}
		return "-1";
	}

}
