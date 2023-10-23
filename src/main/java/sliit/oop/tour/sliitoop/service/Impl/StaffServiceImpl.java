package sliit.oop.tour.sliitoop.service.Impl;

import sliit.oop.tour.sliitoop.dao.StaffDAO;
import sliit.oop.tour.sliitoop.repository.RepositoryFactory;
import sliit.oop.tour.sliitoop.repository.StaffRepository;
import sliit.oop.tour.sliitoop.service.StaffService;

import java.util.List;
import java.util.Optional;

public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImpl() {
        staffRepository = RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryTypes.STAFF);
    }

    @Override
    public List<StaffDAO> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public StaffDAO getUserById(String userId) {

        Optional<StaffDAO> staffMember = staffRepository.findById(Integer.valueOf(userId));
        if (staffMember.isPresent()) {
            return staffMember.get();
        }
        throw new RuntimeException("Staff Member Not Found!");

    }

    @Override
    public StaffDAO saveStaff(StaffDAO staffDAO) {
        return staffRepository.save(staffDAO);
    }

    @Override
    public void deleteById(Integer id) {
        staffRepository.deleteById(id);
    }

}
