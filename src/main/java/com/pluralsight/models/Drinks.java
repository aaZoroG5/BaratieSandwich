package com.pluralsight.models;

import java.util.List;

public class Drinks extends Order{

    private String flavor;
    private String size;
    private int quantity;

    public Drinks(double price, List<Order> orderItems, String flavor, String size, int quantity) {
        super(price, orderItems);
        this.flavor = flavor;
        this.size = size;
        this.quantity = quantity;
    }


}
