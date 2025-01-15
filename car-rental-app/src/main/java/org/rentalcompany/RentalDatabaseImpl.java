package org.rentalcompany;

import org.rentalcompany.model.Customer;
import org.rentalcompany.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RentalDatabaseImpl implements RentalDatabase{

    private Map<Integer, Customer> customers;
    private Map<Integer, Vehicle> vehicles;

    public RentalDatabaseImpl() {
        customers = new HashMap<>();
        vehicles = new HashMap<>();
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

    public void getVehicleList() {
        for (Map.Entry<Integer, Vehicle> vehiclesMap : vehicles.entrySet()) {
            System.out.println("ID: " + vehiclesMap.getKey() + " , Vehicle: " + vehiclesMap.getValue());
        }
    }

    public void getCustomerList() {
        for (Map.Entry<Integer, Customer> customerEntryMap : customers.entrySet()) {
            System.out.println("ID: " + customerEntryMap.getKey() + " , Last Name: " + customerEntryMap.getValue().toString());
        }
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
