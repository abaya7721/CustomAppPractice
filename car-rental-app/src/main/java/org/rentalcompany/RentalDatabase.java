package org.rentalcompany;


import org.rentalcompany.model.Customer;
import org.rentalcompany.model.Vehicle;

import java.util.ArrayList;
import java.util.Map;

public interface RentalDatabase {
    // use hashmap for customer id as key and last name as value
    // hashmap for vehicle id
    //Map<Object,ArrayList<Object>> multiMap = new HashMap<>();

    Map<Integer, Customer> getCustomers();
    Map<Integer, Vehicle> getVehicles();
    void addVehicle(Vehicle vehicle);
    void addCustomer(Customer customer);
    void getCustomerList();
    void getVehicleList();
    Customer getSingleCustomer(int id);
    Vehicle getSingleVehicle(Map<Integer, Vehicle> vehicles, Integer id);
    void getRentedVehicleList();
    Map<Integer, Vehicle> getRentedVehicles();

}
