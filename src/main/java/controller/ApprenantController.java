package controller;

import java.sql.SQLException;

import dao.ApprenantDao;
import dao.DaoLoginImp;
import dao.DaoPersonneImp;
import dao.implDao.ApprenantDaoImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Apprenant;


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
    private Label label_totalhours;
    ObservableList<Apprenant> list = FXCollections.observableArrayList();
    
    @FXML
    
    public void initialize() throws ClassNotFoundException, SQLException {
    	
    	

    	int id_Session = DaoLoginImp.id_Session;
    	ApprenantDaoImp ap = new ApprenantDaoImp();
    	list = ap.getAllById(id_Session);
    	

    	Apprenant cb = ap.getById(id_Session);
    	
    	System.out.println(cb.getHours());
    	
    	Integer IdSalle = cb.getIdSalle();
    	Integer Promotion = cb.getIdPromotion();
    	Integer totalhours = cb.getTotalhours();
    	Label_Prenom_Nom.setText(cb.getPrenom()+" "+cb.getNom());
    	Label_Email.setText(cb.getEmail());
    	Label_Surnom.setText(cb.getSurnom());
    	Label_role.setText(cb.getRole());
    	Label_salle.setText(IdSalle.toString());
    	Label_promo.setText(Promotion.toString());
    	Label_referance.setText(cb.getReferentiel());
    	label_totalhours.setText(totalhours.toString());
    	
    	
    	id_absence.setCellValueFactory(new PropertyValueFactory<Apprenant, Integer>("idAbscence"));
    	date_absence.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("dateAbscence"));
    	table_justfier.setCellValueFactory(new PropertyValueFactory<Apprenant, String>("justif"));
    	table_hours.setCellValueFactory(new PropertyValueFactory<Apprenant, Integer>("hours"));
    	this.table.setItems(list);
    }
}