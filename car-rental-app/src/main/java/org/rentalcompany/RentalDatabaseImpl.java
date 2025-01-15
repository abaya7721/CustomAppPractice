package org.rentalcompany;

import org.rentalcompany.model.Customer;
import org.rentalcompany.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RentalDatabaseImpl implements RentalDatabase{

    private Map customers;
    private Map vehicles;

    public RentalDatabaseImpl() {
        customers = new HashMap<>();
        vehicles = new HashMap<>();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleId(), vehicle);
    }

    @Override
    public Map<Integer, ArrayList<Vehicle>> getVehicles() {
        return Map.of();
    }

    @Override
    public Map<Integer, ArrayList<Customer>> getCustomers() {
        return Map.of();
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
