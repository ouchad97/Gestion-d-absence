package controller;

import dao.implDao.FormateurImpl;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import model.Formateurs;

import java.sql.SQLException;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import model.Formateur;
import dao.implDao.FormateurImpl;

import java.sql.SQLException;


    public class CheckRetardApprenant implements
            Callback<TableColumn.CellDataFeatures<Formateurs, CheckBox>, ObservableValue<CheckBox>> {
        FormateurImpl insert = new FormateurImpl();
        @Override
        public ObservableValue<CheckBox> call(TableColumn.CellDataFeatures<Formateurs, CheckBox> param) {
            Formateurs apprenant = param.getValue();
            CheckBox checkBox = new CheckBox();
            checkBox.selectedProperty().setValue(apprenant.isAbscent());
            checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
                apprenant.setIsAbscent(new_val);
//                System.out.println("hello");
//                System.out.println("hello" + apprenant.getNom());
                try {
                    insert.insertIntoAbscenceTable(Integer.parseInt(apprenant.getId()), 3);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            });
            return new SimpleObjectProperty<>(checkBox);
        }
    }


