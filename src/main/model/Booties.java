package model;

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

}
