package model;

public class Booties extends Equipment {
    private Type type;
    private Sizes size;

    public enum Type {
        MENS, WOMENS, KIDS
    }
    private enum Type {
        MENS, WOMENS, KIDS
    }

    private enum Sizes {
        XS,S,M,L,XL
    }

    public Booties(){
        this.type = type;
        this.size = size;

    }

    public Sizes getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

}
