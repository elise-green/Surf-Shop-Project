package model;

import org.json.JSONObject;

import java.util.Objects;

//A specific type of surfboard
public class Original extends Surfboard {
    private int size;
    //public static final int[] SIZES = {9,8,7,6,5};


    //Constructor
    public Original(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Original original = (Original) o;
        return size == original.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
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
