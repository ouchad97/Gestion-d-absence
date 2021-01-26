package dao;

import java.sql.SQLException;

import model.Apprenant;

public interface DaoApprenant {
	public Apprenant getApprenantById(int idPersonne) throws ClassNotFoundException, SQLException;
	
}
