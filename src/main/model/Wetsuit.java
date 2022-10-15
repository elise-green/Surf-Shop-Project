package model;

import java.util.ArrayList;

public class Wetsuit extends Equipment {
    private Type type;
    private Sizes size;


    private enum Type {
        MENS, WOMENS, KIDS
    }

    private enum Sizes {
        XS, S, M, L, XL
    }

    public Wetsuit(){
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
