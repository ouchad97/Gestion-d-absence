package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoApprenant;
import dao.implDao.DaoApprenantImp;
import model.Apprenant;

public class ServicesApprenant {
	
public static List<Apprenant> apprenant = new ArrayList<Apprenant>();
	
	
	public static DaoApprenant daoApprenant = new DaoApprenantImp();
	// getApprenant Id
			public static Apprenant getApprenantById(int idPersonne) throws ClassNotFoundException, SQLException {
				return daoApprenant.getApprenantById(idPersonne);
			}
			
			
}
