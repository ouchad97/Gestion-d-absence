package model;

public class Formateur extends Personne {

	public Formateur(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) {
		super(idPersonne, nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

	public Formateur(String nom, String prenom, String surnom, String email, String motDePasse, String role) {
		super(nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

}
