package model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Equipment> stock;
    private ArrayList<Equipment> rented;


    public Inventory() {
        ArrayList<Equipment> stock = new ArrayList<Equipment>();
        ArrayList<Equipment> rented = new ArrayList<Equipment>();
    }

    public ArrayList<Equipment> getStock() {
        return stock;
    }

    public ArrayList<Equipment> getRented() {
        return rented;
    }

    public void setRented(ArrayList<Equipment> rented) {
        this.rented = rented;
    }

    public void setStock(ArrayList<Equipment> stock) {
        this.stock = stock;
    }

    //MODIFIES: stock, this
    //EFFECTS: adds a piece of equipment to the stock
    public void addEquipment(Equipment equipment) {
//stub;

    }

    //REQUIRES:
    //MODIFIES: rented or stock
    //EFFECTS:  removes a piece of equipment from rented or stock
    //addAll removeAll
    public void removeEquipment(ArrayList<Equipment> items) {
        //stub;

    }

    //EFFECTS: if the item is in stock it will return true and false if it is not.
    public boolean inStock(Equipment piece) {
        //stub;
        return false;
    }

    //REQUIRES:
    //MODIFIES: rented and stock
    //EFFECTS:  removes a piece of equipment from rented or stock
    public void rentEquipment(ArrayList<Equipment> items) {
    }

    //EFFECTS: Gives the price of all the items and the time that
    public int getPrice(ArrayList<Equipment> items, int time) {
        return 0;
    }


}
