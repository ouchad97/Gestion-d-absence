package dao.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DbConnect;
import dao.DaoFormateur;
import model.Formateur;

public class DaoFormateurImp implements DaoFormateur {

	// selection
	@Override
	public Formateur getFormateurById(int idPersonne) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Formateur formateur = null;

		String requete = "Select * From Formateur Where idPersonne= ?";
		PreparedStatement statement = DbConnect.getConnect().prepareStatement(requete);

		statement.setLong(1, idPersonne);
		ResultSet resultat = statement.executeQuery();

		if (resultat.next()) {
			int idSalle = resultat.getInt("idSalle");
			int idPromotion = resultat.getInt("idPromotion");

			formateur = new Formateur(idPersonne, idSalle, idPromotion);

		}
		return formateur;
	}

	// Ajout
	@Override
	public Formateur AddFormateur(int idPersonne, String nom, String prenom, String surnom, String email,
			String motDePasse, String role, int idSalle, int idPromotion) throws ClassNotFoundException, SQLException {

		Formateur reponse = null;

		Statement statement = null;
		String r1 = "INSERT INTO Personne (idPersonne, nom, prenom, surnom, email, motDePasse, role) Values" + "("
				+ idPersonne + ", '" + nom + "', '" + prenom + "', '" + surnom + "', '" + email + "', '" + motDePasse
				+ "', '" + role + "')";
		String r2 = "INSERT INTO Formateur (idPersonne, idSalle, idPromotion) VALUES" + "(" + idPersonne + ", "
				+ idSalle + ", " + idPromotion + ")";

		try {
			statement = DbConnect.getConnect().createStatement();
			statement.addBatch(r1);
			statement.addBatch(r2);
			statement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reponse;
	}

	// modification
	@Override
	public int updateFormateur(int idPersonne, String nom, String prenom, String surnom, String email,
			String motDePasse, String role, int idSalle, int idPromotion) throws ClassNotFoundException, SQLException {
		String query = "update Formateur,Personne set Personne.nom ='" + nom + "', Personne.prenom ='" + prenom
				+ "', Personne.surnom ='" + surnom + "', Personne.email ='" + email + "', Personne.motDePasse ='"
				+ motDePasse + "', Formateur.idSalle = " + idSalle + ", Formateur.idPromotion =" + idPromotion
				+ " where Personne.idPersonne=Formateur.idPersonne and Formateur.idPersonne=" + idPersonne + "";
		PreparedStatement statement = DbConnect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		return statement.executeUpdate();
	}

	// suppression
	@Override
	public int deleteById(int idPersonne) throws ClassNotFoundException, SQLException {
		String r1 = "Delete from Formateur Where idPersonne = " + idPersonne + "";
		String r2 = "Delete from Formateur Where idPersonne = " + idPersonne + "";
		// String req = r1 + r2;

		Statement statement = null;

		try {
			statement = DbConnect.getConnect().createStatement();
			statement.addBatch(r1);
			statement.addBatch(r2);
			statement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idPersonne;
	}

}
