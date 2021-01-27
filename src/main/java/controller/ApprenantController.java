package controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.*;

import model.*;
import services.*;


public class ApprenantController {
	@FXML
	private TableView<Absence> table;
	
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
    
    ObservableList<Absence> data2 = null;
    
    @FXML
	public void initialize() throws ClassNotFoundException, SQLException {
    	
    	DaoPersonneImp data =new DaoPersonneImp();
    	int id_Session = DaoLoginImp.id_Session;
    	Personne cb = data.getById(id_Session);
    	
        
    			Label_Prenom_Nom.setText(cb.getPrenom()+" "+ cb.getNom());
				Label_Email.setText(cb.getEmail());
				
				// get info's
				
			DaoAbsenceListImp data2 = new DaoAbsenceListImp();
        	try {
            	table.setItems(data2.getAll());
      		  } catch (ClassNotFoundException e) {
            e.printStackTrace();
      		  } catch (SQLException throwables) {
            throwables.printStackTrace();
      		  }
				
			/*	List<Absence> absencelist = new ArrayList<Absence>();
		    	int idmy = DaoLoginImp.id_Session;
		    	ServiceAbsence ca = new ServiceAbsence();
				absencelist = ca.getAbsenceAll();
				
				data2 = FXCollections.observableArrayList();
				
				for (Absence abs : absencelist) {
					data2.add(new Absence(abs.getIdAbsence(), abs.getDataAbsence(), abs.getDuree(), abs.isJustif()));
				}
				if (data2 != null) {
					table.setItems(data2);
				} else {
					System.out.println("Erreur data null");
				}*/
				
				
		
				id_absence.setCellValueFactory(new PropertyValueFactory<Absence, Integer>("idAbscence"));
				date_absence.setCellValueFactory(new PropertyValueFactory<Absence, Integer>("dateAbscence"));
				table_justfier.setCellValueFactory(new PropertyValueFactory<Absence, Boolean>("justif"));


				
				
				
				
				
				
				
				
				
			
		}

	}

























