package com.pluralsight.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final List<MenuOption> options = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    //this methods displays the homeScreen
    public void homeScreen(){
        boolean running = true;

        while (running) {
            System.out.println("\n=== Baratie Sandwich ===\n");

            // Display numbered options
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ") " + options.get(i).getLabel());
            }
            System.out.println("0) Go Back");

            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                running = false;  //exit menu
            }
        }
    }
    //reusable prompt helper
    public static String prompt(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine().trim();
    }
}
