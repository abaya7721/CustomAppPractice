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
    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private Customer customer;
    private List<Vehicle> rentedVehicles;
    private Vehicle vehicle;

    // --------------- refactored code below
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

    public Customer enterCustomerInformationAlt() {
        Customer customer1 = new Customer("", 0);
        io.displayMessage("Customer Listing");
        for (Customer customer : customers) { io.displayMessage(customer.getLastName()+" " +customer.getCustomerId());}

        io.displayMessage("Enter Customer Information -------");
        String lastName = io.getString("Enter Last Name");
        int customerId = io.getInt("Enter Customer ID Number");

        customer1.setCustomerId(customerId);
        customer1.setLastName(lastName);

        int currentCustomerId = customer1.getCustomerId();
        if(customers.stream().anyMatch(customer -> Objects.equals(customer.getCustomerId(), currentCustomerId))) {
                io.displayMessage("Existing Customer");
            }
        else { customers.add(customer1); }

        return customer1;
        //customers.add(customer);
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
                int vehicleId = io.getInt("");
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

            int id = io.getInt("Enter vehicle ID to return");
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

        /*if(vehicles.size() == 0) { io.displayMessage("Sold Out"); }
        for (Vehicle vehicle : vehicles) {
            io.displayMessage(vehicle.toString());
        }*/
    }

    public Vehicle checkIfVehicleIsInList(Map vehicles, int vehicleId){
            Vehicle getVehicle = null;

            if (vehicles.size() > 0) {
                if(vehicles.containsKey(vehicleId)) {
                    getVehicle = rentData.getSingleVehicle(vehicleId);
                }
            }
            else {io.displayMessage("Vehicle Not Found"); }
        return getVehicle;
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
