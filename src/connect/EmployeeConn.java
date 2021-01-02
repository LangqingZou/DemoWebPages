package connect;

import java.sql.*;

public class EmployeeConn extends PersonConn{
	private String sql;
	private Connection db;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	//constructor
	public EmployeeConn(DBConnect dbconnect) {
		super(dbconnect); //call the constructor in PersonConn
		db = dbconnect.getConnection();
	}
	
	//insert a new employee
	public boolean insertEmployee(String email,String position,String location) {
		try {
			sql =  "insert into employee(email,position,location) values (?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, position);
			preparedStatement.setString(3, location);
			int i =preparedStatement.executeUpdate();
			if(i>0) {
//				employee.setPid(resultSet.getInt(1));
//				employee.setEid(resultSet.getInt(2));
				return true;
			}
		} catch (SQLException e) { 
			System.out.println("Error while inserting new employee.");
			e.printStackTrace();
		}
		return false;
	}
	
	//return false if email already exist, return true otherwise.
	
	public boolean checkEmail(String email) {
		try {
			sql = "select * from employee where email = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
	    	if(resultSet.next()) {
	    		return false;
	    	}
		} catch (SQLException e) {
			System.out.println("Error while checking employee email.");
			e.printStackTrace();
		}
		return true;
	}

}



















