package dao;

import java.sql.SQLException;
import java.util.List;

import model.Personne;

public interface DaoLogin {
	public List<Personne> getAll() throws ClassNotFoundException, SQLException;
	public static Personne  login(String email, String motDePasse)throws ClassNotFoundException, SQLException {
		return null;
	}
}
