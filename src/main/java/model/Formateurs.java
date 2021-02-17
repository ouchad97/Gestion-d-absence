package model;

import javafx.beans.property.SimpleStringProperty;

public class Formateurs {
    private boolean isAbscent;
    private SimpleStringProperty id = new SimpleStringProperty("");
    private SimpleStringProperty nom = new SimpleStringProperty("");
    private SimpleStringProperty prenom = new SimpleStringProperty("");
    private SimpleStringProperty surnom = new SimpleStringProperty("");
    private SimpleStringProperty email = new SimpleStringProperty("");
    private SimpleStringProperty motDePasse = new SimpleStringProperty("");
    private SimpleStringProperty role = new SimpleStringProperty("");

    public Formateurs(Long id, String nom, String prenom, String surnom, String email, String motDePasse, String role) {
        this.id.set(String.valueOf(id));
        this.nom.set(nom);
        this.prenom.set(prenom);
        this.surnom.set(surnom);
        this.email.set(email);
        this.motDePasse.set(motDePasse);
        this.role.set(role);
    }
    public Formateurs(){

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
}
