package controller;

import java.sql.SQLException;


import dao.implDao.ApprenantDaoImp;
import dao.implDao.DaoLoginImp;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.app.Apprenant;



public class ApprenantController {

    @FXML
    private TableView<Apprenant> table;

    @FXML
    private TableColumn<Apprenant, Integer> id_absence;

    @FXML
    private TableColumn<Apprenant, String> date_absence;

    @FXML
    private TableColumn<Apprenant, String> table_justfier;

    @FXML
    private TableColumn<Apprenant, Integer> table_hours;

    @FXML
    private Label Label_Prenom_Nom;

    @FXML
    private Label Label_Email;

    @FXML
    private Label Label_Surnom;

    @FXML
    private Button btn_deconnect;

    @FXML
    private Label Label_role;

    @FXML
    private Label Label_salle;

    @FXML
    private Label Label_promo;

    @FXML
    private Label Label_referance;
    
    @FXML
    private Label label_idformateur;

    @FXML
    private Label label_totalhours;
    ObservableList<Apprenant> list = FXCollections.observableArrayList();
    
    @FXML
    
    public void initialize() throws ClassNotFoundException, SQLException {
    	
    	

    	int id_Session = DaoLoginImp.id_Session;
    	ApprenantDaoImp ap = new ApprenantDaoImp();
    	list = ap.getAllById(id_Session);
    	

    	Apprenant cb = ap.getById(id_Session);

    	Integer IdSalle = cb.getIdSalle();
    	Integer Promotion = cb.getIdPromotion();
    	Integer totalhours = cb.getTotalhours();
    	Integer idformateur = cb.getIdFormateur();
    	
    	Label_Prenom_Nom.setText(cb.getPrenom()+" "+cb.getNom());
    	Label_Email.setText(cb.getEmail());
    	Label_Surnom.setText(cb.getSurnom());
    	Label_role.setText(cb.getRole());
    	Label_salle.setText(IdSalle.toString());
    	Label_promo.setText(Promotion.toString());
    	Label_referance.setText(cb.getReferentiel());
    	label_totalhours.setText(totalhours.toString());
    	label_idformateur.setText(idformateur.toString());

    	id_absence.setCellValueFactory(new PropertyValueFactory<Apprenant, Integer>("idAbscence"));
    	date_absence.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("dateAbscence"));
    	table_justfier.setCellValueFactory(cellData -> {
            boolean justif = cellData.getValue().isJustif();

            String genderAsString;
            if(justif == true)
            {
                genderAsString = "Justifie";
            }
            else
            {
                genderAsString = "Non Justifie";
            }

            return new ReadOnlyStringWrapper(genderAsString);
        });
    	table_hours.setCellValueFactory(new PropertyValueFactory<Apprenant, Integer>("nbrHeur"));
    	
    	this.table.setItems(list);
    }
}

