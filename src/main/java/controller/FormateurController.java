package controller;

import dao.implDao.FormateurImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Formateur;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormateurController implements Initializable {

    @FXML
    public TableColumn abscence;
    @FXML
    private ImageView profileImg;
    @FXML
    private TableView<Formateur> tableApprenant;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FormateurImpl data = new FormateurImpl();
        try {
            tableApprenant.setItems(data.getAll());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        TableColumn<Formateur, CheckBox> column = (TableColumn<Formateur, CheckBox>) tableApprenant.getColumns().get(2);
        column.setCellValueFactory(new CheckAbscentApprenant());



    }


}

