package sliit.oop.tour.sliitoop.service.Impl;

import sliit.oop.tour.sliitoop.dao.TourDAO;
import sliit.oop.tour.sliitoop.repository.RepositoryFactory;
import sliit.oop.tour.sliitoop.repository.TourRepository;
import sliit.oop.tour.sliitoop.service.TourService;

public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    public TourServiceImpl() {
        this.tourRepository = RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryTypes.TOUR);
    }

    @Override
    public TourDAO saveTour(TourDAO tourDTO) {
        return tourRepository.save(tourDTO);
    }

}
