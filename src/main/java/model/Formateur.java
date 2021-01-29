package model;

<<<<<<< HEAD
import javafx.beans.property.SimpleStringProperty;

public class Formateur {
    private boolean isAbscent;
    private SimpleStringProperty id = new SimpleStringProperty("");
    private SimpleStringProperty nom = new SimpleStringProperty("");
    private SimpleStringProperty prenom = new SimpleStringProperty("");
    private SimpleStringProperty surnom = new SimpleStringProperty("");
    private SimpleStringProperty email = new SimpleStringProperty("");
    private SimpleStringProperty motDePasse = new SimpleStringProperty("");
    private SimpleStringProperty role = new SimpleStringProperty("");

    public Formateur(Long id, String nom, String prenom, String surnom, String email, String motDePasse, String role) {
        this.id.set(String.valueOf(id));
        this.nom.set(nom);
        this.prenom.set(prenom);
        this.surnom.set(surnom);
        this.email.set(email);
        this.motDePasse.set(motDePasse);
        this.role.set(role);
    }
    public Formateur(){

    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getSurnom() {
        return surnom.get();
    }

    public SimpleStringProperty surnomProperty() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom.set(surnom);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getMotDePasse() {
        return motDePasse.get();
    }

    public SimpleStringProperty motDePasseProperty() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse.set(motDePasse);
    }

    public String getRole() {
        return role.get();
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public Boolean isAbscent(){
        return this.isAbscent;
    }

    public void setIsAbscent(Boolean isAbscent){
        this.isAbscent = isAbscent;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", surnom='" + surnom + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
=======
public class Formateur extends Personne {


	private static int idSalle;
	private int idPromotion;
	public Formateur(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role) {
		super(idPersonne, nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}

	public Formateur(String nom, String prenom, String surnom, String email, String motDePasse, String role) {
		super(nom, prenom, surnom, email, motDePasse, role);
		// TODO Auto-generated constructor stub
	}
	public Formateur(int idPersonne, int idSalle, int idPromotion) {
		super(idPersonne);
		this.idSalle = idSalle;
		this.idPromotion = idPromotion;
	}
	public Formateur(int idPersonne, String nom, String prenom, String surnom, String email, String motDePasse,
			String role, int idSalle, int idPromotion) {
		super(idPersonne, nom, prenom, surnom, email, motDePasse, role);
		this.idSalle = idSalle;
		this.idPromotion = idPromotion;
	}

	public static int getIdSalle() {
		return idSalle;
	}

	public static void setIdSalle(int idSalle) {
		Formateur.idSalle = idSalle;
	}

	public int getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}


>>>>>>> 8bea92ca8291cbb7a1fa9db61b3c6523635e55c8
}
