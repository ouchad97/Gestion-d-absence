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

	@Override
	public List<Personne> getAll() throws ClassNotFoundException, SQLException {
		List<Personne> personnes = new ArrayList<Personne>();

		statement = DbConnect.getConnect().createStatement();
		System.out.println("cr�ation de l'objet Statement");

		// 4- selectionner la table personnes
		ResultSet resultat;
		String requete = "Select * From Personne";

		resultat = statement.executeQuery(requete);

		while (resultat.next()) {
			int id = resultat.getInt("idPersonne");
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			String surnom = resultat.getString("surnom");
			String email = resultat.getString("email");
			String motDePasse = resultat.getString("motDePasse");
			String role = resultat.getString("role");

			// Creer l'objet Personne
			Personne p = new Personne(id, nom, prenom, surnom, email, motDePasse, role);
			personnes.add(p);
		}

		return personnes;
	}

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
						user = new Secretaire(rs.getString(2), rs.getString(3), rs.getString(4), email, motDePasse,
								rs.getString(7));
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
