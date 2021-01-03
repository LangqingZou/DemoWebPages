package connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The GuestConn program implements a guest connection, includes inserting a guest
 * and checking email of a guest.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/

public class GuestConn extends PersonConn{
	private String sql;
	private Connection db;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	/**
	 * This is the constructor which creates a guest connection.
	 * @param DBConnect
	 * @return Nothing.
	 **/
	public GuestConn(DBConnect dbConnect) {
		super(dbConnect);
		db = dbConnect.getConnection();
	}
	
	/**
	 * This function inserts a new guest to guest table in database.
	 * It returns true if inserting successfully and false otherwise.
	 * @param email The email of the new guest
	 * @return Boolean 
	 * @exception Exception e on inserting a new guest to guest table in database error.
	 **/
	public boolean insertGuest(String email) {
		try {
			sql = "insert into guest(email) values (?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			int i =preparedStatement.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new guest.");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This function check whether the email already exist on guest table or not.
	 * It returns false if the email already exist on guest table, true otherwise.
	 * @param email The email of the guest
	 * @return Boolean 
	 * @exception Exception e on checking guest email error.
	 **/
	public boolean checkEmail(String email) {
		try {
			sql = "select * from guest where email = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
	    	if(resultSet.next()) {
	    		return false;
	    	}
		} catch (SQLException e) {
			System.out.println("Error while checking guest email.");
			e.printStackTrace();
		}
		return true;
	}

}
