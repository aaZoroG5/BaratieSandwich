package com.pluralsight.models;

public enum ToppingOption {

    //Meat Options
    STEAK("Steak", ToppingType.MEAT, true),
    HAM("Ham", ToppingType.MEAT, true),
    SALAMI("Salami", ToppingType.MEAT, true),
    ROAST_BEEF("Roast beef", ToppingType.MEAT, true),
    CHICKEN("Chicken", ToppingType.MEAT, true),
    BACON("Bacon", ToppingType.MEAT, true),

    //Cheeses
    AMERICAN("American", ToppingType.CHEESE, true),
    PROVOLONE("Provolone", ToppingType.CHEESE, true),
    CHEDDAR("Cheddar", ToppingType.CHEESE, true),
    SWISS("Swiss", ToppingType.CHEESE, true),

    //Regular Toppings
    LETTUCE("Lettuce", ToppingType.REGULAR, false),
    PEPPERS("Peppers", ToppingType.REGULAR, false),
    ONIONS("Onions", ToppingType.REGULAR, false),
    TOMATOES("Tomatoes", ToppingType.REGULAR, false),
    JALAPENOS("Jalapenos", ToppingType.REGULAR, false),
    CUCUMBERS("Cucumbers", ToppingType.REGULAR, false),
    PICKLES("Pickles", ToppingType.REGULAR, false),
    GUACAMOLE("Guacamole", ToppingType.REGULAR, false),
    MUSHROOMS("Mushrooms", ToppingType.REGULAR, false),

    MAYO("Mayo", ToppingType.REGULAR, false),
    MUSTARD("Mustard", ToppingType.REGULAR, false),
    KETCHUP("Ketchup", ToppingType.REGULAR, false),
    RANCH("Ranch", ToppingType.REGULAR, false),
    THOUSAND_ISLANDS("Thousand Islands", ToppingType.REGULAR, false),
    VINAIGRETTE("Vinaigrette", ToppingType.REGULAR, false);

    //enum properties
    //NOTE: The constants above have to be written first BEFORE any properties or constructors
    private final String name;
    private final ToppingType type;
    private final boolean premium;

    //enum constructor
    ToppingOption(String name, ToppingType type, boolean premium) {
        this.name = name;
        this.type = type;
        this.premium = premium;
    }

    //getters
    public String getName() {
        return name;
    }

    public ToppingType getType() {
        return type;
    }

    public boolean isPremium() {
        return premium;
    }
}
