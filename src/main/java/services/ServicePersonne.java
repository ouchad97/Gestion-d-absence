package services;

import dao.*;
import model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicePersonne {

	/**
	 * la liste des personnes.
	 */
	public List<Personne> personnes = new ArrayList<Personne>();
	public DaoPersonne daoPersonne = new DaoPersonneImp();

	/**
	 * Charger toutes les personnes disponibles dans la base de donnees.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Personne> getAllPersonnes() throws ClassNotFoundException, SQLException {
		return personnes = daoPersonne.getAll();
	}

	public Personne addPersonne(String nom, String prenom, String surnom, String email, String motDePasse, String role)
			throws ClassNotFoundException, SQLException {
		return daoPersonne.sauvePersonne(nom, prenom, surnom, email, motDePasse, role);
	}

	// modifier personne
	public Personne getByIdPersonne(int id) throws ClassNotFoundException, SQLException {
		return daoPersonne.getById(id);

	}

	public void updatPerson(int id, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) throws ClassNotFoundException, SQLException {
		daoPersonne.updatePersonne(id, nom, prenom, surnom, email, motDePasse, role);
	}
}
