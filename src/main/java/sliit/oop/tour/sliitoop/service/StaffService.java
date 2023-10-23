package sliit.oop.tour.sliitoop.service;

import sliit.oop.tour.sliitoop.dao.StaffDAO;

import java.util.List;

public interface StaffService extends SuperService {
    List<StaffDAO> getAllStaff();
    StaffDAO getUserById(String userId);
    StaffDAO saveStaff(StaffDAO staffDAO);

    void deleteById(Integer id);

}
