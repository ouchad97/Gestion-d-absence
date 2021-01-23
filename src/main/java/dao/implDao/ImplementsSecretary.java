package dao.implDao;

import dao.SecretaryDoa;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.stage.Screen;
import model.Secretary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.GraphicsEnvironment;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import connexion.DbConnect;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ImplementsSecretary implements SecretaryDoa, Initializable, EventHandler {

    // Get all widgets id's
    @FXML
    private AnchorPane tableWindow;

    @FXML
    private TableView<Secretary> table;

    @FXML
    private TableColumn<Secretary, String> id;

    @FXML
    private TableColumn<Secretary, String> prenom;

    @FXML
    private TableColumn<Secretary, String> nom;

    @FXML
    private TableColumn<Secretary, String> surnom;

    @FXML
    private TableColumn<Secretary, String> email;

    @FXML
    private TableColumn<Secretary, String> dateAbsence;

    @FXML
    private TableColumn<Secretary, String> duree;

    @FXML
    private TableColumn<Secretary, String> justifie;

    @FXML
    private Label title;

    // buttons that will be injected to justifie column
    ArrayList<Button> btnsList = new ArrayList<Button>();

    // Store data from db and add it here
    ObservableList<Secretary> list = FXCollections.observableArrayList();

    // Constructor
    public ImplementsSecretary() {
        super();
    }

    // this method will run automatically when interface has loaded completely
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize table style
        initTableWindowStyle();

        // Set columns and where to look for their data
        this.id.setCellValueFactory(new PropertyValueFactory<Secretary, String>("Id"));
        this.prenom.setCellValueFactory(new PropertyValueFactory<Secretary, String>("FirstName"));
        this.nom.setCellValueFactory(new PropertyValueFactory<Secretary, String>("LastName"));
        this.surnom.setCellValueFactory(new PropertyValueFactory<Secretary, String>("NickName"));
        this.email.setCellValueFactory(new PropertyValueFactory<Secretary, String>("Email"));
        this.dateAbsence.setCellValueFactory(new PropertyValueFactory<Secretary, String>("AbsenceDate"));
        this.duree.setCellValueFactory(new PropertyValueFactory<Secretary, String>("Period"));
        this.justifie.setCellValueFactory(new PropertyValueFactory<Secretary, String>("IsJustified"));

        // Inject to table
        this.table.setItems(list);

        // Get absent students from database
        try {
            getAllAbsentStudents();
            // Inject to table
//            this.table.setItems(list);

        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println(throwables.getMessage());
        }

    }

    @Override
    public void getAllAbsentStudents() throws SQLException, ClassNotFoundException {
        // Instantiate DbConnect and connect to database
        DbConnect dbConnect = new DbConnect();
        Connection connection = dbConnect.getConnection();

        // Query that should be run
        String query = "SELECT\n" +
                "  personne.idPersonne,\n" +
                "  abscence.idAbscence,\n" +
                "  personne.prenom,\n" +
                "  personne.nom,\n" +
                "  personne.surnom,\n" +
                "  personne.email,\n" +
                "  abscence.dateAbscence,\n" +
                "  abscence.durree,\n" +
                "  abscence.justif\n" +
                "FROM personne\n" +
                "\n" +
                "JOIN association4\n" +
                "  ON personne.idPersonne = association4.idPersonne\n" +
                "  \n" +
                "JOIN abscence\n" +
                "  ON abscence.idAbscence = association4.idAbscence;";

        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery(query);

        // Iterate through db rows
        while(queryResult.next()) {
            String idQuery = queryResult.getString("idPersonne");
            String idAbsence = queryResult.getString("idAbscence");
            String prenomQuery = queryResult.getString("prenom");
            String nomQuery = queryResult.getString("nom");
            String surnomQuery = queryResult.getString("surnom");
            String emailQuery = queryResult.getString("email");
            String dataAbsenceQuery = queryResult.getString("dateAbscence");
            String dureeQuery = queryResult.getString("durree");
            String justifQuery = queryResult.getString("justif");

            // create action buttons in justifie column in table
            Button btn = createActionButtons(idAbsence);

            // check if justifie is 0 A.K.A student absence is unjustified
            if (justifQuery.equals("0")) {
                // create rows in table
                list.add(new Secretary(idQuery, prenomQuery, nomQuery, surnomQuery, emailQuery, dataAbsenceQuery, dureeQuery, btn));
            }
        }
    }

    // For creating action buttons in justifie column
    @Override
    public Button createActionButtons(String btnId) {
        Button i = new Button("non");
        i.setId(btnId);
        btnsList.add(i);
        i.setOnAction(this);

        return i;
    }

    // When secretary clicked on non button mark that student as its absence justified
    @Override
    public void markAbsenceJustified(String absenceID) throws SQLException, ClassNotFoundException {
        // Instantiate DbConnect and connect to database
        DbConnect dbConnect = new DbConnect();
        Connection connection = dbConnect.getConnection();

        // Query that expect to be executed
        String query = "UPDATE abscence SET justif = 1 WHERE idAbscence = '" + absenceID + "';";
//        System.out.println(query);

        Statement statement  = connection.createStatement();
        statement.executeUpdate(query);
//        System.out.println("Database updated successfully ");

        // Close connection
        statement.close();
    }

    @Override
    public void initTableWindowStyle() {
        // initialize
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // set main window size
        double windowWidth = screenBounds.getWidth();
        double windowHeight = screenBounds.getHeight();

        // center table title
        double centerTitle = (windowWidth / 2) / 2;
        this.title.setTranslateX(centerTitle);

        // resize columns based on window size
        this.id.setPrefWidth(windowWidth/8);
        this.prenom.setPrefWidth(windowWidth/8);
        this.nom.setPrefWidth(windowWidth/8);
        this.surnom.setPrefWidth(windowWidth/8);
        this.email.setPrefWidth(windowWidth/8);
        this.dateAbsence.setPrefWidth(windowWidth/8);
        this.duree.setPrefWidth(windowWidth/8);
        this.justifie.setPrefWidth(windowWidth/8);

        // Get taskbar height
        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        int taskBarHeight = scrnSize.height - winSize.height;

        // Set table height
        table.setPrefHeight(windowHeight - (taskBarHeight * 3));

        // Set main table window boundaries to visible bounds of the main screen
        tableWindow.setTranslateX(screenBounds.getMinX());
        tableWindow.setTranslateY(screenBounds.getMinY());
        tableWindow.setPrefWidth(screenBounds.getWidth());
        tableWindow.setPrefHeight(screenBounds.getHeight() - taskBarHeight);

        // change default text in table where no rows exists
        table.setPlaceholder(new Label("Il n'y a pas d'eleves absents"));
    }

    @Override
    public void handle(Event event) {
//        TextInputDialog dialog = new TextInputDialog("walter");
//        dialog.setTitle("Text Input Dialog");
//        dialog.setHeaderText("Look, a Text Input Dialog");
//        dialog.setContentText("Please enter your name:");
////        dialog.show();
//
//        // Traditional way to get the response value.
//        Optional<String> result = dialog.showAndWait();
//        if (result.isPresent()){
//            System.out.println("Your name: " + result.get());
//        }

        // The Java 8 way to get the response value (with lambda expression).
//        result.ifPresent(name -> System.out.println("Your name: " + name));

        // check if clicked button is equal to button in array btnsList
        for (Button btn: btnsList) {
            if (event.getSource().equals(btn)) {
//                Integer index = Integer.parseInt(btn.getId());
//                table.getItems().get(index).setVisible(false);
//                table.
//                        byid("tableid").getItems()[0].setVisible("false");
//                table.requestFocus();
//                table.getSelectionModel().select(index);
////                table.getFocusModel().focus(index);
//
//                table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
//                table.getSelectionModel().clearSelection();
//                table.getItems().remove(table.getSelectionModel().getSelectedItem());
                try {
                    markAbsenceJustified(btn.getId());

                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

                // refresh table
//                try {
//                    refreshTable();
//                } catch (ClassNotFoundException | SQLException e) {
//                    System.out.println(e.getMessage());
//                }
            }
        }
    }

    public void refreshTable() throws SQLException, ClassNotFoundException {
//        table.getItems().clear();
//        table.refresh();
//        table = new TableView<Secretary>();
//        new ImplementsSecretary();
//        getAllAbsentStudents();
    }
}


