package model;


public class Personne {
	private int idPersonne;
	private String nom;
	private String prenom;
	private String surnom;
	private String email;
	private String motDePasse;
	private String role;

	public Personne(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.surnom = surnom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
	}
	public Personne(int idPersonne) {
		super();
		this.idPersonne = idPersonne;
	}
	public Personne(String nom, String prenom, String surnom, String email, String motDePasse, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.surnom = surnom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSurnom() {
		return surnom;
	}

	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
