package com.pluralsight.models;

public abstract class MenuItem {

    //properties
    private String name;
    private double price;

    //constructor
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //made an abstract method so child classes have their individual calculations
    public abstract double calculatePrice();

    //getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
