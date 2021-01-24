package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import services.*;

public class AdministrateurController {

	@FXML
	private TextField Txt_id;

	@FXML
	private TextField Txt_nom;

	@FXML
	private TextField Txt_prenom;

	@FXML
	private TextField Txt_surnom;

	@FXML
	private TextField Txt_email;

	@FXML
	private TextField Txt_password;

	@FXML
	private ComboBox<?> cmbx_role;

	@FXML
	private Button btnAjout;

	@FXML
	private Button btnModification;

	@FXML
	private Button btnSuppression;
	
	@FXML
	private Button btnVide;

	@FXML
	private TableView<Personne> Tbl_Personne;

	@FXML
	private TableColumn<Personne, Integer> idPersonneCol;

	@FXML
	private TableColumn<Personne, String> nomCol;

	@FXML
	private TableColumn<Personne, String> prenomCol;

	@FXML
	private TableColumn<Personne, String> surnomCol;

	@FXML
	private TableColumn<Personne, String> emailCol;

	@FXML
	private TableColumn<Personne, String> passwordCol;

	@FXML
	private TableColumn<Personne, String> roleCol;

	ObservableList<Personne> data = null;

	@FXML
	public void initialize() throws ClassNotFoundException, SQLException {

		// Create column

		idPersonneCol.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("idPersonne"));

		nomCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));

		prenomCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));

		surnomCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("surnom"));

		emailCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("email"));

		passwordCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("motDePasse"));

		roleCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("role"));

		List<Personne> personnes = new ArrayList<Personne>();
		personnes = ServicePersonne.getAllPersonnes();

		data = FXCollections.observableArrayList();
		for (Personne personne : personnes) {
			data.add(new Personne(personne.getIdPersonne(), personne.getNom(), personne.getPrenom(),
					personne.getSurnom(), personne.getEmail(), personne.getMotDePasse(), personne.getRole()));
		}
		if (data != null) {
			Tbl_Personne.setItems(data);
		} else {
			System.out.println("Erreur data null");
		}
	}

}
