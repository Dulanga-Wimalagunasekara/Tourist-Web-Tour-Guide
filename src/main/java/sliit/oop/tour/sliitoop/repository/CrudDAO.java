package sliit.oop.tour.sliitoop.repository;

import sliit.oop.tour.sliitoop.dao.SuperDAO;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author Dulanga Wimalagunasekara
 * Generic interface for all the CRUD operations
 * */
public interface CrudDAO<T extends SuperDAO,ID extends Serializable> extends SuperRepository{

    T save(T entity);
    Optional<T> findById(ID pk);
    void deleteById(ID pk);

    T updateById(T entity);
    List<T> findAll();

}
