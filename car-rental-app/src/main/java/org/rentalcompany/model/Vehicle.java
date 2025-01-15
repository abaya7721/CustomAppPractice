package org.rentalcompany.model;

public class Vehicle {

    private Integer vehicleId;
    private int rentedCustomer;
    private boolean isRented;
    private String model;

    public Vehicle(Integer vehicleId, String model) {
        this.vehicleId = vehicleId;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public Integer getRentedCustomer() {
        return rentedCustomer;
    }

    public void setRentedCustomer(Integer rentedCustomer) {
        this.rentedCustomer = rentedCustomer;
    }

    public int getVehicleId() {
        return vehicleId;
    }

//    public Vehicle getVehicle() {
//        return Vehicle;
//    }

//    public void setVehicleId(int vehicleId) {
//        this.vehicleId = vehicleId;
//    }

    @Override
    public String toString() {
        return " Model: " + model;
    }
}
