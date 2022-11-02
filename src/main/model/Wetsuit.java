package model;

import org.json.JSONObject;

public class Wetsuit extends Equipment {
    private Wetsuit.Type type;
    private Wetsuit.Sizes size;


    public enum Type {
        MENS, WOMENS, KIDS
    }

    public enum Sizes {
        XS, S, M, L, XL
    }

    //The constructor
    public Wetsuit(Type type, Sizes size) {
        this.type = type;
        this.size = size;

    }

    @Override
    public String getCategory() {
        return "Wetsuit";
    }

    @Override
    public String getSize() {
        return size.toString();
    }

    @Override
    public String getType() {
        return type.toString();
    }

    @Override
// Method to help ui print names instead of objects
    public String toString() {
        return "Wetsuit(Category =" + getType() + ", Size=" + getSize() + ")";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Category", getCategory());
        json.put("Type", getType());
        json.put("Size", getSize());
        return json;
    }
}
