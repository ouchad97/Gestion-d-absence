package connection;

<<<<<<< HEAD
import java.sql.*;

//public class DbConnect {
//    // Db Info
//    String DRIVER = "com.mysql.cj.jdbc.Driver";
//    String url = "jdbc:mysql://localhost:3306/gestion_absence";
//    String user = "root";
//    String password = "";
//    Connection connection = null;
//
//    // Connection to db
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName(DRIVER);
//        connection = DriverManager.getConnection(url, user, password);
//
//        return connection;
//    }
//}

import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnect {
    public Connection dbLink;

    public Connection getConnect() {
        String dbUser = "root";
        String dbPass = "";
        String url = "jdbc:mysql://localhost:3306/gestionabsence?autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return dbLink;
    }
}

=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	static Connection dbLink = null;

	// Connexion
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		 String url = "jdbc:mysql://localhost:8000/GestionAbsence";
		 String dbUser = "root";
		 String dbPass = "admin";
		 
		 try {
			 dbLink = DriverManager.getConnection(url, dbUser, dbPass);
		 }catch (Exception e) {
	            e.printStackTrace();
	            e.getCause();
	        }
		return dbLink;
	}
	
	


}
>>>>>>> 8bea92ca8291cbb7a1fa9db61b3c6523635e55c8
