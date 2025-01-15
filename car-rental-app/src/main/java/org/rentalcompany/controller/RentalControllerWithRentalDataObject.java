package org.rentalcompany.controller;

import org.rentalcompany.RentalDatabase;
import org.rentalcompany.model.Customer;
import org.rentalcompany.model.Vehicle;
import org.rentalcompany.view.ConsoleIO;

import java.util.ArrayList;
import java.util.List;
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
        // initializing customers list to add customers when information is collected
        customers = new ArrayList<>();
        rentedVehicles = new ArrayList<>();

        // adding vehicle data to test app functionality
        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(113, "Ranger"));
        vehicles.add(new Vehicle(212, "Explorer"));
        vehicles.add(new Vehicle(124, "Malibu"));

        customers.add(new Customer("Mac", 1));

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
                    //enterCustomerInformation();
                    rentVehicle(enterCustomerInformationAlternate());
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

    public Customer enterCustomerInformationAlternate() {
        Customer customer1 = new Customer("", 0);

        io.displayMessage("Customer Listing");
        rentData.getCustomerList();

        io.displayMessage("Enter Customer Information -------");
        String lastName = io.getString("Enter Last Name");
        int customerId = io.getInt("Enter Customer ID Number");

        /*customer1.setCustomerId(customerId);
        customer1.setLastName(lastName);*/

        if(rentData.getCustomers().containsKey(customerId)) {
            io.displayMessage("Existing Customer");
            //customerId = customerId;
        }
        else { rentData.addCustomer(new Customer(lastName, customerId));
        }
        customer1 = rentData.getCustomers().get(customerId);

        return customer1;
        //customers.add(customer);
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
