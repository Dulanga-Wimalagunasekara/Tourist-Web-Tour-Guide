package sliit.oop.tour.sliitoop.repository.Impl;

import sliit.oop.tour.sliitoop.connection.DBConnection;
import sliit.oop.tour.sliitoop.dao.TourDAO;
import sliit.oop.tour.sliitoop.repository.TourRepository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class TourRepositoryImpl implements TourRepository {

    private Connection connection;

    public TourRepositoryImpl(Connection connection) {
        this.connection = DBConnection.getDBConnection().getConnection();
    }

    @Override
    public TourDAO save(TourDAO entity) {
        return null;
    }

    @Override
    public Optional<TourDAO> findById(Integer pk) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer pk) {

    }

    @Override
    public TourDAO updateById(Integer pk) {
        return null;
    }

    @Override
    public List<TourDAO> findAll() {
        return null;
    }
}
