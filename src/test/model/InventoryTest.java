package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
   private Inventory myInventory;
   private Surfboard s1;
   private Surfboard s2;
   private Wetsuit w1;
   private Wetsuit w2;
   private Wetsuit w3;
   private Booties b1;
   private Booties b2;
   private ArrayList<Equipment> list;
    @BeforeEach
    public void SetUp() {


     myInventory = new Inventory();
     s1 = new SoftTop(8);
     s2 = new Original(6);
     w1 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.M);
     w2 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.XL);
     w3 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.M);
     b1 = new Booties(Booties.Type.KIDS, Booties.Sizes.XS);
     b2 = new Booties(Booties.Type.MENS, Booties.Sizes.L);
     list = new ArrayList<>();

}

    @Test
    public void testGetters(){
        assertEquals(w1.getType(), "WOMENS");
        assertEquals(s1.getClass(), SoftTop.class);
        assertEquals(b1.getSize(), "XS");
        assertEquals(b1.getType(), "KIDS");
        assertEquals(s1.getSize(), "8");
        assertEquals(s2.getSize(), "6");
        assertEquals(s1.getType(), "Soft top");
        assertEquals(s2.getType(), "Original");
        assertEquals(s1.getCategory(), "Surfboard");
        assertEquals(w1.getCategory(), "Wetsuit");
        assertEquals(b1.getCategory(), "Booties");

    }

    @Test

    public void testToString(){
        assertEquals(w1.toString(), "Wetsuit(Category =WOMENS, Size=M)");
        assertEquals(b1.toString(), "Booties(Category =KIDS, Size=XS)");
    }
    @Test

    public void testAddEquipment(){
        myInventory.addEquipment(b1);
        assertEquals(myInventory.getStock().size(),1);
        myInventory.addEquipment(b1);
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
        list.add(b1);
        list.add(b1);
        myInventory.setStock(list);
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
    list.add(w3);
    list.add(w2);
    list.add(s1);
    list.add(s2);
    myInventory.setStock(list);
    assertEquals(true, myInventory.rentEquipment(w1));
    myInventory.rentEquipment(w1);
    assertEquals(myInventory.getStock().size(),4);
    assertEquals(myInventory.getRented().size(), 1);
    assertFalse(myInventory.rentEquipment(b1));
    }

    @Test

    public void testClassName(){
        assertEquals(myInventory.className(b1), "Booties");
        assertEquals(myInventory.className(s1), "Surfboard");
        assertEquals(myInventory.className(s2), "Surfboard");
        assertEquals(myInventory.className(w1), "Wetsuit");
    }



    @Test

    public void testGetPrice(){
        assertEquals(myInventory.getPrice(list, 5), 0);
    list.add(s2);
    assertEquals(myInventory.getPrice(list, 5), Equipment.getSurfboardPrice() * 5);
    list.add(b1);
    assertEquals(myInventory.getPrice(list,2),
            (Equipment.getBootiePrice() + Equipment.getSurfboardPrice()) * 2 );
    list.add(w1);
    assertEquals(myInventory.getPrice(list,1), Equipment.getSurfboardPrice() + Equipment.getBootiePrice()
    + Equipment.getWetsuitPrice());

    }

    }