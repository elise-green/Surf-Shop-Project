package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
   private Inventory myInventory;
   private Surfboard s1;
   private Surfboard s2;
   private Wetsuit w1;
   private Wetsuit w2;
   private Booties b1;
   private Booties b2;
   private ArrayList<Equipment> list;
    @BeforeEach
    public void SetUp() {


     myInventory = new Inventory();
     s1 = new SoftTop(10);
     s2 = new Original(6);
     w1 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.M);
     w2 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.XL);
     b1 = new Booties(Booties.Type.KIDS, Booties.Sizes.XS);
     b2 = new Booties(Booties.Type.MENS, Booties.Sizes.L);
     list = new ArrayList<Equipment>();
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
@Test
public void testSetStock(){
        assertEquals(myInventory.getStock().size(),0);
      list.add(b1);
      list.add(b2);
      list.add(w1);
      myInventory.setStock(list);
    assertEquals(myInventory.getStock().size(),3);
}
@Test

public void testRemoveEquipment(){
        myInventory.addEquipment(b1);
        myInventory.addEquipment(b1);
        myInventory.removeEquipment(b1);
        assertEquals(myInventory.getStock().size(),1);
        assertTrue(myInventory.removeEquipment(b1));
        myInventory.removeEquipment(b1);
        assertEquals(myInventory.getStock().size(),0);
        assertFalse(myInventory.removeEquipment(b1));
        assertFalse(myInventory.removeEquipment(w1));

}
@Test
public void testInStock(){
        list.add(w1);
        list.add(w2);
        list.add(s1);
        list.add(s2);
        myInventory.setStock(list);
        assertTrue(myInventory.inStock(w1));
        assertTrue(myInventory.inStock(s2));
        assertFalse(myInventory.inStock(b1));
        assertFalse(myInventory.inStock(b2));
}
@Test
public void testRentEquipment(){
    list.add(w1);
    list.add(w2);
    list.add(s1);
    list.add(s2);
    myInventory.setStock(list);
    assertTrue(myInventory.rentEquipment(list));
    myInventory.rentEquipment(list);
    assertEquals(myInventory.getStock().size(),0);
    assertEquals(myInventory.getRented().size(), list.size());

}
@Test

public void getPrice(){

}





}