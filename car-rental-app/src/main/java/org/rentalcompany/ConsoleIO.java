package org.rentalcompany;

import java.util.Scanner;

public class ConsoleIO {

    public Scanner scanner = new Scanner(System.in);

    public String getString(String prompt) {
        displayMessage(prompt);
        return scanner.next();
    }

    public int getInt(String prompt) {
        displayMessage(prompt);
        return scanner.nextInt();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMenu() {
        displayMessage("");
        displayMessage("------Vehicle Rental Menu---------");
        displayMessage("");
        displayMessage("1. Rent Vehicle");
        displayMessage("2. Return Vehicle");
        displayMessage("3. View Available Vehicles");
        displayMessage("4. Exit");
    }

    public int menuSelection() {
        return getInt("Select an option to continue.");
    }
}
