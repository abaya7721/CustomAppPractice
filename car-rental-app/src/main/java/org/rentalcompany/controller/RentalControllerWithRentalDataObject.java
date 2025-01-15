package org.rentalcompany.controller;

import org.rentalcompany.RentalDatabase;
import org.rentalcompany.model.Customer;
import org.rentalcompany.model.Vehicle;
import org.rentalcompany.view.ConsoleIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RentalControllerWithRentalDataObject {

    private ConsoleIO io = new ConsoleIO();
    private List<Customer> customers;
    private Vehicle vehicle;


    RentalDatabase rentData;

    public RentalControllerWithRentalDataObject(RentalDatabase data) {

        // ----------------- refactored code below
        this.rentData = data;
    }

    public void executeRentalApp(){

        boolean running = true;

        while (running) {
            io.displayMenu();
        int menuSelect = io.menuSelection();
            switch(menuSelect) {
                case 1:
                    rentVehicle(enterCustomerInformation());
                    break;
                case 2:
                    returnVehicle();
                case 3:
                    viewAvailableVehicles();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    io.displayMessage("Enter number between 1 and 4.");
            }
        }
    }

    public Customer enterCustomerInformation() {
        Customer currentCustomer;

        io.displayMessage("Customer Listing");
        rentData.getCustomerList();

        io.displayMessage("Enter Customer Information -------");
        String lastName = io.getString("Enter Last Name");
        int customerId = io.getInt("Enter Customer ID Number");

        // checks if customerId is 0 so it doesn't go into proceeding code
        if (customerId != 0) {
            if (rentData.getCustomers().containsKey(customerId)) {
                io.displayMessage("Existing Customer");
            } else {
                rentData.addCustomer(new Customer(lastName, customerId));
            }
            currentCustomer = rentData.getCustomers().get(customerId);
        }
        else {currentCustomer = null;}

        return currentCustomer;
    }

    public void rentVehicle(Customer customer) {
        if (customer != null) {

            if (!rentData.getVehicles().isEmpty()) {
                viewAvailableVehicles();
                io.displayMessage("Select a vehicle - Enter corresponding ID");
                Integer vehicleId = io.getInt("");
                vehicle = checkIfVehicleIsInList(rentData.getVehicles(), vehicleId);

                if (vehicle != null) {
                    vehicle.setRented(true);
                    vehicle.setRentedCustomer(customer.getCustomerId());
                    rentData.getVehicles().remove(vehicleId);
                    rentData.getRentedVehicles().put(vehicle.getVehicleId(), vehicle);

                    io.displayMessage(vehicle.getModel() + " rented by " + customer.getLastName());
                } else {
                    io.displayMessage(">>>>>>> ERROR \n ---- Problem with vehicle id. \n ---- No vehicle not rented.");
                }
            } else {
                io.displayMessage("No Vehicles Available");
            }
        }
            else { io.displayMessage("Invalid entry for customer id. Please retry renting.");}
    }


    public void returnVehicle() {
        boolean returnVehicle = showRentedVehiclesInformation();

        if (returnVehicle) {
            
            Integer id = io.getInt("Enter vehicle ID to return");
            rentData.getRentedVehicleList();
            vehicle = checkIfVehicleIsInList(rentData.getRentedVehicles(), id);

            if (vehicle != null) {
                vehicle.setRented(false);
                vehicle.setRentedCustomer(0);
                rentData.getVehicles().put(id, vehicle);
                rentData.getRentedVehicles().remove(id);
                io.displayMessage("Return Successful");
            } else {
                io.displayMessage("Error occurred with vehicle id, vehicle not returned.");
            }
        }
         else { io.displayMessage(""); } ;

    }

    public void viewAvailableVehicles() {
        io.displayMessage("----Vehicles----");
        if(rentData.getVehicles().isEmpty()) { io.displayMessage("Sold Out"); }
        else { rentData.getVehicleList();}
    }

    public Vehicle checkIfVehicleIsInList(Map<Integer, Vehicle> vehicles, Integer vehicleId){

            if (vehicles.size() > 0) {
                if(vehicles.containsKey(vehicleId)) {
                    // found problem - this method was only looking in the un-rented vehicle when it should be looking in rented vehicles during return method
                    vehicle = rentData.getSingleVehicle(vehicles, vehicleId);
                }
            }
            else {io.displayMessage("Vehicle Not Found"); vehicle = null;}
        return vehicle;
    }

    public boolean showRentedVehiclesInformation (){

        boolean rentedVehiclesExist;
        if (!rentData.getRentedVehicles().isEmpty()){
                rentData.getRentedVehicleList();
                rentedVehiclesExist = true;
            }
        else { io.displayMessage("No vehicles rented out."); rentedVehiclesExist = false; }

        return rentedVehiclesExist;
    }
}
