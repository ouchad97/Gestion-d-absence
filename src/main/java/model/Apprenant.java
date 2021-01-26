package model;

public class Apprenant extends Personne {

	private static int idSalle;
	private int idPromotion;
	private String referentiel;

	public Apprenant(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role, int idSalle, int idPromotion, String referentiel) {
		super(idPersonne, nom, prenom, surnom, email, motDePasse, role);
		this.idSalle = idSalle;
		this.idPromotion = idPromotion;
		this.referentiel = referentiel;
	}

	public Apprenant(int idPersonne, int idSalle, int idPromotion, String referentiel) {
		super(idPersonne);
		this.idSalle = idSalle;
		this.idPromotion = idPromotion;
		this.referentiel = referentiel;
	}

	public Apprenant(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) {
		super(idPersonne, nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

	public Apprenant(String nom, String prenom, String surnom, String email, String motDePasse, String role) {
		super(nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

	public Apprenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public int getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getReferentiel() {
		return referentiel;
	}

	public void setReferentiel(String referentiel) {
		this.referentiel = referentiel;
	}

}
