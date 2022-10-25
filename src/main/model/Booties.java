package model;

public class Booties extends Equipment {
    private Type type;
    private Sizes size;

    public enum Type {
        MENS, WOMENS, KIDS
    }


    public enum Sizes {
        XS, S, M, L, XL
    }

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

    public String toString() {
        return "Booties(Category =" + getType() + ", Size=" + getSize() + ")";
    }

}
