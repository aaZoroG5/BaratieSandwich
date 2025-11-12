package com.pluralsight.models;
import java.util.ArrayList;
import java.util.List;

public class Sandwich extends MenuItem{

    private int size;
    private String breadType;
    private boolean isToasted;
    private int quantity;
    //made theses properties into lists because there is more than one value
    private List<Toppings> meats;
    private List<Toppings> cheeses;
    private List<Toppings> regToppings;

    //constructor
    public Sandwich(String name, double price, int size, String breadType, boolean isToasted, int quantity, List<Toppings> meats, List<Toppings> cheeses, List<Toppings> regToppings) {
        super(name, price);
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.quantity = quantity;

        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regToppings = new ArrayList<>();
    }

    //sandwich price calculation
    @Override
    public double calculatePrice(){
        double sandwichPrice = 0;
        if(size == 4){
            sandwichPrice = 5.50;
        } else if (size == 8) {
            sandwichPrice = 7.00;
        } else if (size == 12) {
            sandwichPrice = 8.50;
        }
        return sandwichPrice * this.quantity;
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
