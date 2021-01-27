package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoAbsenceList;
import dao.DaoAbsenceListImp;
import model.Absence;


public class ServiceAbsence {
	
	public static  List<Absence> absencelist = new ArrayList<Absence>();
	public static  DaoAbsenceList daoabsencelist = new DaoAbsenceListImp();
	
	public List<Absence> getAbsenceAll() throws ClassNotFoundException, SQLException {
		return absencelist = daoabsencelist.getAll();
	}

	public Absence getAbsenceById(int id) throws ClassNotFoundException, SQLException {
		return daoabsencelist.getById(id);

	}
	
}
