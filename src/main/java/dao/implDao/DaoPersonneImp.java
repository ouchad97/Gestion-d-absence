package dao.implDao;

import java.sql.SQLException;
import java.util.List;

import connection.DbConnect;
import dao.DaoPersonne;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Apprenant;
import model.Personne;

public class DaoPersonneImp implements DaoPersonne {
	Statement statement = null;

	public List<Personne> getAll() throws ClassNotFoundException, SQLException {

		List<Personne> personnes = new ArrayList<Personne>();

		statement = DbConnect.getConnect().createStatement();

		// - selectionner la table personnes
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

	// - selectionner personne par id
	@Override
	public Personne getById(int id) throws ClassNotFoundException, SQLException {
		Personne personne = null;

		String requete = "Select * From Personne Where idPersonne= ?";
		PreparedStatement statement = DbConnect.getConnect().prepareStatement(requete);

		statement.setLong(1, id);
		ResultSet resultat = statement.executeQuery();

		if (resultat.next()) {
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			String surnom = resultat.getString("surnom");
			String email = resultat.getString("email");
			String motDePasse = resultat.getString("motDePasse");
			String role = resultat.getString("role");

			personne = new Personne(id, nom, prenom, surnom, email, motDePasse, role);
		}

		return personne;
	}

	// - ajout personne
	@Override
	public Personne sauvePersonne(int idPersonne, String nom, String prenom, String surnom, String email,
			String motDePasse, String role) throws ClassNotFoundException, SQLException {
		Personne reponse = null;
		// int id = -1;

		String requete = "Insert into Personne (idPersonne, nom, prenom, surnom, email, motDePasse,role) Values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = DbConnect.getConnect().prepareStatement(requete,
				Statement.RETURN_GENERATED_KEYS);

		statement.setInt(1, idPersonne);
		statement.setString(2, nom);
		statement.setString(3, prenom);
		statement.setString(4, surnom);
		statement.setString(5, email);
		statement.setString(6, motDePasse);
		statement.setString(7, role);
		statement.executeUpdate();

		ResultSet rs = statement.getGeneratedKeys();

		if (rs.next()) {
			idPersonne = rs.getInt(1);
		}
		reponse = new Personne(idPersonne, nom, prenom, surnom, email, motDePasse, role);

		return reponse;
	}

	// - modification
	@Override
	public int updatePersonne(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) throws ClassNotFoundException, SQLException {
		String requete = "Update Personne set nom = ?, prenom = ?,surnom = ?, email = ?, motDePasse = ?, role = ?  Where idPersonne = ?";
		PreparedStatement statement = DbConnect.getConnect().prepareStatement(requete,
				Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, nom);
		statement.setString(2, prenom);
		statement.setString(3, surnom);
		statement.setString(4, email);
		statement.setString(5, motDePasse);
		statement.setString(6, role);
		statement.setInt(7, idPersonne);

		return statement.executeUpdate();
	}

	// suppression
	@Override
	public int deleteById(int idPersonne) throws ClassNotFoundException, SQLException {
		String requete = "Delete from Personne Where idPersonne = ?";
		PreparedStatement statement = DbConnect.getConnect().prepareStatement(requete,
				Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, idPersonne);
		return statement.executeUpdate();
	}



}