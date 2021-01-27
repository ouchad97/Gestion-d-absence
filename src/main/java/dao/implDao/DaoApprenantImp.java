package dao.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DbConnect;
import dao.DaoApprenant;
import model.Apprenant;

public class DaoApprenantImp implements DaoApprenant {
	
	//selection
	@Override
	public Apprenant getApprenantById(int idPersonne) throws ClassNotFoundException, SQLException {
	
		Apprenant apprenant = null;

		String requete = "Select * From Apprenant Where idPersonne= ?";
		PreparedStatement statement = DbConnect.getConnect().prepareStatement(requete);

		statement.setLong(1, idPersonne);
		ResultSet resultat = statement.executeQuery();

		if (resultat.next()) {
			int idSalle = resultat.getInt("idSalle");
			int idPromotion = resultat.getInt("idPromotion");
			String referentiel = resultat.getString("referentiel");

			apprenant = new Apprenant(idPersonne, idSalle, idPromotion, referentiel);

		}
		return apprenant;
	}
	

	//Ajout
	@Override
	public Apprenant AddApprenant(int idPersonne, String nom, String prenom, String surnom, String email,
			String motDePasse, String role, int idSalle, int idPromotion, String referentiel)
			throws ClassNotFoundException, SQLException {

		Apprenant reponse = null;

		Statement statement = null;
		String r1 = "INSERT INTO Personne (idPersonne, nom, prenom, surnom, email, motDePasse, role) Values" + "("
				+ idPersonne + ", '" + nom + "', '" + prenom + "', '" + surnom + "', '" + email + "', '" + motDePasse
				+ "', '" + role + "')";
		String r2 = "INSERT INTO Apprenant (idPersonne, idSalle, idPromotion, referentiel) VALUES" + "(" + idPersonne
				+ ", " + idSalle + ", " + idPromotion + ", '" + referentiel + "')";

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
	
	//modification
		@Override
		public int updateApprenant(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
				String role, int idSalle, int idPromotion, String referentiel) throws ClassNotFoundException, SQLException {
			//String requete = "Update Apprenant set nom = ?, prenom = ?,surnom = ?, email = ?, motDePasse = ?, role = ?  Where idPersonne = ?";
			String query="update Apprenant,Personne set Personne.nom ='"+nom+"', Personne.prenom ='"+prenom+"', Personne.surnom ='"+surnom+"', Personne.email ='"+email+"', Personne.motDePasse ='"+motDePasse+"', Apprenant.idSalle = "+idSalle+", Apprenant.idPromotion ="+idPromotion+", Apprenant.referentiel ='"+referentiel+"' where Personne.idPersonne=Apprenant.idPersonne and Apprenant.idPersonne="+idPersonne+"";
			PreparedStatement statement = DbConnect.getConnect().prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);

			return statement.executeUpdate();
		}
		
	// suppression
		@Override
		public int deleteById(int idPersonne) throws ClassNotFoundException, SQLException {
			String r1 = "Delete from Apprenant Where idPersonne = "+idPersonne+"";
			String r2 = "Delete from Personne Where idPersonne = "+idPersonne+"";
			//String req = r1 + r2;

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
