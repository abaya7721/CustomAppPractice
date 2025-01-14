package org.rentalcompany;

public class App {

    public static void main(String[] args) {
        //ConsoleIO console = new ConsoleIO();
        RentalController controller = new RentalController();

        //console.displayMenu();
        controller.executeRentalApp();
    }
}

