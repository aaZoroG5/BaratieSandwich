package com.pluralsight.models;

//needed to import Menu class because of the static helper prompt() method
//it connects user input
import com.pluralsight.ui.Menu;

public class Chips extends MenuItem{

    //properties
    private String flavor;

    //constructor
    public Chips(String name) {
        super("Chips");
    }

    @Override
    public double calculatePrice() {
        return 1.50;
    }

    //this method asks the user for chip flavor
    public void customerInput(){
        this.flavor = Menu.prompt("Enter chip flavor");
    }
}
