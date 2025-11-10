package com.pluralsight.models;

import java.util.List;

public class Chips extends Order{

    private String flavor;
    private int quantity;

    public Chips(double price, List<Order> orderItems, String flavor, int quantity) {
        super(price, orderItems);
        this.flavor = flavor;
        this.quantity = quantity;
    }

}
