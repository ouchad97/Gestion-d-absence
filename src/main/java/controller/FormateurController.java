package controller;

import dao.implDao.PersonneDao;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.Personne;

import java.sql.SQLException;

public class FormateurController {

    @FXML
    public TableColumn retard;
    @FXML
    public TableColumn abscence;
    @FXML
    private BorderPane mainPanel;

    @FXML
    private TableView<Personne> tableApprenant;

    public void initialize() throws SQLException, ClassNotFoundException {
        PersonneDao data = new PersonneDao();
        tableApprenant.setItems(data.getAll());

        TableColumn<Personne, CheckBox> column = (TableColumn<Personne, CheckBox>) tableApprenant.getColumns().get(2);
        column.setCellValueFactory(new CheckAbscentApprenant());
    }
}

