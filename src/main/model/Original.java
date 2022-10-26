package model;

//A specific type of surfboard
public class Original extends Surfboard {
    private int size;
    //public static final int[] SIZES = {9,8,7,6,5};



//Constructor
    public Original(int size) {
        super(size);
    }

    @Override
// Method to help ui print names instead of objects
    public String toString() {
        return "Original Surfboard(length=" + size + ")";
    }
}
