//Function: connect the database
package connect;
import java.sql.*;

public class DBConnect {
	private Connection db = null;
	private PreparedStatement preparedstatement = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public DBConnect() {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://localhost:3306/DEMO";
	    final String USER = "root";
	    final String PASS = "070251Zlq";
	    
		try {
			Class.forName(JDBC_DRIVER); // loan the driver
			db = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e) {
			System.out.println("Server connection error.");
			e.printStackTrace();
			closeDB();
		}
	}
	
	public Connection getConnection() {return db;}
	
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
