package sliit.oop.tour.sliitoop.dao;

public class TourDAO implements SuperDAO {

    private int id;
    private String location;
    private int price;
    private int noOfDays;
    private String description;
    private int noOfPax;

    public TourDAO(int id, String location, int price, int noOfDays, String description, int noOfPax) {
        this.id = id;
        this.location = location;
        this.price = price;
        this.noOfDays = noOfDays;
        this.description = description;
        this.noOfPax = noOfPax;
    }

    public TourDAO(String location, int price, int noOfDays, String description, int noOfPax) {
        this.location = location;
        this.price = price;
        this.noOfDays = noOfDays;
        this.description = description;
        this.noOfPax = noOfPax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TourDAO() {
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public String getDescription() {
        return description;
    }

    public int getNoOfPax() {
        return noOfPax;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNoOfPax(int noOfPax) {
        this.noOfPax = noOfPax;
    }

    @Override
    public String toString() {
        return "TourDAO{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", noOfDays=" + noOfDays +
                ", description='" + description + '\'' +
                ", noOfPax=" + noOfPax +
                '}';
    }
}
