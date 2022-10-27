package model;

import org.json.JSONObject;

public class Booties extends Equipment {
    private Type type;
    private Sizes size;

    // the types of booties available
    public enum Type {
        MENS, WOMENS, KIDS
    }


    public enum Sizes {
        XS, S, M, L, XL
    }

    // The constructor
    public Booties(Type type, Sizes size) {
        this.type = type;
        this.size = size;

    }

    public String getCategory() {
        return "Booties";
    }

    public Sizes getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    @Override
// Method to help ui print names instead of objects
    public String toString() {
        return "Booties(Category =" + getType() + ", Size=" + getSize() + ")";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Category", getCategory());
        json.put("Type", getType().toString());
        json.put("Size", getSize().toString());
        return json;
    }
}
