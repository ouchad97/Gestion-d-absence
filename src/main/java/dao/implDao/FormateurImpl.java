package dao.implDao;

import dao.FormateurDao;
import connection.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Formateur;

import java.sql.*;

public class FormateurImpl implements FormateurDao<Formateur> {

    @Override
    public Formateur getIdPersonne(int idPersonne) {
        return null;
    }

    @Override
    public ObservableList<Formateur> getAll()throws ClassNotFoundException, SQLException {

        ObservableList<Formateur> perList = FXCollections.observableArrayList();

        DbConnect dbConnect = new DbConnect();
        Connection connectDb = dbConnect.getConnect();

        String query = "SELECT DISTINCT personne.idPersonne, personne.nom, personne.prenom,personne.surnom,personne.email,personne.motDePasse, personne.`role` FROM apprenant, personne WHERE apprenant.idFormateur = 7 AND apprenant.idPersonne = personne.idPersonne -- AND personne.`role` = 'student'";
//        SELECT personne.idPersonne, personne.nom, personne.prenom,personne.surnom personne.`role` FROM apprenant, personne WHERE apprenant.idFormateur = 7 AND apprenant.idPersonne = personne.idPersonne -- AND personne.`role` = 'student';

        Statement statement  = connectDb.createStatement();
        ResultSet resultat = statement.executeQuery(query);

        while(resultat.next()){
            if(resultat.getString("role").equals("apprenant")) {
                Long id = resultat.getLong("idPersonne");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String surnom = resultat.getString("surnom");
                String email = resultat.getString("email");
                String motDePasse = resultat.getString("motDePasse");
                String role = resultat.getString("role");

                // Créer l'objet Personne
                Formateur p = new Formateur(id, nom, prenom, surnom, email, motDePasse, role);
                perList.add(p);
            }
        }
            return perList;
    }

    @Override
    public void insertIntoAbscenceTable(int idPersonne, int nbrHeur) throws SQLException {
        java.util.Date date=new java.util.Date();

        java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        DbConnect dbConnect = new DbConnect();
        Connection connectDb = dbConnect.getConnect();
        String queryInsert = "INSERT into abscence(idAbscence,dateAbscence,nbrHeur,justif) VALUES(?,?,?,?)";
        System.out.println(queryInsert);
        PreparedStatement statement  = connectDb.prepareStatement("select * from abscence",
                                                                ResultSet.TYPE_SCROLL_SENSITIVE,
                                                                ResultSet.CONCUR_UPDATABLE);
        PreparedStatement preparedStmt = connectDb.prepareStatement(queryInsert);
        preparedStmt.setInt (1, 29);
        preparedStmt.setDate (2, sqlDate);
        preparedStmt.setInt (3, nbrHeur);
        preparedStmt.setInt (4, 0);
        preparedStmt.execute();


        int id=0;
        try {
            ResultSet queryResult = statement.executeQuery();
            if(queryResult.last()){
                id=queryResult.getInt("idAbscence");
            }

            System.out.println("id is:"+ id);
            System.out.println("personne id :"+ idPersonne); // print id of personne

            insertIntoAppAbscenceTable(idPersonne, id);

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @Override
    public void insertIntoAppAbscenceTable(int idPersonne, int idAbscence) throws SQLException {
        DbConnect dbConnect = new DbConnect();
        Connection connectDb = dbConnect.getConnect();
        String queryInsert = "INSERT into appAbscence(idPersonne,idAbscence) VALUES(?,?)";
        System.out.println(queryInsert);

        PreparedStatement preparedStmt = connectDb.prepareStatement(queryInsert);
        preparedStmt.setInt (1, idPersonne);
        preparedStmt.setInt (2, idAbscence);
        preparedStmt.execute();

    }

}