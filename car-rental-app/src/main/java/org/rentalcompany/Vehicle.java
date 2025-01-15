package org.rentalcompany;

public class Vehicle {

    private int vehicleId;
    private int rentedCustomer;
    private boolean isRented;
    private String model;

    public Vehicle(int vehicleId, String model) {
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

    public int getRentedCustomer() {
        return rentedCustomer;
    }

    public void setRentedCustomer(int rentedCustomer) {
        this.rentedCustomer = rentedCustomer;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "ID: " + vehicleId + "," +
                " Model: = " + model;
    }
}
