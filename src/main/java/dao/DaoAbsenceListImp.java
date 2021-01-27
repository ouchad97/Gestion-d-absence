package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Absence;

public class DaoAbsenceListImp implements DaoAbsenceList<Absence>{

	Statement statement = null;

	
	@Override
    public ObservableList<Absence> getAll()throws ClassNotFoundException, SQLException {

        ObservableList<Absence> perList = FXCollections.observableArrayList();

		statement = database.getMyConnexion().createStatement();

		ResultSet resultat;
		String requete = "select * from abscence";

		resultat = statement.executeQuery(requete);
        while(resultat.next()){
        	
    			int idAbsence = resultat.getInt("idAbscence");
    			System.out.println(idAbsence);
    			int dateAbsence = resultat.getInt("dateAbscence");
    			System.out.println(dateAbsence);
    			boolean justif = resultat.getString("justif") != null?true:false;
    			System.out.println(justif);

    			Absence abs = new Absence(idAbsence, dateAbsence, justif);
    			perList.add(abs);
        }
            return perList;
    }

	@Override
	public Absence getById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public List<Absence> getAll() throws ClassNotFoundException, SQLException {

		List<Absence> listabsence = new ArrayList<Absence>();

		statement = database.getMyConnexion().createStatement();
		
		System.out.println("Creation de l'objet Statement");
		

		ResultSet resultat;
		String requete = "select * from abscence";

		resultat = statement.executeQuery(requete);

		while (resultat.next()) {
			int idAbsence = resultat.getInt("idAbsence");
			int dateAbsence = resultat.getInt("dateAbsence");
			int durree = resultat.getInt("durree");
			boolean justif = resultat.getString("justif") != null;


			Absence abs = new Absence(idAbsence, dateAbsence, durree, justif);
			listabsence.add(abs);
		}

		return listabsence;
	}

	@Override
	public Absence getById(int id) throws ClassNotFoundException, SQLException {
		
		Absence absencebyid = null;
		String requete = "select * from abscence Where idAbscence= ?";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete);

		statement.setLong(1, id);
		ResultSet resultat = statement.executeQuery();

		if (resultat.next()) {
			int dateAbsence = resultat.getInt("dateAbsence");
			int durree = resultat.getInt("durree");
			boolean justif = resultat.getString("justif") != null;

			absencebyid = new Absence(id, dateAbsence, durree, justif);
		}
		
		return absencebyid;
	} */

	
}
