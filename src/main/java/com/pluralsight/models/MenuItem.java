package com.pluralsight.models;

public abstract class MenuItem {

    //properties
    private String name;

    //constructor
    public MenuItem(String name) {
        this.name = name;
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


}
