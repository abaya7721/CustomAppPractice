package org.rentalcompany;

import org.rentalcompany.controller.RentalController;
import org.rentalcompany.controller.RentalControllerWithRentalDataObject;

public class App {

    public static void main(String[] args) {
        RentalController controller = new RentalController();
        RentalDatabase rentalData = RentalDataFactory.generateData();
        RentalControllerWithRentalDataObject controller2 = new RentalControllerWithRentalDataObject(rentalData);
        controller2.executeRentalApp();
    }
}

