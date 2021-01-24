package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
	private ComboBox<String> cmbx_role;

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
		// combobox Roles
		cmbx_role.getItems().addAll("Apprenant", "Formateur", "Secretaire", "Administrateur");
		cmbx_role.setValue("Apprenant");

		// Create column and get info's
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

	// Add new personne
	final Personne personne = new Personne();

	public void ClickAjout(ActionEvent event) throws ClassNotFoundException, SQLException {
		try {
			Personne personne = ServicePersonne.addPersonne(Integer.parseInt(Txt_id.getText()), Txt_nom.getText(),
					Txt_prenom.getText(), Txt_surnom.getText(), Txt_email.getText(), Txt_password.getText(),cmbx_role.getValue());

			// Refresh
			List<Personne> personnes = new ArrayList<Personne>();
			personnes = ServicePersonne.getAllPersonnes();

			data = FXCollections.observableArrayList();
			for (Personne newpersonne : personnes) {
				data.add(new Personne(newpersonne.getIdPersonne(), newpersonne.getNom(), newpersonne.getPrenom(),
						newpersonne.getSurnom(), newpersonne.getEmail(), newpersonne.getMotDePasse(),
						newpersonne.getRole()));
			}
			if (data != null) {
				Tbl_Personne.setItems(data);
			} else {
				System.out.println("Erreur data null");
			}

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

	// select from table to textfield

	@FXML
	void ClickTableView(MouseEvent event) throws ClassNotFoundException, SQLException {
		Personne userlist = Tbl_Personne.getSelectionModel().getSelectedItem();
		if (userlist != null) {
			Txt_id.setText(String.valueOf(userlist.getIdPersonne()));
			Txt_nom.setText(userlist.getMotDePasse());
			Txt_prenom.setText(userlist.getNom());
			Txt_surnom.setText(userlist.getPrenom());
			Txt_email.setText(userlist.getSurnom());
			Txt_password.setText(userlist.getEmail());
			cmbx_role.setValue(userlist.getRole());

		}

	}

}
