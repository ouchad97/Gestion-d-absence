package controller;

//import config.Database;
import connexion.DbConnect;
import dao.implDao.ImplementsSecretary;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import model.Secretary;


public class SecretaryController extends ImplementsSecretary /*implements EventHandler*/ {

    // Constructor
    public SecretaryController() {

    }



    // For getting data from database
//    private void getData(){
//        Database database = new Database();
//        Connection connection = database.getConnect();
//
//        // Query
//        String query = "SELECT\n" +
//                "  personne.idPersonne,\n" +
//                "  abscence.idAbscence,\n" +
//                "  personne.prenom,\n" +
//                "  personne.nom,\n" +
//                "  personne.surnom,\n" +
//                "  personne.email,\n" +
//                "  abscence.dateAbscence,\n" +
//                "  abscence.durree,\n" +
//                "  abscence.justif\n" +
//                "FROM personne\n" +
//                "\n" +
//                "JOIN association4\n" +
//                "  ON personne.idPersonne = association4.idPersonne\n" +
//                "  \n" +
//                "JOIN abscence\n" +
//                "  ON abscence.idAbscence = association4.idAbscence;";
//
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet queryResult = statement.executeQuery(query);
//
//            // Iterate through db rows
//            while(queryResult.next()) {
//                String idQuery = queryResult.getString("idPersonne");
//                String idAbsence = queryResult.getString("idAbscence");
//                String prenomQuery = queryResult.getString("prenom");
//                String nomQuery = queryResult.getString("nom");
//                String surnomQuery = queryResult.getString("surnom");
//                String emailQuery = queryResult.getString("email");
//                String dataAbsenceQuery = queryResult.getString("dateAbscence");
//                String dureeQuery = queryResult.getString("durree");
//                String justifQuery = queryResult.getString("justif");
//
//                // create action buttons in justifie column in table
//                Button btn = createActionButtons(idAbsence);
//
//                // check if justifie is 0 A.K.A student absence is unjustified
//                if (justifQuery.equals("0")) {
//                    // create rows in table
//                    list.add(new Secretary(idQuery, prenomQuery, nomQuery, surnomQuery, emailQuery, dataAbsenceQuery, dureeQuery, btn));
//                }
//
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }

    // For creating action buttons
//    private Button createActionButtons(String btnId) {
//        Button i = new Button("non");
//        i.setId(btnId);
//        i.setOnAction(this);
//        btnsList.add(i);
//
//        return i;
//    }

//    private void initTableWindowStyle(){
//
//    }



//    @Override
//    public void handle(Event event) {
//        // check if clicked button is equal to button in array btnsList
//        for (Button btn: btnsList) {
//            if (event.getSource().equals(btn)) {
//                markAbsenceJustified(btn.getId());
//                this.table.getItems().clear();
//                getData();
////                System.out.println("button id " + btn.getId());
//            }
//        }
//    }

}


