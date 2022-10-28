package persistence;

import model.Equipment;
import model.Inventory;

import model.Wetsuit;
import org.junit.jupiter.api.Test;
import persistance.JsonReader;
import persistance.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest{

    @Test
    void testWriterInvalidFile() {
        try {
            Inventory i = new Inventory();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyInventory() {
        try {
            Inventory i = new Inventory();
            JsonWriter writer = new JsonWriter("./data/testReaderGeneral.json");
            writer.open();
            writer.write(i);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderGeneral.json");
            i = reader.read();
            assertEquals(0, i.getStock().size());
            assertEquals(0, i.getRented().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralInventory() {
        try {
            Inventory i = new Inventory();
            i.addEquipment(new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.S));

            JsonWriter writer = new JsonWriter("./data/testWriterEmptyInventory.json");
            writer.open();
            writer.write(i);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyInventory.json");
            List<Equipment> stock = i.getStock();
            assertEquals(1, i.getRented().size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}

