package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoApprenant;
import dao.implDao.DaoApprenantImp;
import model.Apprenant;

public class ServicesApprenant {
	
public static List<Apprenant> apprenant = new ArrayList<Apprenant>();
	
	
	public static DaoApprenant daoApprenant = new DaoApprenantImp();
	// getApprenant Id
			public static Apprenant getApprenantById(int idPersonne) throws ClassNotFoundException, SQLException {
				return daoApprenant.getApprenantById(idPersonne);
			}
			
			public static Apprenant AddApprenant(int idPersonne, String nom, String prenom, String surnom, String email,
					String motDePasse, String role, int idSalle, int idPromotion ,String referentiel) throws ClassNotFoundException, SQLException {

				return daoApprenant.AddApprenant(idPersonne, nom, prenom, surnom, email, motDePasse, role, idSalle, idPromotion, referentiel);
			}
			
			// modifier personne
			public static void updatApprenant(int idPersonne, String nom, String prenom, String surnom, String email,
					String motDePasse, String role, int idSalle, int idPromotion , String referentiel) throws ClassNotFoundException, SQLException {
				daoApprenant.updateApprenant(idPersonne, nom, prenom, surnom, email, motDePasse, role, idSalle, idPromotion, referentiel);
			}
			// suppression
			public static void deletePerson(int idPersonne) throws ClassNotFoundException, SQLException {
				daoApprenant.deleteById(idPersonne);
			}
}
