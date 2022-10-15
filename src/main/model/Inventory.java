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
    //MODIFIES: inStock, this
    //EFFECTS: adds a piece of equipment to the stock
    public void addEquipment(Equipment equipment) {
//stub;

    }
    //REQUIRES:
    //MODIFIES: rented and stock
    //EFFECTS:  adds the equipment on the list to the rented list and removes it from  the inStock
    //addAll removeAll
    public void rentEquipment(ArrayList<Equipment> items){
        //stub;
        return null;

    }

    //EFFECTS: if the item is in stock it will return true and false if it is not.
    public boolean inStock?(Equipment piece){
        //stub;
        return false;
    }




}
