package org.rentalcompany;


import org.rentalcompany.model.Customer;
import org.rentalcompany.model.Vehicle;

import java.util.ArrayList;
import java.util.Map;

public interface RentalDatabase {
    // use hashmap for customer id as key and last name as value
    // hashmap for vehicle id
    //Map<Object,ArrayList<Object>> multiMap = new HashMap<>();

    Map<Integer, ArrayList<Customer>> getCustomers();
    Map<Integer, ArrayList<Vehicle>> getVehicles();

    void addVehicle(Vehicle vehicle);
    void addCustomer(Customer customer);


}
