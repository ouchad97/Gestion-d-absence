package dao;

import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;
import model.Absence;

public interface DaoAbsenceList<T> {

	
	public ObservableList<T> getAll() throws ClassNotFoundException, SQLException;
	public Absence getById(int id) throws ClassNotFoundException, SQLException;
	
}
