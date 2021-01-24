package dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.database;
import model.Personne;

public class DaoPersonneImp implements DaoPersonne {
	 Statement statement = null;

	public  List<Personne> getAll() throws ClassNotFoundException, SQLException {

		List<Personne> personnes = new ArrayList<Personne>();

		statement = database.getMyConnexion().createStatement();

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

	@Override
	public Personne getById(int id) throws ClassNotFoundException, SQLException {
		Personne personne = null;

		String requete = "Select * From Personne Where idPersonne= ?";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete);

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

	@Override
	public Personne sauvePersonne(String nom, String prenom, String surnom, String email, String motDePasse,
			String role) throws ClassNotFoundException, SQLException {
		Personne reponse = null;
		int id = -1;

		String requete = "Insert into Personne (nom, prenom, surnom, email, motDePasse,role) Values (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete,
				Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, nom);
		statement.setString(2, prenom);
		statement.setString(3, surnom);
		statement.setString(4, email);
		statement.setString(5, motDePasse);
		statement.setString(6, role);
		statement.executeUpdate();

		ResultSet rs = statement.getGeneratedKeys();

		if (rs.next()) {
			id = rs.getInt(1);
		}
		reponse = new Personne(id, nom, prenom, surnom, email, motDePasse, role);

		return reponse;
	}

	@Override
	public int updatePersonne(int id, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) throws ClassNotFoundException, SQLException {
		String requete = "Update Personne set nom = ?, prenom = ?,surnom = ?, email = ?, motDePasse = ?, role = ?  Where idPersonne = ?";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete,
				Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, nom);
		statement.setString(2, prenom);
		statement.setString(3, surnom);
		statement.setString(4, email);
		statement.setString(5, motDePasse);
		statement.setString(6, role);
		// statement.setLong(3, id);

		return statement.executeUpdate();
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
