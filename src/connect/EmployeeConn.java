package connect;
import java.sql.*;

/**
 * The EmployeeConn program implements an employee connection, includes inserting an employees
 * and checking email of an employee.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/

public class EmployeeConn extends PersonConn{
	private String sql;
	private Connection db;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	/**
	 * This is the constructor which creates an employee connection.
	 * @param DBConnect
	 * @return Nothing.
	 **/
	public EmployeeConn(DBConnect dbconnect) {
		super(dbconnect); //call the constructor in PersonConn
		db = dbconnect.getConnection();
	}
	

	/**
	 * This function inserts a new employee to employee table in database.
	 * It returns true if inserting successfully and false otherwise.
	 * @param email The email of the new employee
	 * @param position The position of the new employee
	 * @param locaiton The location of the new employee
	 * @return Boolean 
	 * @exception Exception e on inserting a new employee to employee table in database error.
	 **/
	public boolean insertEmployee(String email,String position,String location) {
		try {
			sql =  "insert into employee(email,position,location) values (?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, position);
			preparedStatement.setString(3, location);
			int i =preparedStatement.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) { 
			System.out.println("Error while inserting new employee.");
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * This function check whether the email already exist on employee table or not.
	 * It returns false if the email already exist on employee table, true otherwise.
	 * @param email The email of the employee
	 * @return Boolean 
	 * @exception Exception e on checking employee email error.
	 **/
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



















