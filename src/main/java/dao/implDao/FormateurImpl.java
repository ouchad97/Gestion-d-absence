package dao.implDao;

import dao.FormateurDao;
import connection.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Formateur;

import java.sql.*;

public class FormateurImpl implements FormateurDao<Formateur> {

    Statement statement = null;

    @Override
    public Formateur getIdPersonne(int idPersonne) {
        return null;
    }

    @Override
    public ObservableList<Formateur> getAll()throws ClassNotFoundException, SQLException {

        ObservableList<Formateur> perList = FXCollections.observableArrayList();

        DbConnect dbConnect = new DbConnect();
        Connection connectDb = dbConnect.getConnect();

        String query = "select * from personne";

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
    public void insertIntoAbscenceTable(int idPersonne) throws SQLException {

        DbConnect dbConnect = new DbConnect();
        Connection connectDb = dbConnect.getConnect();
        String queryInsert = "INSERT into abscence(idAbscence,justif) VALUES(?,?)";
        System.out.println(queryInsert);
        PreparedStatement statement  = connectDb.prepareStatement("select * from abscence",
                                                                ResultSet.TYPE_SCROLL_SENSITIVE,
                                                                ResultSet.CONCUR_UPDATABLE);
        PreparedStatement preparedStmt = connectDb.prepareStatement(queryInsert);
        preparedStmt.setInt (1, 17);
        preparedStmt.setInt (2, 0);
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