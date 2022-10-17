package model;

public class SoftTop extends Surfboard {
    private int size;
    public static final int[] SIZES;

    static {
        SIZES = new int[]{10, 9, 8, 7};
    }

    public SoftTop(int size) {

        super(size);
    }

}


