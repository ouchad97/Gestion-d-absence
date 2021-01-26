package dao.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DbConnect;
import dao.DaoApprenant;
import model.Apprenant;

public class DaoApprenantImp implements DaoApprenant {
	
	
	@Override
	public Apprenant getApprenantById(int idPersonne) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
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
	
}
