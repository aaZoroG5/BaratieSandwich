package com.pluralsight.models;

//needed to import Menu class because of the static helper prompt() method
//it connects user input
import com.pluralsight.ui.Menu;

public class Drinks extends MenuItem{

    //properties
    private String flavor;
    private String size;

    //constructor
    public Drinks(String name) {
        super("Drink");
    }

    @Override
    public double calculatePrice() {
        return switch (size.toLowerCase()){
            case "s" -> 2.00;
            case "m" -> 2.50;
            case "l" -> 3.00;
            default -> 0.0;
        };
    }

    //this method asks the user for drink size and flavor
    public void customerInput(){
        this.size = Menu.prompt("Enter drink size ( S, M , L )");
        this.flavor = Menu.prompt("What flavor soda would you like?");
    }
}
