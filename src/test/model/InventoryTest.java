package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryTest {
    @BeforeEach
    public void setUp() {
    }

    Inventory myInventory = new Inventory();
    Surfboard s1 = new SoftTop(10);
    Surfboard s2 = new Original(6);
    Wetsuit w1 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.M);
    Wetsuit w2 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.XL);
    Booties b1 = new Booties(Booties.Type.KIDS, Booties.Sizes.XS);
    Booties b2 = new Booties(Booties.Type.MENS, Booties.Sizes.L);
    ArrayList<Equipment> list = new ArrayList<Equipment>();
}
    @Test

    public void testAddEquipment(){
        myInventory.addEquipment(s1);
        assertEquals(myInventory.getStock().size(),1);
        myInventory.addEquipment(s1);
        assertEquals(myInventory.getStock().size(),2);
    }
    @Test
public void testSetRented(){
        list.add(w1);
        list.add(w2);
        myInventory.setRented(list);
        assertEquals(myInventory.getRented().size(), 2);

}
//public void test




}