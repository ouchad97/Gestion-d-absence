package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	static Connection dbLink = null;

	// Connexion
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		 String url = "jdbc:mysql://localhost:3306/gestion_absence";
		 String dbUser = "root";
		 String dbPass = "";
		 
		 try {
			 dbLink = DriverManager.getConnection(url, dbUser, dbPass);
		 }catch (Exception e) {
	            e.printStackTrace();
	            e.getCause();
	        }
		return dbLink;
	}
	
	


}