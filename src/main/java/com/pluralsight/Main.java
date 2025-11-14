package com.pluralsight;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drinks;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import com.pluralsight.ui.Menu;
import com.pluralsight.util.ReceiptWriter;

public class Main {

    public static void main(String[] args) {

        //create a homeMenu screen
        Menu homeMenu = new Menu();
        //create an orderMenu screen
        Menu orderMenu = new Menu();

        Order currentOrder = new Order();

        //build the order screen
        orderMenu.addOption("Add Sandwich", () -> {
            Sandwich s = new Sandwich();//create object
            s.customerInput();//take customer input for empty object
            currentOrder.addItem(s);//add the customized item
        });

        orderMenu.addOption("Add Drink", () -> {
            Drinks d = new Drinks("Drink");
            d.customerInput();
            currentOrder.addItem(d);
        });

        orderMenu.addOption("Add Chips", () -> {
            Chips c = new Chips("Chips");
            c.customerInput();
            currentOrder.addItem(c);
        });

        orderMenu.addOption("Checkout", () -> {
            currentOrder.orderSummary();
            ReceiptWriter.writeReceipt(currentOrder);//creates receipt after you checkout
        });

        //build home screen
        homeMenu.addOption("Start New Order", orderMenu::homeScreen); //TODO REVIEW
        //show home menu
        homeMenu.homeScreen();

    }
}
