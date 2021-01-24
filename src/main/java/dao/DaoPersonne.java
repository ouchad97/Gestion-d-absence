package dao;

import java.sql.SQLException;
import java.util.List;
import model.Personne;

public interface DaoPersonne {

	public List<Personne> getAll() throws ClassNotFoundException, SQLException;

	public Personne getById(int idPersonne) throws ClassNotFoundException, SQLException;
	
	Personne sauvePersonne(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) throws ClassNotFoundException, SQLException;

	public int updatePersonne(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) throws ClassNotFoundException, SQLException;

	public int deleteById(int idPersonne) throws ClassNotFoundException, SQLException;

}
