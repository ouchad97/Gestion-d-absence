package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFormateur;
import dao.implDao.DaoFormateurImp;
import model.Formateur;

public class ServicesFormateur {
	
public static List<Formateur> formateur = new ArrayList<Formateur>();
	
	
	public static DaoFormateur daoFormateur = new DaoFormateurImp();
	// getApprenant Id
			public static Formateur getFormateurById(int idPersonne) throws ClassNotFoundException, SQLException {
				return daoFormateur.getFormateurById(idPersonne);
			}
			
			public static Formateur AddFormateur(int idPersonne, String nom, String prenom, String surnom, String email,
					String motDePasse, String role, int idSalle, int idPromotion ) throws ClassNotFoundException, SQLException {

				return daoFormateur.AddFormateur(idPersonne, nom, prenom, surnom, email, motDePasse, role, idSalle, idPromotion);
			}
			
			// modifier personne
			public static void updatFormateur(int idPersonne, String nom, String prenom, String surnom, String email,
					String motDePasse, String role, int idSalle, int idPromotion ) throws ClassNotFoundException, SQLException {
				daoFormateur.updateFormateur(idPersonne, nom, prenom, surnom, email, motDePasse, role, idSalle, idPromotion);
			}
			// suppression
			public static void deletePerson(int idPersonne) throws ClassNotFoundException, SQLException {
				daoFormateur.deleteById(idPersonne);
			}
}
