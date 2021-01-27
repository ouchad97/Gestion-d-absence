package controller;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import model.Formateur;
import dao.implDao.FormateurImpl;

import java.sql.SQLException;


public class CheckAbscentApprenant implements
        Callback<TableColumn.CellDataFeatures<Formateur, CheckBox>, ObservableValue<CheckBox>> {
    FormateurImpl insert = new FormateurImpl();
    @Override
    public ObservableValue<CheckBox> call(TableColumn.CellDataFeatures<Formateur, CheckBox> param) {
        Formateur apprenant = param.getValue();
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
