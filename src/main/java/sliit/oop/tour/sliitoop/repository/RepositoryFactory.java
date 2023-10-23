package sliit.oop.tour.sliitoop.repository;

import sliit.oop.tour.sliitoop.repository.Impl.StaffRepositoryImpl;
import sliit.oop.tour.sliitoop.repository.Impl.TourRepositoryImpl;

/**
* @author Dulanga Wimalagunasekara
 * Singleton, Generic repository factory to create instances of the repository classes
 * by implementing Factory design pattern
 *
* */
public class RepositoryFactory {
    private static RepositoryFactory serviceFactory;

    private RepositoryFactory(){}

    public static RepositoryFactory getInstance(){
        return (serviceFactory==null)? (serviceFactory=new RepositoryFactory()) :serviceFactory;
    }

    public <T extends SuperRepository> T getRepository(repositoryTypes repositoryTypes){
        switch (repositoryTypes){
            case TOUR:
                return (T) new TourRepositoryImpl();
            case STAFF:
                return (T) new StaffRepositoryImpl();

            default:
                return null;
        }
    }

    public enum repositoryTypes {
        TOUR, STAFF
    }
}

