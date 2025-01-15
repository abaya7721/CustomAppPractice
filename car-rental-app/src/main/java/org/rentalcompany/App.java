package org.rentalcompany;

import org.rentalcompany.controller.RentalController;

public class App {

    public static void main(String[] args) {
        RentalController controller = new RentalController();
        
        controller.executeRentalApp();
    }
}

