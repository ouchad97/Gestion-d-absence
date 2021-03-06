package dao.implDao;

import dao.SecretaryDoa;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
import java.util.ResourceBundle;

import connection.DbConnect;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

@SuppressWarnings("rawtypes")
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
    private TableColumn<Secretary, String> justifie;

    // table title
    @FXML
    private Label title;

    // For teachers combobox and teachers list
    @FXML
    private ComboBox<String> teacherComboBox;
    ObservableList<String> teachersList;
    ArrayList<Integer> teachersListIndexes = new ArrayList<Integer>();

    // buttons that will be injected to justifie column
    ArrayList<Button> btnsList = new ArrayList<Button>();

    // Store data from db and add it here
    ObservableList<Secretary> list = FXCollections.observableArrayList();

    // For storing row id's
    ArrayList<Integer> rows = new ArrayList<Integer>();

    // initialize
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    // set main window size
    double windowWidth = 0f;
    double windowHeight = 0f;

    // Constructor
    public ImplementsSecretary() {
        super();

        windowWidth = screenBounds.getWidth();
        windowHeight = screenBounds.getHeight();
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
        this.justifie.setCellValueFactory(new PropertyValueFactory<Secretary, String>("IsJustified"));

        // Inject to table
        this.table.setItems(list);

        try {
            // Get teacher from db and create them
            createTeacher();

            // Get absent students from database
            getAllAbsentStudents();

        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println(throwables.getMessage());
        }

    }

    @Override
    public void getAllAbsentStudents() throws SQLException, ClassNotFoundException {
        // Instantiate DbConnect and connect to database
        DbConnect dbConnect = new DbConnect();
        Connection connection = dbConnect.getConnect();

        // Query that should be run
        String query = "SELECT\n" +
                "  personne.idPersonne,\n" +
                "  abscence.idAbscence,\n" +
                "  personne.prenom,\n" +
                "  personne.nom,\n" +
                "  personne.surnom,\n" +
                "  personne.email,\n" +
                "  abscence.dateAbscence,\n" +
                "  abscence.justif\n" +
                "FROM personne\n" +
                "\n" +
                "JOIN association4\n" +
                "  ON personne.idPersonne = association4.idPersonne\n" +
                "  \n" +
                "JOIN abscence\n" +
                "  ON abscence.idAbscence = association4.idAbscence ORDER BY dateAbscence DESC;;";

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
            String justifQuery = queryResult.getString("justif");

            // create action buttons in justifie column in table
            Button btn = createActionButtons(idAbsence);

            // check if justifie is 0 A.K.A student absence is unjustified
            if (justifQuery.equals("0")) {
                // create rows in table
                list.add(new Secretary(idAbsence, prenomQuery, nomQuery, surnomQuery, emailQuery, dataAbsenceQuery, btn));

                // Adding absenceId to rows arraylist
                rows.add(Integer.parseInt(idAbsence));
            }
        }
    }

    // For creating action buttons in justifie column
    @Override
    public Button createActionButtons(String btnId) {
        Button i = new Button("Marquer l'eleve comme justifie");
        i.setStyle("-fx-pref-width: 190px;-fx-pref-height: 40px;-fx-font-size: 10px");
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
        Connection connection = dbConnect.getConnect();

        // Query that expect to be executed
        String query = "UPDATE abscence SET justif = 1 WHERE idAbscence = '" + absenceID + "';";

        Statement statement  = connection.createStatement();
        statement.executeUpdate(query);

        // Close connection
        statement.close();
    }

    // Create teacher combobox with their names
    @Override
    public void createTeacher() throws SQLException, ClassNotFoundException {
        // create teachers list
        teachersList = FXCollections.observableArrayList();

        // Instantiate DbConnect and connect to database
        DbConnect dbConnect = new DbConnect();
        Connection connection = dbConnect.getConnect();

        // Query that should be get teachers from db
        String query = "SELECT * FROM Personne WHERE role = 'Formateur';";

        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery(query);

        // Iterate through db rows
        while(queryResult.next()) {
            // Add teacher to teachersList
            teachersList.add(queryResult.getString("prenom"));

            // add teacher indexes aka id's
            Integer teacherID = queryResult.getInt(1);
            teachersListIndexes.add(teacherID);
        }

        // Inject teacher to teacherComboBox
        teacherComboBox.setItems(teachersList);
    }

    // when secretary select a teacher
    @Override
    public void loadStudentsByTeacher() throws SQLException, ClassNotFoundException {
        // reset table and clear row data aka row id's
        list.clear();
        rows.clear();

        // Get selected teacher
        int selectedTeacherIndex = teacherComboBox.getSelectionModel().getSelectedIndex();
        int teacherID = 0;

        // set teacher id
        for (int i = 0; i < teachersListIndexes.size(); i++) {
            if (i == selectedTeacherIndex) {
                teacherID = teachersListIndexes.get(i);
            }
        }

        // Instantiate DbConnect and connect to database
        DbConnect dbConnect = new DbConnect();
        Connection connection = dbConnect.getConnect();

        // Query that should be run
        String query = "SELECT\n" +
                "    abscence.idAbscence,\n" +
                "    personne.nom,\n" +
                "    personne.prenom,\n" +
                "    personne.surnom,\n" +
                "    personne.email,\n" +
                "    abscence.dateAbscence,\n" +
                "    abscence.justif\n" +
                "FROM\n" +
                "    apprenant,\n" +
                "    personne,\n" +
                "    association4,\n" +
                "    abscence\n" +
                "WHERE\n" +
                "    apprenant.idPersonne = personne.idPersonne\n" +
                "    AND personne.idPersonne = association4.idPersonne\n" +
                "    AND abscence.idAbscence = association4.idAbscence\n" +
                "    AND apprenant.idFormateur = " + teacherID + " ORDER BY dateAbscence DESC;";

        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery(query);

        // Iterate through db rows
        while(queryResult.next()) {
            String idAbsence = queryResult.getString("idAbscence");
            String prenomQuery = queryResult.getString("prenom");
            String nomQuery = queryResult.getString("nom");
            String surnomQuery = queryResult.getString("surnom");
            String emailQuery = queryResult.getString("email");
            String dataAbsenceQuery = queryResult.getString("dateAbscence");
            String justifQuery = queryResult.getString("justif");

            // create action buttons in justifie column in table
            Button btn = createActionButtons(idAbsence);

            // check if justifie is 0 A.K.A student absence is unjustified
            if (justifQuery.equals("0")) {
                // create rows in table
                list.add(new Secretary(idAbsence, prenomQuery, nomQuery, surnomQuery, emailQuery, dataAbsenceQuery, btn));

                // Adding absenceId to rows arraylist
                rows.add(Integer.parseInt(idAbsence));

            }
        }
    }

    // Initialize basic style for table
    @Override
    public void initTableWindowStyle() {
        // center table title
        double centerTitle = (windowWidth / 2) / 2;
        this.title.setTranslateX(centerTitle);

        // resize columns based on window size
        this.id.setPrefWidth(windowWidth/7);
        this.prenom.setPrefWidth(windowWidth/7);
        this.nom.setPrefWidth(windowWidth/7);
        this.surnom.setPrefWidth(windowWidth/7);
        this.email.setPrefWidth(windowWidth/7);
        this.dateAbsence.setPrefWidth(windowWidth/7);
        this.justifie.setPrefWidth(windowWidth/7);

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
        // check if clicked button is equal to button in array btnsList
        for (Button btn: btnsList) {
            if (event.getSource().equals(btn)) {
                // Index aka row id
                Integer index = Integer.parseInt(btn.getId());

                try {
                    // Mark student absence as justified
                    markAbsenceJustified(btn.getId());

                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

                // refresh table
                refreshTable(index);
            }
        }
    }

    // For refreshing table when student marked as justified
    public void refreshTable(int absenceID){
        // using indexOf() to find index of absenceID
        int pos = rows.indexOf(absenceID);

        // request focus
        table.requestFocus();

        // select that row
        table.getSelectionModel().select(pos);

        // remove selected row
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());

        // clear selection
        table.getSelectionModel().clearSelection();

        // remove that element from array
        rows.remove(pos);
    }
}