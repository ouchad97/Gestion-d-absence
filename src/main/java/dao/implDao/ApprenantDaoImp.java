package dao.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ApprenantDao;
import database.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Apprenant;

public class ApprenantDaoImp implements ApprenantDao{
	private	ObservableList <Apprenant> apprenants = FXCollections.observableArrayList();
	
	@Override
	public ObservableList<Apprenant> getAllById(int id) throws ClassNotFoundException, SQLException {
		String requete = "select * from Abscence,Apprenant,Personne,association4 where Personne.idPersonne=Apprenant.idPersonne and association4.idAbscence = Abscence.idAbscence and association4.idPersonne=Apprenant.idPersonne  and Apprenant.idPersonne="+id;
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete);
		ResultSet resultat = statement.executeQuery();
		int sum=0;
		while(resultat.next()) {
			int idAbscence = resultat.getInt("idAbscence");
			String dateAbscence = resultat.getString("dateAbscence");
			boolean justif = resultat.getBoolean("justif");
			int idPersonne = resultat.getInt("idPersonne");
			int idSalle = resultat.getInt("idSalle");
			int idPromotion = resultat.getInt("idPromotion");
			String referentiel = resultat.getString("referentiel");
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			String surnom = resultat.getString("surnom");
			String email = resultat.getString("email");
			String motDePasse = resultat.getString("motDePasse");
			String role = resultat.getString("role");
			int hours = resultat.getInt("nbrHours");
			sum = sum+hours;
			apprenants.add(new Apprenant( idAbscence,  dateAbscence,  justif,  idPersonne,  idSalle,  idPromotion,
					 referentiel,  nom,  surnom,  prenom,  email,  motDePasse,
					 role, hours, sum));
			
			
		}
		return apprenants;
	}
	
	@Override
	public Apprenant getById(int id) throws ClassNotFoundException, SQLException {
		Apprenant apprenant = null;
		String requete = "select * from Abscence,Apprenant,Personne,association4 where Personne.idPersonne=Apprenant.idPersonne and association4.idAbscence = Abscence.idAbscence and association4.idPersonne=Apprenant.idPersonne  and Apprenant.idPersonne="+id;
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete);

		ResultSet resultat = statement.executeQuery();
		int sum=0;
		while(resultat.next()) {
			int idAbscence = resultat.getInt("idAbscence");
			String dateAbscence = resultat.getString("dateAbscence");
			boolean justif = resultat.getBoolean("justif");
			int idPersonne = resultat.getInt("idPersonne");
			int idSalle = resultat.getInt("idSalle");
			int idPromotion = resultat.getInt("idPromotion");
			String referentiel = resultat.getString("referentiel");
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			String surnom = resultat.getString("surnom");
			String email = resultat.getString("email");
			String motDePasse = resultat.getString("motDePasse");
			String role = resultat.getString("role");
			int hours = resultat.getInt("Hours");
			sum = sum+hours;
			apprenant = new Apprenant(idAbscence,  dateAbscence,  justif,  idPersonne,  idSalle,  idPromotion,
					 referentiel,  nom,  surnom,  prenom,  email,  motDePasse,
					 role, hours, sum);
		}

		return apprenant;
	}


}
