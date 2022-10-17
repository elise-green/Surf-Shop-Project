package model;

import java.util.ArrayList;

public class Wetsuit extends Equipment {
    public Type type;
    public Sizes size;


    public enum Type {
        MENS, WOMENS, KIDS
    }

    public enum Sizes {
        XS, S, M, L, XL
    }

    public Wetsuit(Type type, Sizes size) {
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
