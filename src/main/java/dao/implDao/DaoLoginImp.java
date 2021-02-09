package dao.implDao;

import java.sql.SQLException;
import java.util.List;

import connection.DbConnect;
import dao.DaoLogin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

import model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class DaoLoginImp  implements DaoLogin{
	Statement statement = null;
	public static int id_Session = 0;

	

	public static  Personne login(String email, String motDePasse) throws ClassNotFoundException, SQLException {
		Personne user = null;
		try {
			String query = "SELECT * FROM Personne WHERE email=? and motDePasse=?";
			Connection con = DbConnect.getConnect();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, motDePasse);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(7).equals("Administrateur")) {
					user = new Administrateur(rs.getString(2), rs.getString(3), rs.getString(4), email, motDePasse,
							rs.getString(7));
					id_Session = (rs.getInt(1));
				} else {
					if (rs.getString(7).equals("Formateur")) {
						user = new Formateur(rs.getString(2), rs.getString(3), rs.getString(4), email, motDePasse,
								rs.getString(7));
						id_Session = (rs.getInt(1));
					}
					if (rs.getString(7).equals("Apprenant")) {
						user = new Apprenant(rs.getString(2), rs.getString(3), rs.getString(4), email, motDePasse,
								rs.getString(7));
						id_Session = (rs.getInt(1));
					}
					if (rs.getString(7).equals("Secretaire")) {
						user = new Secretary(rs.getString(2), rs.getString(3), rs.getString(4), email, motDePasse,
								rs.getString(7), null);
						id_Session = (rs.getInt(1));
					}

				}
				user.setIdPersonne(rs.getInt(1));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	// void infoBox
	public static void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}

	// void showAlert
	public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}
