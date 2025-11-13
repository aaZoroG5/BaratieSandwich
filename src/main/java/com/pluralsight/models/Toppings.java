package com.pluralsight.models;

public class Toppings {

    private boolean extra;
    //add enum property
    private ToppingOption option;

    //constructor
    public Toppings(boolean extra, ToppingOption option) {
        this.extra = extra;
        this.option = option;
    }

    //overloading constructor
    public Toppings(ToppingOption option) {
        this.option = option;
    }

    //This method calculates the topping price
    public double toppingPrice(int size) {
        //check whether the topping it premium, if not then the price is 0
        if (!option.isPremium()) return 0.0;

        //calculate price based on topping type and if its extra
        double cost = 0.0;
        if (option.getType() == ToppingType.MEAT) {
            cost = switch (size) {
                case 4 -> 1.00;
                case 8 -> 2.00;
                case 12 -> 3.00;
                default -> 0.0;
            };
        } else if (option.getType() == ToppingType.CHEESE) {
            cost = switch (size) {
                case 4 -> .75;
                case 8 -> 1.50;
                case 12 -> 2.25;
                default -> 0.0;
            };
        }
        //calculate the price of extra toppings depending if they're MEAT or CHEESE
        if (extra && option.getType() == ToppingType.MEAT) {
            cost += switch (size) {
                case 4 -> .50;
                case 8 -> 1.00;
                case 12 -> 1.50;
                default -> 0.0;
            };
        } else if (extra && option.getType() == ToppingType.CHEESE) {
            cost += switch (size) {
                case 4 -> .30;
                case 8 -> .60;
                case 12 -> .90;
                default -> 0.0;
            };
        }
        return cost;
    }
}
