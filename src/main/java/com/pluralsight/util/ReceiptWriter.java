package com.pluralsight.util;

import com.pluralsight.models.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReceiptWriter {

    //this method creates a receipt for our order
    public static void writeReceipt(Order order) {

        //names the file by using the current time
        String fileName = "receipt_" + System.currentTimeMillis() + ".txt";

        //create buffered write and file writer
        try {
            BufferedWriter writer = new BufferedWriter((new FileWriter(fileName)));

            //create the heading for the receipt
            writer.write("========= Baratie Sandwich Shop Receipt =========");
            writer.newLine();
            writer.write("Date: " + LocalDateTime.now());
            writer.newLine();
            writer.write("Items: ");
            writer.newLine();

            //loop through items that have been added to the customer order
            for (MenuItem item : order.getOrderItems()) {
                //use instanceOf to check if item is a sandwich child class
                if (item instanceof Sandwich s) {
                    //if true, get sandwich properties and format
                    writer.write(s.getQuantity() + "x " +
                            s.getSize() + "\" Sandwich on " + s.getBreadType() +
                            (s.isToasted() ? " (Toasted)" : ""));
                    writer.newLine();

                    //toppings
                    //create for each loop that gets all topping of the sandwich
                    for(Toppings t : s.getToppings()){
                        writer.write("  - " + t.getOption().getName() +
                                (t.isExtra() ? " (extra)" : ""));
                        writer.newLine();
                    }
                    //display total for sandwich
                    writer.write(String.format("  Subtotal: $%.2f", s.calculatePrice()));
                    writer.newLine();
                    writer.newLine();
                }
                //use instanceOf to check if item is a drinks child class
                else if (item instanceof Drinks d) {
                    writer.write("1x " + d.getSize() + " Drink - " + d.getFlavor());
                    writer.newLine();
                    writer.write(String.format("  Price: $%.2f", d.calculatePrice()));
                    writer.newLine();
                    writer.newLine();
                }
                //use instanceOf to check if item is a Chips child class
                else if (item instanceof Chips c) {
                    writer.write("1x Chips - " + c.getFlavor());
                    writer.newLine();
                    writer.write(String.format("  Price: $%.2f", c.calculatePrice()));
                    writer.newLine();
                    writer.newLine();
                }
            }

            //totals
            double subtotal = order.calculateTotal();
            double tax = subtotal * 0.05;
            double total = subtotal + tax;

            writer.write("=============================");
            writer.newLine();
            writer.write(String.format("Subtotal: $%.2f", subtotal));
            writer.newLine();
            writer.write(String.format("Tax:      $%.2f", tax));
            writer.newLine();
            writer.write(String.format("Total:    $%.2f", total));
            writer.newLine();
            writer.write("=============================");
            writer.newLine();
            writer.newLine();
            writer.write("Thank you for visiting Baratie!");
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
