package sliit.oop.tour.sliitoop.service;

import sliit.oop.tour.sliitoop.dao.TourDAO;

public interface TourService extends SuperService{
    TourDAO saveTour(TourDAO tourDTO);

}
