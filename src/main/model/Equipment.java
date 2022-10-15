package model;


public class Equipment {
    private static final int SURFBOARD_PRICE = 25;
    private static final int WETSUIT_PRICE = 20;
    private static final int  BOOTIE_PRICE = 10;


    public static int getBootiePrice() {
        return BOOTIE_PRICE;
    }

    public static int getSurfboardPrice() {
        return SURFBOARD_PRICE;
    }

    public static int getWetsuitPrice() {
        return WETSUIT_PRICE;
    }


}
