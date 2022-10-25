package model;


public class Original extends Surfboard {
    private int size;
    public static final int[] SIZES = {9,8,7,6,5};




    public Original(int size) {
        super(size);
    }

    @Override

    public String toString() {
        return "Original Surfboard(length=" + size + ")";
    }
}
