package sliit.oop.tour.sliitoop.service;

import sliit.oop.tour.sliitoop.service.Impl.TourServiceImpl;

/**
* @author Dulanga Wimalagunasekara
 * Singleton service factroy to create instances of the service classes
 * by implement Factory design pattern
 *
* */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return (serviceFactory==null)? (serviceFactory=new ServiceFactory()) :serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceTypes serviceType){
        switch (serviceType){
            case TOUR:
                return (T) new TourServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceTypes{
        TOUR
    }
}

