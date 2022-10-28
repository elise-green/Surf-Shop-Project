package model;

import org.json.JSONObject;

// A specific type of surfboard
public class SoftTop extends Surfboard {
    private int size;
   // public static final int[] SIZES;

   // static {
   //     SIZES = new int[]{10, 9, 8, 7};
  //  }

    // Constructor
    public SoftTop(int size) {

        super(size);
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return "Soft top";
    }

    public String getCategory() {
        return "Surfboard";
    }

    @Override
// Method to help ui print names instead of objects
    public String toString() {
        return "Soft top Surfboard(length=" + size + ")";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Category", getCategory());
        json.put("Type", getType());
        json.put("Size", Integer.toString(getSize()));
        return json;
    }
}




