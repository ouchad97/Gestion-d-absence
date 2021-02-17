package model;

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


}
