package org.rentalcompany;

import org.rentalcompany.RentalDatabase;
import org.rentalcompany.model.Customer;
import org.rentalcompany.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class RentalDataFactory {

    // Will use hashmap for customer information and vehicle information
    //
        private static RentalDatabase rentalData = null;

        public static RentalDatabase generateData () {

                rentalData = new RentalDatabaseImpl();

                rentalData.addCustomer(new Customer("customerA", 11 ));
                rentalData.addCustomer(new Customer("customerB", 12));
                rentalData.addCustomer(new Customer("customerC", 13));
                rentalData.addCustomer(new Customer("customerD", 14));

                rentalData.addVehicle(new Vehicle(91, "forte"));
                rentalData.addVehicle(new Vehicle(92, "camaro"));
                rentalData.addVehicle(new Vehicle(93, "sonata"));
                rentalData.addVehicle(new Vehicle(94, "accord"));
                rentalData.addVehicle(new Vehicle(95, "palisade"));

                return rentalData;
        }

}
