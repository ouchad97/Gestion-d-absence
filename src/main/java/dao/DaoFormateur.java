package dao;

import java.sql.SQLException;

import model.Formateur;

public interface DaoFormateur {
	
	//selection
	public Formateur getFormateurById(int idPersonne) throws ClassNotFoundException, SQLException;

	//ajout
	public Formateur AddFormateur(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role,int idSalle, int idPromotion)throws ClassNotFoundException, SQLException;
	
	//modification
	public int updateFormateur(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role, int idSalle, int idPromotion) throws ClassNotFoundException, SQLException;
	
	//suppression
	public int deleteById(int idPersonne) throws ClassNotFoundException, SQLException;


}
