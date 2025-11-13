package com.pluralsight.models;
import com.pluralsight.ui.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich extends MenuItem{

    private int size;
    private String breadType;
    private boolean isToasted;
    private int quantity;
    //made theses properties into lists because there is more than one value
    private List<Toppings> toppings = new ArrayList<>();

    //constructor
    public Sandwich() {
        super("Sandwich");
        //NOTE: Only the name property was set in the constructor because the rest of the sandwich properties
        //will be set by user input
    }

    //constructor for potential signature sandwiches
    public Sandwich(String name, int size, String breadType, boolean isToasted, int quantity, List<Toppings> toppings) {
        super("Sandwich");
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.quantity = quantity;
        this.toppings = toppings;
    }

    //sandwich price calculation
    @Override
    public double calculatePrice(){
        double sandwichPrice = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
        //add topping price
        double toppingTotal = toppings.stream()
                .mapToDouble(t -> t.toppingPrice(size))//this method extracts the topping price of each topping added
                .sum();
        //return total price
        return (sandwichPrice + toppingTotal) * quantity;
    }

    //this method adds topping by category
    private void addToppingByType (ToppingType type){
        //create stream that goes through all toppings
        List<ToppingOption> options = List.of(ToppingOption.values()).stream() //TODO: REVIEW
                .filter(t -> t.getType() == type)
                .toList();

        for(ToppingOption option : options){
            String input = Menu.prompt(String.format("Add %s (y/n)", option.getName()));
            //MISTAKE: Was only able to pass one parameter, so I had to use the String.format method
            //instead of the concat I had before
            if(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")){
                boolean extra = false;
                if(option.isPremium()){
                    String extraInput = Menu.prompt(String.format("Add extra %s? (y/n)", option.getName()));
                    extra = extraInput.equalsIgnoreCase("yes") || extraInput.equalsIgnoreCase("y");
                    //MISTAKE: forgot to update my EXTRA variable from the extraInput prompt, it kept EXTRA as false regardless if input was yes
                }
                toppings.add(new Toppings(extra, option));
            }
        }
    }
    //setters/getters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
