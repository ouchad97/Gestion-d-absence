package model;

public class Apprenant {
	private int idAbscence;
	private String dateAbscence;
	private boolean justif;
	private int idPersonne;
	private int idSalle;
	private int idPromotion;
	private String referentiel;
	private String nom;
	private String surnom;
	private String prenom;
	private String email;
	private String motDePasse;
	private String role;
	private int hours;
	private int totalhours;
	

	
	public int getIdAbscence() {
		return idAbscence;
	}
	public void setIdAbscence(int idAbscence) {
		this.idAbscence = idAbscence;
	}
	public String getDateAbscence() {
		return dateAbscence;
	}
	public void setDateAbscence(String dateAbscence) {
		this.dateAbscence = dateAbscence;
	}
	public boolean isJustif() {
		return justif;
	}
	public void setJustif(boolean justif) {
		this.justif = justif;
	}
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getTotalhours() {
		return totalhours;
	}
	
	public void setTotalhours(int totalhours) {
		this.totalhours = totalhours;
	}
	public Apprenant(int idAbscence, String dateAbscence, boolean justif, int idPersonne, int idSalle, int idPromotion,
			String referentiel, String nom, String surnom, String prenom, String email, String motDePasse, String role,
			int hours, int totalhours) {
		super();
		this.idAbscence = idAbscence;
		this.dateAbscence = dateAbscence;
		this.justif = justif;
		this.idPersonne = idPersonne;
		this.idSalle = idSalle;
		this.idPromotion = idPromotion;
		this.referentiel = referentiel;
		this.nom = nom;
		this.surnom = surnom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
		this.hours = hours;
		this.totalhours = totalhours;
	}
	public Apprenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
