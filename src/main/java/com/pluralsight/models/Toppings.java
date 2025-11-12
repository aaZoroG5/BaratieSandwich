package com.pluralsight.models;

import java.util.List;

public class Toppings extends MenuItem{

    private String intensity;

    public Toppings(String name, double price, String topping, String intensity) {
        super(name, price);
        this.intensity = intensity;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
