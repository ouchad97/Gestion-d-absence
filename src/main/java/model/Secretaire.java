package model;

public class Secretaire extends Personne {

	public Secretaire(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) {
		super(idPersonne, nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

	public Secretaire(String nom, String prenom, String surnom, String email, String motDePasse, String role) {
		super(nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

}
