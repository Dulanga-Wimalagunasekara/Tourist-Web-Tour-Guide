package sliit.oop.tour.sliitoop.repository.Impl;

import sliit.oop.tour.sliitoop.connection.DBConnection;
import sliit.oop.tour.sliitoop.dao.StaffDAO;
import sliit.oop.tour.sliitoop.dao.TourDAO;
import sliit.oop.tour.sliitoop.exception.DatabaseOperationFailException;
import sliit.oop.tour.sliitoop.repository.StaffRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StaffRepositoryImpl implements StaffRepository {

    private final Connection connection;

    public StaffRepositoryImpl() {
        connection = DBConnection.getDBConnection().getConnection();;
    }

    @Override
    public StaffDAO save(StaffDAO entity) {

        try {
            Optional<StaffDAO> byId = this.findById(entity.getStaffId());
            if (!byId.isPresent()) throw new RuntimeException("User does not exists!");
            PreparedStatement stm = connection.prepareStatement("UPDATE staff SET first_name=?, last_name=?, dob=?, address=?, email=?, role=? WHERE staff_id=?");
            stm.setString(1, entity.getFirstName());
            stm.setString(2, entity.getLastName());
            stm.setDate(3, new Date(entity.getDob().getTime()));
            stm.setString(4, entity.getAddress());
            stm.setString(5, entity.getEmail());
            stm.setString(6, entity.getRole());
            stm.setInt(7, entity.getStaffId());

            int i = stm.executeUpdate();
            if (i != 1) {
                throw new DatabaseOperationFailException("Staff Member Update Failed!");
            }

            return this.findById(entity.getStaffId()).get();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<StaffDAO> findById(Integer pk) {
        try {
            ResultSet rst = connection.createStatement().executeQuery("SELECT * FROM staff WHERE staff_id=".concat(String.valueOf(pk)));
            if (rst.next()) {
                return Optional.of(new StaffDAO(rst.getInt("staff_id"), rst.getString("first_name"),
                        rst.getString("last_name"), rst.getDate("dob"), rst.getString("address"),
                        rst.getString("email"), rst.getString("role"), rst.getString("username"), rst.getString("password")));
            }

            throw new DatabaseOperationFailException("No Records Found for Staff Id : ".concat(String.valueOf(pk)));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer pk) {
        try {
            connection.createStatement().execute("DELETE FROM staff WHERE staff_id=".concat(String.valueOf(pk)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StaffDAO updateById(StaffDAO entity) {
        return null;
    }

    @Override
    public List<StaffDAO> findAll() {

        try {

            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM staff");
            if (!resultSet.next()) {
                throw new DatabaseOperationFailException("No Data Found!");
            }
            ArrayList<StaffDAO> staffList = new ArrayList<>();
            do {
                staffList.add(new StaffDAO(resultSet.getInt("staff_id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getDate("dob"),
                        resultSet.getString("address"), resultSet.getString("email"), resultSet.getString("role"), resultSet.getString("username"), resultSet.getString("password")));
            } while (resultSet.next());

            return staffList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
