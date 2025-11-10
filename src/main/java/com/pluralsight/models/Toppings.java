package com.pluralsight.models;

import java.util.List;

public class Toppings extends Order{

    private String topping;
    private String intensity;

    public Toppings(double price, List<Order> orderItems, String topping, String intensity) {
        super(price, orderItems);
        this.topping = topping;
        this.intensity = intensity;
    }

}
