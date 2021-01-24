package services;

import dao.*;
import model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicePersonne {

	///la liste des personnes.
	 
	public static List<Personne> personnes = new ArrayList<Personne>();
	public static DaoPersonne daoPersonne = new DaoPersonneImp();

	public static List<Personne> getAllPersonnes() throws ClassNotFoundException, SQLException {
		return personnes = daoPersonne.getAll();
	}

	public static Personne addPersonne(int idPersonne, String nom, String prenom, String surnom, String email,
			String motDePasse, String role) throws ClassNotFoundException, SQLException {
		return daoPersonne.sauvePersonne(idPersonne, nom, prenom, surnom, email, motDePasse, role);
	}

	// getby Id
	public Personne getByIdPersonne(int idPersonne) throws ClassNotFoundException, SQLException {
		return daoPersonne.getById(idPersonne);
	}

	// modifier personne
	public static void updatPerson(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) throws ClassNotFoundException, SQLException {
		daoPersonne.updatePersonne(idPersonne, nom, prenom, surnom, email, motDePasse, role);
	}
}
