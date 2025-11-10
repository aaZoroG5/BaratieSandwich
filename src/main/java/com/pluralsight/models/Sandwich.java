package com.pluralsight.models;

import java.util.List;

public class Sandwich extends MenuItem{

    private int size;
    private String breadType;
    private boolean toast;
    private int quantity;

    public Sandwich(String name, double price, int size, String breadType, boolean toast, int quantity) {
        super(name, price);
        this.size = size;
        this.breadType = breadType;
        this.toast = toast;
        this.quantity = quantity;
    }

    @Override
    public double calculatePrice(){
        return this.getPrice() * this.quantity;
    }



}
