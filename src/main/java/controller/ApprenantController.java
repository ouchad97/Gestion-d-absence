package controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoLoginImp;
import dao.DaoPersonneImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import model.*;
import services.*;


public class ApprenantController {

    @FXML
    private TableColumn<Absence, Integer> id_absence;

    @FXML
    private TableColumn<Absence, Integer> date_absence;

    @FXML
    private TableColumn<Absence, Integer> table_durre;

    @FXML
    private TableColumn<Absence, Boolean> table_justfier;

    @FXML
    private Label Label_Prenom_Nom;

    @FXML
    private Label Label_Email;

    @FXML
    private Label Label_Surnom;

    @FXML
    private Button btn_deconnect;
    @FXML
    
    ObservableList<Absence> ab = null;
    
    @FXML
	public void initialize() throws ClassNotFoundException, SQLException {
    	
    	DaoPersonneImp data =new DaoPersonneImp();
    	int id_Session = DaoLoginImp.id_Session;
    	Personne cb = data.getById(id_Session);
    	
        
    			Label_Prenom_Nom.setText(cb.getPrenom()+" "+ cb.getNom());
				Label_Email.setText(cb.getEmail());
				
				// get info's
				
				
		
				id_absence.setCellValueFactory(new PropertyValueFactory<Absence, Integer>("idAbscence"));

				date_absence.setCellValueFactory(new PropertyValueFactory<Absence, Integer>("dateAbscence"));

				table_durre.setCellValueFactory(new PropertyValueFactory<Absence, Integer>("durree"));

				table_justfier.setCellValueFactory(new PropertyValueFactory<Absence, Boolean>("justif"));


				
				
				
				
				
				
				
				
				
			
		}

	}

























