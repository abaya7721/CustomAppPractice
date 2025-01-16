package org.rentalcompany;

import org.rentalcompany.controller.RentalController;
import org.rentalcompany.controller.RentalControllerWithRentalDataObject;

public class App {

    public static void main(String[] args) {

        RentalDatabase rentalData = RentalDataFactory.generateData();
        RentalControllerWithRentalDataObject controller = new RentalControllerWithRentalDataObject(rentalData);
        controller.executeRentalApp();
    }
}

