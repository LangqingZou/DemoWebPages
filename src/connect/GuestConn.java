package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestConn extends PersonConn{
	private String sql;
	private Connection db;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public GuestConn(DBConnect dbConnect) {
		super(dbConnect);
		db = dbConnect.getConnection();
	}
	
	//insert a new guest, return true if successfully, false otherwise
	public boolean insertGuest(String email) {
		try {
			sql = "insert into guest(email) values (?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			int i =preparedStatement.executeUpdate();
			if(i>0) {
//				guest.setPid(resultSet.getInt(1));
//				guest.setGid(resultSet.getInt(2));
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new guest.");
			e.printStackTrace();
		}
		return false;
	}

	//return false if email already exist, return true otherwise.
	
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
