package model;

// A specific type of surfboard
public class SoftTop extends Surfboard {
    private int size;
   // public static final int[] SIZES;

   // static {
   //     SIZES = new int[]{10, 9, 8, 7};
  //  }

    // Constructor
    public SoftTop(int size) {

        super(size);
    }

    @Override
// Method to help ui print names instead of objects
    public String toString() {
        return "Soft top Surfboard(length=" + size + ")";
    }
}




