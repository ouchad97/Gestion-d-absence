package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import model.Absence;

public class ApprenantController {

    @FXML
    private TableColumn<Absence, Integer> id_absence;

    @FXML
    private TableColumn<Absence, String> date_absence;

    @FXML
    private TableColumn<Absence, Integer> table_durre;

    @FXML
    private TableColumn<Absence, Boolean> table_justfier;

    @FXML
    private Label Label_Prenom_Nom;

    @FXML
    private Label Label_Email;

    @FXML
    private Label Label_Ref;

    @FXML
    private Button btn_deconnect;
    
  
    
    @FXML
	public void initialize() {

				Label_Prenom_Nom.setText("Hamza Ghounbaz");
				Label_Email.setText("HamzaGhounbaz@gmail.com");
				Label_Ref.setText("Developeur Web et Mobile");
				
			
		}

	}

























