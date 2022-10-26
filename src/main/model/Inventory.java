package model;

import java.util.ArrayList;

//
//MODIFIES : Equipment
//EFFECTS: a class to make all the things helps to change the lists of equipment. It stores stock and rented.
//
public class Inventory {
    private ArrayList<Equipment> stock;
    private ArrayList<Equipment> rented;


    public Inventory() {
        stock = new ArrayList<Equipment>();
        rented = new ArrayList<Equipment>();

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
    public void addEquipment(Equipment thing) {
        stock.add(thing);
    }

    //REQUIRES:
    //MODIFIES: rented or stock
    //EFFECTS:  removes a piece of equipment from rented or stock
    //addAll removeAll
    public boolean removeEquipment(Equipment item) {
        if (stock.contains(item)) {
            stock.remove(item);
            return true;
        } else {
            return false;
        }
    }

    //EFFECTS: if the item is in stock it will return true and false if it is not.
    public boolean inStock(Equipment piece) {
        return stock.contains(piece);
    }

    //REQUIRES:
    //MODIFIES: rented and stock
    //EFFECTS:  removes a piece of equipment from rented or stock
    public boolean rentEquipment(ArrayList<Equipment> items) {
        if (stock.containsAll(items)) {
            stock.removeAll(items);
            rented.addAll(items);
            return true;
        }
        return false;
    }

    //EFFECTS: takes a piece of equipment and returns the name of the class as a string
    public String className(Equipment e) {
        if (e.getClass() == SoftTop.class) {
            return "Surfboard";
        } else if (e.getClass() == Original.class) {
            return "Surfboard";
        } else if (e.getClass() == Wetsuit.class) {
            return "Wetsuit";
        }
        return "Booties";
    }


    //EFFECTS: Gives the price of all the items and the time that
    public int getPrice(ArrayList<Equipment> items, int time) {
        int n = 0;
        for (int i = 0; i < items.size(); i++) {
            if (className(items.get(i)) == "Surfboard") {
                n += (Equipment.getSurfboardPrice() * time);
            } else if (className(items.get(i)) == "Wetsuit") {
                n += (Equipment.getWetsuitPrice() * time);
            } else if (className(items.get(i)) == "Booties") {
                n += (Equipment.getBootiePrice() * time);

            }
        }
        return n;
    }
}
