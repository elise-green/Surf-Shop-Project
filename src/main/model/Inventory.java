package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

//
//MODIFIES : Equipment
//EFFECTS: a class to make all the things helps to change the lists of equipment. It stores stock and rented.
//
public class Inventory implements persistence.Writable {
    private ArrayList<Equipment> stock;
    private ArrayList<Equipment> rented;


    public Inventory() {
        stock = new ArrayList<>();
        rented = new ArrayList<>();
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


  /*  public boolean rentEquipment(Equipment e) {
        Boolean d = false;
        int n = 0;
        for (int i = 0; i < stock.size(); i++) {
            if (e.getCategory().equals(stock.get(i).getCategory())) {
                if (e.getType().equals(stock.get(i).getType())) {
                    if (e.getSize().equals(stock.get(i).getSize())) {
                        d = true;
                        n = i;
                        break;
                    }
                }
            }
        }
        if (d) {
            stock.remove(n);
            rented.add(e);
        }
        return d;
    }
*/

    public boolean rentEquipment(Equipment e) {
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).equals(e)) {
                stock.remove(i);
                rented.add(e);
                return true;
            }
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
            if (className(items.get(i)).equals("Surfboard")) {
                n += (Equipment.getSurfboardPrice() * time);
            } else if (Objects.equals(className(items.get(i)), "Wetsuit")) {
                n += (Equipment.getWetsuitPrice() * time);
            } else if (Objects.equals(className(items.get(i)), "Booties")) {
                n += (Equipment.getBootiePrice() * time);

            }
        }
        return n;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("stock", stockToJson());
        json.put("rented", rentedToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray stockToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Equipment e : getStock()) {
            jsonArray.put(e.toJson());
        }

        return jsonArray;
    }

    private JSONArray rentedToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Equipment e : getRented()) {
            jsonArray.put(e.toJson());
        }

        return jsonArray;
    }
}

