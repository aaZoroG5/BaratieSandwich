package com.pluralsight.util;

import com.pluralsight.models.MenuItem;
import com.pluralsight.models.Order;

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


            }
        } catch (IOException e) {
            System.out.println("Error writing reciept: " + e.getMessage());
        }
    }
}
