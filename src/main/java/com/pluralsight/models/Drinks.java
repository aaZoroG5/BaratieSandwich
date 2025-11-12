package com.pluralsight.models;

import java.util.List;

public class Drinks extends MenuItem{

    private String flavor;
    private String size;
    private int quantity;

    public Drinks(String name, double price, String flavor, String size, int quantity) {
        super(name, price);
        this.flavor = flavor;
        this.size = size;
        this.quantity = quantity;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
