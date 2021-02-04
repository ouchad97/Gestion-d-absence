package dao;

import java.sql.SQLException;


import javafx.collections.ObservableList;
import model.Apprenant;



public interface ApprenantDao {
	public ObservableList<Apprenant> getAllById(int id) throws ClassNotFoundException, SQLException;
	public Apprenant getById(int id) throws ClassNotFoundException, SQLException;
}
