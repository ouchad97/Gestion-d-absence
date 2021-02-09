package model;

public class Administrateur extends Personne {

	public Administrateur(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) {
		super(idPersonne, nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String nom, String prenom, String surnom, String email, String motDePasse, String role) {
		super(nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

}
