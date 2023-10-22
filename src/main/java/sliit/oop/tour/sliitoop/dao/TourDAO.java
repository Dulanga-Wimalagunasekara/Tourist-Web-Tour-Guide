package sliit.oop.tour.sliitoop.dao;

public class TourDAO implements SuperDAO {
    private String name;
    private String district;
    private String booking;

    public TourDAO(String name) {
        this.name = name;
    }

    public TourDAO(String name, String district, String booking) {
        this.name = name;
        this.district = district;
        this.booking = booking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "TourDTO{" +
                "name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", booking='" + booking + '\'' +
                '}';
    }

}
