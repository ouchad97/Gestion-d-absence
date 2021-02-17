package dao;

import javafx.collections.ObservableList;
import java.sql.SQLException;


public interface FormateurDaos<T> {
        // formateur
        T getIdPersonne(int idPersonne);
        ObservableList<T> getAll() throws ClassNotFoundException, SQLException;

        void insertIntoAbscenceTable(int idPersonne, int nbrHeur) throws SQLException, ClassNotFoundException;
        void insertIntoAppAbscenceTable(int idPersonne, int idAbscence) throws SQLException, ClassNotFoundException;

}
