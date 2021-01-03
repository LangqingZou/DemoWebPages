package connect;
import java.sql.*;

/**
 * The DBConnect program implements a mySql connection simply 
 * connect the database and close it.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/

public class DBConnect {
	private Connection db = null;
	private PreparedStatement preparedstatement = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	/**
	 * This is the constructor which loans the driver and connects the database.
	 * @param Nothing.
	 * @return Nothing.
	 * @exception Exception e on serve connection error.
	 **/
	public DBConnect() {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://localhost:3306/XXXX";
	    final String USER = "XXXXX";
	    final String PASS = "XXXXX";
	    
		try {
			Class.forName(JDBC_DRIVER); // loan the driver
			db = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e) {
			System.out.println("Server connection error.");
			e.printStackTrace();
			closeDB();
		}
	}
	
	/**
	 * This function returns the connection.
	 * @param Nothing.
	 * @return connection This returns the connection.
	 **/
	public Connection getConnection() {return db;}
	
	/**
	 * This function closes the connection.
	 * @param Nothing.
	 * @return Nothing.
	 * @exception SQLException e on serve closing error.
	 **/
	public void closeDB() {
		try {
			if(resultset != null) resultset.close();
			if(preparedstatement!=null) preparedstatement.close();
			if(statement!=null) statement.close();
			if(db!=null) db.close();
		} catch (SQLException e) {
			System.out.println("Server closing error.");
			e.printStackTrace();
		}
	}
}
