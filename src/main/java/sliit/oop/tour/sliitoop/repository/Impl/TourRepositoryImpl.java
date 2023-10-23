package sliit.oop.tour.sliitoop.repository.Impl;

import sliit.oop.tour.sliitoop.connection.DBConnection;
import sliit.oop.tour.sliitoop.dao.TourDAO;
import sliit.oop.tour.sliitoop.exception.DatabaseOperationFailException;
import sliit.oop.tour.sliitoop.repository.TourRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TourRepositoryImpl implements TourRepository {

    private final Connection connection;

    public TourRepositoryImpl() {
        this.connection = DBConnection.getDBConnection().getConnection();
    }

    @Override
    public TourDAO save(TourDAO entity) {

        try {

            PreparedStatement stm = connection.prepareStatement("INSERT INTO tour (location, price, no_of_days, description, no_of_pax) VALUES (?, ?, ?, ?, ?)");
            stm.setString(1, entity.getLocation());
            stm.setInt(2, entity.getPrice());
            stm.setInt(3, entity.getNoOfDays());
            stm.setString(4, entity.getDescription());
            stm.setInt(5, entity.getNoOfPax());

            int i = stm.executeUpdate();
            if (i != 1) {
                throw new DatabaseOperationFailException("Tour Insertion Failed!");
            }

            return entity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<TourDAO> findById(Integer pk) {

        try {
            ResultSet rst = connection.createStatement().executeQuery("SELECT * FROM tour WHERE tour_id=".concat(String.valueOf(pk)));
            if (rst.next()) {
                return Optional.of(new TourDAO(rst.getString("location"), rst.getInt("price"),
                        rst.getInt("no_of_days"), rst.getString("description"), rst.getInt("no_of_pax")));
            }

            throw new DatabaseOperationFailException("No Records Found for Tour Id : ".concat(String.valueOf(pk)));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(Integer pk) {

        try {
            boolean execute = connection.createStatement().execute("DELETE FROM tour WHERE tour_id=".concat(String.valueOf(pk)));
            if (!execute) {
                throw new DatabaseOperationFailException("Tour Delete Failed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public TourDAO updateById(TourDAO entity) {

        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE tour SET location=?, price=?, no_of_days=?, description=?, no_of_pax=? WHERE tour_id=?");
            stm.setString(1, entity.getLocation());
            stm.setInt(2, entity.getPrice());
            stm.setInt(2, entity.getNoOfDays());
            stm.setString(2, entity.getDescription());
            stm.setInt(2, entity.getNoOfPax());
            stm.setInt(2, entity.getId());

            int i = stm.executeUpdate();
            if (i != 1) {
                throw new DatabaseOperationFailException("Tour Update Failed!");
            }

            return entity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<TourDAO> findAll() {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM tour");
            if (!resultSet.next()) {
                throw new DatabaseOperationFailException("No Data Found!");
            }

            ArrayList<TourDAO> tourList = new ArrayList<>();

            for (int i = 0; i < resultSet.getFetchSize(); i++) {
                tourList.add(new TourDAO(resultSet.getString("location"), resultSet.getInt("price"),
                        resultSet.getInt("no_of_days"), resultSet.getString("description"), resultSet.getInt("no_of_pax")));
                resultSet.next();
            }

            return tourList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
