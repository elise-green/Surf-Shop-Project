package model;

import java.util.ArrayList;

public class Wetsuit extends Equipment {
    private Type type;
    private Sizes size;


    enum Type {
        MENS, WOMENS, KIDS
    }

    enum Sizes {
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
