package com.pluralsight.models;

import java.util.List;

public class Chips extends MenuItem{

    private String flavor;
    private int quantity;

    public Chips(String name, double price, String flavor, int quantity) {
        super(name, price);
        this.flavor = flavor;
        this.quantity = quantity;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
