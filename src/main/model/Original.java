package model;

import org.json.JSONObject;

//A specific type of surfboard
public class Original extends Surfboard {
    private int size;
    //public static final int[] SIZES = {9,8,7,6,5};


    //Constructor
    public Original(int size) {
        this.size = size;
    }

    @Override
    public String getSize() {
        return Integer.toString(size);
    }

    @Override
    public String getType() {
        return "Original";
    }

    @Override
    public String getCategory() {
        return "Surfboard";
    }

    @Override
// Method to help ui print names instead of objects
    public String toString() {
        return "Original Surfboard(length=" + size + ")";
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
