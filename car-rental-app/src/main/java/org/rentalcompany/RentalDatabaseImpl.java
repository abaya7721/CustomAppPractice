package org.rentalcompany;

import org.rentalcompany.model.Customer;
import org.rentalcompany.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RentalDatabaseImpl implements RentalDatabase{

    private Map<Integer, Customer> customers;
    private Map<Integer, Vehicle> vehicles;
    private Map<Integer, Vehicle> rentedVehicles;

    public RentalDatabaseImpl() {
        customers = new HashMap<>();
        vehicles = new HashMap<>();
        rentedVehicles = new HashMap<>();
    }

   /* @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }*/

    @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleId(), vehicle);
    }

    @Override
    public Map<Integer, Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public Map<Integer, Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void getVehicleList() {
        for (Map.Entry<Integer, Vehicle> vehiclesMap : vehicles.entrySet()) {
            System.out.println("ID: " + vehiclesMap.getKey() + " , " + vehiclesMap.getValue().toString());
        }
    }

    public void getRentedVehicleList() {
        for (Map.Entry<Integer, Vehicle> vehiclesMap : rentedVehicles.entrySet()) {
            System.out.println("Vehicle " + vehiclesMap.getKey() + " rented by " + rentedVehicles.get(vehiclesMap.getKey()).getRentedCustomer());
        }
    }

    public void getCustomerList() {
        for (Map.Entry<Integer, Customer> customerEntryMap : customers.entrySet()) {
            System.out.println("ID: " + customerEntryMap.getKey() + " , Last Name: " + customerEntryMap.getValue().toString());
        }
    }

    // Have to specify the Map with exact data type for Key and Value
    public Vehicle getSingleVehicle(Map<Integer, Vehicle> vehicles, Integer id) {
        return vehicles.get(id);
    }

    public Customer getSingleCustomer(int id) {
        return customers.get(id);
    }

    @Override
    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
