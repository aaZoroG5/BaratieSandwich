package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<MenuItem> orderItems = new ArrayList<>();

    //this method adds items to the menuItem list
    public void addItem(MenuItem item) {
        orderItems.add(item);
    }
    //NOTE: this method can replace addSandwich(),addDrink()... but cant prompt the user
    //also, this method is easier to maintain since Order holds List<MenuItem>, and MenuItem inherits
    //calculatePrice() in each child class

    public void addSandwich(Sandwich s) {
        addItem(s);
    }

    public void addDrink (Drinks d){
        addItem(d);
    }

    public void addChips(Chips c){
        addItem(c);
    }

    //this method takes the prices of all items and adds them using a stream
    public double calculateTotal(){
        return orderItems.stream()
                .mapToDouble(MenuItem :: calculatePrice)//this method extracts the calculated price of each menu item in the orderitems list
                .sum();
    }

    //this method  prints out the order summary
    public void orderSummary(){
        System.out.println("========= Order Summary =========");
        //create for each loop that prints out all order items
        for(MenuItem item : orderItems){
            System.out.println(item.getName() + " - $" + String.format("%.2f", item.calculatePrice()));
        }
        //print total
        System.out.println("Total: $" + String.format("%.2f", calculateTotal()));
    }

    //getters
    public List<MenuItem> getOrderItems() {
        return orderItems;
    }
}
