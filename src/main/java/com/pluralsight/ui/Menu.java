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
            System.out.println();
            System.out.println("=== Baratie Sandwich ===\n");

            //display numbered options
            for (int i = 0; i < options.size(); i++) { //TODO:REVIEW
                System.out.println((i + 1) + ") " + options.get(i).getLabel());
            }
            System.out.println("0) Exit");

            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                running = false;  //exit menu
            }else {
                try {//parse user input into a number, parsing may throw exception due to invalid input so we try/catch
                    int choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= options.size()) {//determine if input matches with menu option index
                        options.get(choice - 1).getAction().run();//save the menu option and store Runnable action
                    } else {
                        System.out.println("Invalid option");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number");
                }
            }
        }
    }

    //this method helps me add options
    public void addOption(String label, Runnable action) {
        options.add(new MenuOption(label, action));
    }

    //reusable prompt helper
    public static String prompt(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine().trim();
    }
}
