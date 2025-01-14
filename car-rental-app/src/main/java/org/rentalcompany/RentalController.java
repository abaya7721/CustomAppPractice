package org.rentalcompany;

import java.util.ArrayList;
import java.util.List;

public class RentalController{

    private ConsoleIO io = new ConsoleIO();
    private Customer customer;
    private Vehicle vehicle;
    private List<Vehicle> vehicles;

    public RentalController () {
        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(113, "ranger"));
        vehicles.add(new Vehicle(212, "explorer"));
        vehicles.add(new Vehicle(124, "explorer"));
    }


    public void executeRentalApp(){

        boolean running = true;

        while (running) {
            io.displayMenu();
            int menuSelect = io.menuSelection();
            switch(menuSelect) {
                case 1:
                    //rentVehicle();
                    System.out.println(1);
                    break;
                case 2:
                    //returnVehicle(vehicle);
                case 3:
                    viewAvailableVehicles(vehicles);
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

    public void rentVehicle(Vehicle vehicle) {

    }


    public void returnVehicle(Vehicle vehicle) {

    }


    public void viewAvailableVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            io.displayMessage(vehicle.toString());
        }
    }
}
