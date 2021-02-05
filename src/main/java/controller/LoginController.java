package controller;

import java.io.IOException;
import java.sql.SQLException;

import model.Administrateur;
import model.Apprenant;
import model.Formateur;
import model.Personne;
import dao.*;
import dao.implDao.DaoLoginImp;
import model.Secretaire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {

	@FXML
	private TextField TxtEmail;

	@FXML
	private PasswordField  TxtMdps;

	@FXML
	private Button btnLogin;

	// Click sur button login EVENT
	public void Clicklogin(ActionEvent event) throws ClassNotFoundException, SQLException {
		// get new window
		Window owner = btnLogin.getScene().getWindow();

		// if email and password empty -> show error alert
		if (TxtEmail.getText().isEmpty()) {
			DaoLoginImp.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email id");
			return;
		}
		if (TxtMdps.getText().isEmpty()) {
			DaoLoginImp.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
			return;
		}

		// add values of email and password to String
		String emailId = TxtEmail.getText();
		String password = TxtMdps.getText();

		// Get user email and password from login() class ProcLinkDB
		Personne User = DaoLoginImp.login(emailId, password);
		try {
			// we have User
			if (User != null) {
				DaoLoginImp.infoBox("Login Successful!", null, "Failed");

				// open new window Administrateur.fxml Administrateur interface
				Stage dialogStage = new Stage();
				Scene scene = null;
				Node source = (Node) event.getSource();
				dialogStage = (Stage) source.getScene().getWindow();
				if (User.getClass() == Administrateur.class) {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdministrateurView.fxml"));
					Parent root = (Parent) loader.load();
					scene = new Scene(root);
					dialogStage.setScene(scene);
					dialogStage.show();

				} else {
					if (User.getClass() == Formateur.class) {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FormateurView.fxml"));
						Parent root = (Parent) loader.load();
						scene = new Scene(root);
						dialogStage.setScene(scene);
						dialogStage.show();
					}
					if (User.getClass() == Apprenant.class) {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ApprenantView.fxml"));
						Parent root = (Parent) loader.load();
						scene = new Scene(root);
						dialogStage.setScene(scene);
						dialogStage.show();
					}
					if (User.getClass() == Secretaire.class) {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SecretaireView.fxml"));
						Parent root = (Parent) loader.load();
						scene = new Scene(root);
						dialogStage.setScene(scene);
						dialogStage.show();
					}
				}
			} else {
				// Alert if email or password not correct
				DaoLoginImp.infoBox("Please enter correct Email and Password", null, "Failed");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}