package sliit.oop.tour.sliitoop.service.Impl;

import sliit.oop.tour.sliitoop.dao.TourDAO;
import sliit.oop.tour.sliitoop.repository.TourRepository;
import sliit.oop.tour.sliitoop.service.TourService;

public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;

    @Override
    public TourDAO createTour(TourDAO tourDTO) {
        return tourRepository.save(tourDTO);
    }

}
