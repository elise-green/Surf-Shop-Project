package model;

import org.json.JSONObject;

import java.util.Objects;

// A specific type of surfboard
public class SoftTop extends Surfboard {
    private int size;

    // Constructor
    public SoftTop(int size) {
        this.size = size;
    }

    @Override
    public String getSize() {
        return Integer.toString(size);
    }

    @Override
    public String getType() {
        return "Soft top";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SoftTop softTop = (SoftTop) o;
        return size == softTop.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
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
        json.put("Size", getSize());
        return json;
    }
}




