package org.rentalcompany;

import java.util.ArrayList;
import java.util.List;

public class RentalController{

    private ConsoleIO io = new ConsoleIO();
    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private Customer customer;
    private List<Vehicle> rentedVehicles;
    private Vehicle vehicle;

    public RentalController () {
        // initializing customers list to add customers when information is collected
        customers = new ArrayList<>();
        rentedVehicles = new ArrayList<>();

        // adding vehicle data to test app functionality
        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(113, "Ranger"));
        vehicles.add(new Vehicle(212, "Explorer"));
        vehicles.add(new Vehicle(124, "Malibu"));

    }

    public void executeRentalApp(){

        boolean running = true;

        while (running) {
            io.displayMenu();
            int menuSelect = io.menuSelection();
            switch(menuSelect) {
                case 1:
                    enterCustomerInformation();
                    rentVehicle(getCustomer());
                    break;
                case 2:
                    returnVehicle();
                case 3:
                    viewAvailableVehicles();
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

    public void enterCustomerInformation() {
        customer = new Customer();

        io.displayMessage("Enter Customer Information");
        String lastName = io.getString("Enter Last Name");
        int customerId = io.getInt("Enter Customer ID Number");

        customer.setCustomerId(customerId);
        customer.setLastName(lastName);
        customers.add(customer);
    }



    public Customer getCustomer() {
        //int index = customers.indexOf(customer);
        return customers.getLast();
    }

    public void rentVehicle(Customer customer) {

        if (vehicles.size() > 0) {
            viewAvailableVehicles();
            io.displayMessage("Select a vehicle - Enter corresponding ID");
            int vehicleId = io.getInt("");
                vehicle = checkIfVehicleIsInList(vehicles, vehicleId);
                if (vehicle != null) {
                    vehicle.setRented(true);
                    vehicles.remove(vehicle);
                    rentedVehicles.add(vehicle);
                    vehicle.setRentedCustomer(customer.getCustomerId());
                    io.displayMessage(vehicle.getModel() + " rented by " + customer.getLastName());
                }
                else { io.displayMessage("Error occurred with vehicle id, vehicle not rented."); }
            }
        else { io.displayMessage("No Vehicles Available"); }
    }


    public void returnVehicle() {
        showRentedVehiclesInformation();
        int id = io.getInt("Enter vehicle ID to return");
        vehicle = checkIfVehicleIsInList(rentedVehicles, id);

        if (vehicle != null) {
            vehicle.setRented(false);
            vehicles.add(vehicle);
            rentedVehicles.remove(vehicle);
            vehicle.setRentedCustomer(0);
            io.displayMessage("Return Successful");
        }
        else { io.displayMessage("Error occurred with vehicle id, vehicle not returned."); }
    }

    public void viewAvailableVehicles() {
        io.displayMessage("----Vehicles----");
        if(vehicles.size() == 0) { io.displayMessage("Sold Out"); }
        for (Vehicle vehicle : vehicles) {
            io.displayMessage(vehicle.toString());
        }
    }

    public Vehicle checkIfVehicleIsInList(List<Vehicle> vehicles, int vehicleId){
            Vehicle getVehicle = null;
            if (vehicles.size() > 0) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getVehicleId() == vehicleId) {
                        getVehicle = vehicle;
                        break;
                        }
                    }
                }
            else {io.displayMessage("Vehicle Not Found"); }
        return getVehicle;
    }

    public void showRentedVehiclesInformation (){
        if (!rentedVehicles.isEmpty()){
        for (Vehicle vehicle : rentedVehicles) {
                System.out.println("Vehicle " + vehicle.getVehicleId() + " rented out by customer " + vehicle.getRentedCustomer());
            }
        }
    }



}
