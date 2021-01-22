package dao;

import java.util.List;

public interface Dao<T> {

        T getIdPersonne(int idPersonne);
        List<T> getAll();

}
