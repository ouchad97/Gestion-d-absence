package dao.implDao;

import dao.FormateurDaos;
import connection.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Formateurs;

import java.sql.*;

public class FormateurImpl implements FormateurDaos<Formateurs> {

    @Override
    public Formateurs getIdPersonne(int idPersonne) {
        return null;
    }

    @Override
    public ObservableList<Formateurs> getAll()throws ClassNotFoundException, SQLException {

        ObservableList<Formateurs> perList = FXCollections.observableArrayList();

        DbConnect dbConnect = new DbConnect();
        Connection connectDb = dbConnect.getConnect();

        String query = "SELECT personne.idPersonne, personne.nom, personne.prenom,personne.surnom,personne.email,personne.motDePasse, personne.`role` FROM apprenant, personne WHERE apprenant.idFormateur = 3 AND apprenant.idPersonne = personne.idPersonne AND personne.`role` = 'Apprenant'";

        Statement statement  = connectDb.createStatement();
        ResultSet resultat = statement.executeQuery(query);

        while(resultat.next()){
            if(resultat.getString("role").equals("Apprenant")) {
                Long id = resultat.getLong("idPersonne");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String surnom = resultat.getString("surnom");
                String email = resultat.getString("email");
                String motDePasse = resultat.getString("motDePasse");
                String role = resultat.getString("role");

                // Créer l'objet Personne
                Formateurs p = new Formateurs(id, nom, prenom, surnom, email, motDePasse, role);
                perList.add(p);
            }
        }
            return perList;
    }

    @Override
    public void insertIntoAbscenceTable(int idPersonne, int nbrHeur) throws SQLException, ClassNotFoundException {
        java.util.Date date=new java.util.Date();

        java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        DbConnect dbConnect = new DbConnect();
        Connection connectDb = dbConnect.getConnect();
        String queryInsert = "INSERT into abscence(dateAbscence,nbrHeur,justif) VALUES(?,?,?)";
        System.out.println(queryInsert);
        PreparedStatement statement  = connectDb.prepareStatement("select * from abscence",
                                                                ResultSet.TYPE_SCROLL_SENSITIVE,
                                                                ResultSet.CONCUR_UPDATABLE);
        PreparedStatement preparedStmt = connectDb.prepareStatement(queryInsert);
        preparedStmt.setDate (1, sqlDate);
        preparedStmt.setInt (2, nbrHeur);
        preparedStmt.setInt (3, 0);
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
    public void insertIntoAppAbscenceTable(int idPersonne, int idAbscence) throws SQLException, ClassNotFoundException {
        DbConnect dbConnect = new DbConnect();
        Connection connectDb = dbConnect.getConnect();
        String queryInsert = "INSERT into association4(idPersonne,idAbscence) VALUES(?,?)";
        System.out.println(queryInsert);

        PreparedStatement preparedStmt = connectDb.prepareStatement(queryInsert);
        preparedStmt.setInt (1, idPersonne);
        preparedStmt.setInt (2, idAbscence);
        preparedStmt.execute();

    }

}