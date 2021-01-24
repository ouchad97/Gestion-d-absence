package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

	static String url = "jdbc:mysql://localhost:8000/GestionAbsence";
	static String utilisateur = "root";
	static String password = "admin";
	static Connection connection = null;

	// Connexion
	public static Connection getMyConnexion() throws ClassNotFoundException, SQLException {
		
		connection = DriverManager.getConnection(url, utilisateur, password);
		return connection;
	}

}