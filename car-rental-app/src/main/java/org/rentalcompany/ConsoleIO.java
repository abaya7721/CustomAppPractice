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
        String selection = scanner.next();
        int intSelect = 0;
        try {
            intSelect = Integer.parseInt(selection);
        } catch (Exception e) {
            displayMessage("Invalid input");
        }
        return intSelect;
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
