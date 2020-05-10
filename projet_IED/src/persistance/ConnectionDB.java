package persistance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	private static String host = "localhost";
	private static String base = "projet_ied";
	private static String user = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://" + host +":3306" + "/" + base;
	/**
	 * Lazy singleton instance.
	 */
	private static Connection connection;
	public ConnectionDB con = new ConnectionDB();
	
	public static void main(String[] args) throws Exception, IOException {
		getConnection();
		
	}
 
	//Local Connection
	public static Connection getConnection() {
		if (connection == null) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
		return connection;
	}
}
