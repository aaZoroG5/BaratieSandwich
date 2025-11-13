package com.pluralsight.ui;
//NOTE: I made this helper class to hold the LABEL (what users sees)
// and the ACTION (what code runs depending on choice)
public class MenuOption {

    //properties
    private final String label;     // text shown to the user, "Add sandwich"
    private final Runnable action;  // the method that should run when selected
    //the runnable datatype is a functional interface in Java, similar to the Comparable interface
    //The single abstract method it has is the run() which simplifies runnable tasks

    //constructor
    public MenuOption(String label, Runnable action) {
        this.label = label;
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public Runnable getAction() {
        return action;
    }


}
