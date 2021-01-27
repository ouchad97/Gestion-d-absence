package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoPersonne;
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
import javafx.scene.layout.AnchorPane;
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

	@FXML
	private AnchorPane AnchorApprenant;
	@FXML
	private AnchorPane AnchorFormateur;

	@FXML
	private ComboBox<Integer> cmbx_SalleF;

	@FXML
	private ComboBox<Integer> cmbx_PromotionF;

	@FXML
	private TextField Txt_referentiel;

	@FXML
	private ComboBox<Integer> cmbx_Salle;

	@FXML
	private ComboBox<Integer> cmbx_Promotion;

	ObservableList<Personne> data = null;

	@FXML
	public void initialize() throws ClassNotFoundException, SQLException {
		AnchorApprenant.setVisible(false);
		AnchorFormateur.setVisible(false);
		// combobox Roles
		cmbx_role.getItems().addAll("Apprenant", "Formateur", "Secretaire", "Administrateur");
		cmbx_role.setValue("Selectionnez type de profile");

		// combobox Salle
		cmbx_Salle.getItems().addAll(1, 2, 3, 4, 5, 6);
		cmbx_SalleF.getItems().addAll(1, 2, 3, 4, 5, 6);
		// cmbx_Salle.setValue("Selectionnez une salle");
		// combobox Promotion
		cmbx_Promotion.getItems().addAll(1, 2, 3);
		cmbx_PromotionF.getItems().addAll(1, 2, 3);

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

	// Ajout
	final Apprenant apprenant = new Apprenant();
	final Personne personne = new Personne();

	public void ClickAjout(ActionEvent event) throws ClassNotFoundException, SQLException {

		if (cmbx_role.getValue() == "Apprenant") {

			try {
				Apprenant apprenant = ServicesApprenant.AddApprenant(Integer.parseInt(Txt_id.getText()),
						Txt_nom.getText(), Txt_prenom.getText(), Txt_surnom.getText(), Txt_email.getText(),
						Txt_password.getText(), cmbx_role.getValue(), cmbx_Salle.getValue(), cmbx_Promotion.getValue(),
						Txt_referentiel.getText());

				// Refresh Table
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
		} else {
			
			
			if (cmbx_role.getValue() == "Secretaire" || cmbx_role.getValue() == "Administrateur" ) {

				try {
					Personne personne = ServicePersonne.addPersonne(Integer.parseInt(Txt_id.getText()),
							Txt_nom.getText(), Txt_prenom.getText(), Txt_surnom.getText(), Txt_email.getText(),
							Txt_password.getText(), cmbx_role.getValue());

					// Refresh
					List<Personne> personnes = new ArrayList<Personne>();
					personnes = ServicePersonne.getAllPersonnes();

					data = FXCollections.observableArrayList();
					for (Personne newpersonne : personnes) {
						data.add(new Personne(newpersonne.getIdPersonne(), newpersonne.getNom(),
								newpersonne.getPrenom(), newpersonne.getSurnom(), newpersonne.getEmail(),
								newpersonne.getMotDePasse(), newpersonne.getRole()));
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
			
			if (cmbx_role.getValue() == "Formateur") {
				try {
					Formateur formateur = ServicesFormateur.AddFormateur(Integer.parseInt(Txt_id.getText()),
							Txt_nom.getText(), Txt_prenom.getText(), Txt_surnom.getText(), Txt_email.getText(),
							Txt_password.getText(), cmbx_role.getValue(), cmbx_Salle.getValue(), cmbx_Promotion.getValue());

					// Refresh Table
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
			
		}
	}

	// modif
	@FXML
	public void ClickModif(ActionEvent event) throws ClassNotFoundException, SQLException {
		if (cmbx_role.getValue() == "Apprenant") {
			try {
				ServicesApprenant.updatApprenant(Integer.parseInt(Txt_id.getText()), Txt_nom.getText(),
						Txt_prenom.getText(), Txt_surnom.getText(), Txt_email.getText(), Txt_password.getText(),
						cmbx_role.getValue(), cmbx_Salle.getValue(), cmbx_Promotion.getValue(),
						Txt_referentiel.getText());

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
		} else {
			
			
			if (cmbx_role.getValue() == "Secretaire"  || cmbx_role.getValue() == "Administrateur") {
				try {
					ServicePersonne.updatPerson(Integer.parseInt(Txt_id.getText()), Txt_nom.getText(),
							Txt_prenom.getText(), Txt_surnom.getText(), Txt_email.getText(), Txt_password.getText(),
							cmbx_role.getValue());

					// Refresh
					List<Personne> personnes = new ArrayList<Personne>();
					personnes = ServicePersonne.getAllPersonnes();

					data = FXCollections.observableArrayList();
					for (Personne newpersonne : personnes) {
						data.add(new Personne(newpersonne.getIdPersonne(), newpersonne.getNom(),
								newpersonne.getPrenom(), newpersonne.getSurnom(), newpersonne.getEmail(),
								newpersonne.getMotDePasse(), newpersonne.getRole()));
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
			
			if (cmbx_role.getValue() == "Formateur") {
				try {
					ServicesFormateur.updatFormateur(Integer.parseInt(Txt_id.getText()), Txt_nom.getText(),
							Txt_prenom.getText(), Txt_surnom.getText(), Txt_email.getText(), Txt_password.getText(),
							cmbx_role.getValue(), cmbx_Salle.getValue(), cmbx_Promotion.getValue());

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
		}
	}

	// Delete Apprenant
	@FXML
	public void ClickSupp(ActionEvent event) throws ClassNotFoundException, SQLException {
		try {
			if (cmbx_role.getValue() == "Apprenant") {
				ServicesApprenant.deletePerson(Integer.parseInt(Txt_id.getText()));
			} else {
				if (cmbx_role.getValue() == "Secretaire" || cmbx_role.getValue() == "Administrateur") {
					ServicePersonne.deletePerson(Integer.parseInt(Txt_id.getText()));
				}
				if (cmbx_role.getValue() == "Formateur") {
					ServicesFormateur.deletePerson(Integer.parseInt(Txt_id.getText()));
				}
			}
			// Refresh
			Txt_id.setText("");
			Txt_nom.setText("");
			Txt_prenom.setText("");
			Txt_surnom.setText("");
			Txt_email.setText("");
			Txt_password.setText("");
			cmbx_role.setValue("Selectionnez type de profile");
			Txt_referentiel.setText("");

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
			Txt_nom.setText(userlist.getNom());
			Txt_prenom.setText(userlist.getPrenom());
			Txt_surnom.setText(userlist.getSurnom());
			Txt_email.setText(userlist.getEmail());
			Txt_password.setText(userlist.getMotDePasse());
			cmbx_role.setValue(userlist.getRole());

			if (cmbx_role.getValue() == "Apprenant") {
				cmbx_Salle.setValue(ServicesApprenant.getApprenantById(userlist.getIdPersonne()).getIdSalle());
				cmbx_Promotion.setValue(ServicesApprenant.getApprenantById(userlist.getIdPersonne()).getIdPromotion());
				Txt_referentiel.setText(ServicesApprenant.getApprenantById(userlist.getIdPersonne()).getReferentiel());
			} else {
				cmbx_Salle.setValue(1);
				cmbx_Promotion.setValue(1);
			}
		}
	}

	// SelectComboboxRole and change Anchor's
	@FXML
	public void selectRole(ActionEvent event) throws ClassNotFoundException, SQLException {
		if (cmbx_role.getValue() == "Apprenant") {
			AnchorApprenant.setVisible(true);
			AnchorFormateur.setVisible(false);
		} else {
			if (cmbx_role.getValue() == "Formateur") {
				AnchorFormateur.setVisible(true);
				AnchorApprenant.setVisible(false);
			}
			if (cmbx_role.getValue() == "Administrateur" || cmbx_role.getValue() == "Secretaire") {
				AnchorApprenant.setVisible(false);
				AnchorFormateur.setVisible(false);
			}
		}
	}

	// Button Vider
	@FXML
	void ClickVider(ActionEvent event) throws ClassNotFoundException, SQLException {

		Txt_id.setText("");
		Txt_nom.setText("");
		Txt_prenom.setText("");
		Txt_surnom.setText("");
		Txt_email.setText("");
		Txt_password.setText("");
		cmbx_role.setValue("Selectionnez type de profile");
		Txt_referentiel.setText("");

	}
}
