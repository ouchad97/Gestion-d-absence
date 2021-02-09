package dao;

import java.sql.SQLException;

import model.Apprenant;

public interface DaoApprenant {
	
	//selection
	public Apprenant getApprenantById(int idPersonne) throws ClassNotFoundException, SQLException;

	//ajout
	public Apprenant AddApprenant(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role,int idSalle, int idPromotion, String referentiel)throws ClassNotFoundException, SQLException;
	
	//modification
	public int updateApprenant(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role, int idSalle, int idPromotion, String referentiel) throws ClassNotFoundException, SQLException;
	
	//suppression
	public int deleteById(int idPersonne) throws ClassNotFoundException, SQLException;


}
