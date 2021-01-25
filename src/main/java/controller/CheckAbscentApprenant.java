package controller;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import model.Personne;
import dao.implDao.PersonneDao;

import java.sql.SQLException;


public class CheckAbscentApprenant implements
        Callback<TableColumn.CellDataFeatures<Personne, CheckBox>, ObservableValue<CheckBox>> {
    PersonneDao insert = new PersonneDao();
    @Override
    public ObservableValue<CheckBox> call(TableColumn.CellDataFeatures<Personne, CheckBox> param) {
        Personne apprenant = param.getValue();
        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().setValue(apprenant.isAbscent());
        checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
            apprenant.setIsAbscent(new_val);
            System.out.println("hello");
            System.out.println("hello" + apprenant.getNom());
            try {
                insert.insertIntoAbscenceTable(Integer.parseInt(apprenant.getId()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        return new SimpleObjectProperty<>(checkBox);
    }
}
