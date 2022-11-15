package persistence;

import model.Inventory;

import model.Equipment;
import model.Wetsuit;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import persistance.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Inventory inventory = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

  @Test
    void testReaderEmptyFile() {JsonReader reader = new JsonReader("./data/testReaderEmptyStock.json");
        try {
            Inventory inventory = reader.read();
            assertEquals(0, inventory.getStock().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void  testReaderEmptyRented(){
        JsonReader reader = new JsonReader("./data/testReaderGeneral.json");
        try {
            Inventory inventory = reader.read();
            assertEquals(0, inventory.getRented().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralStock(){
        JsonReader reader = new JsonReader("./data/testReaderGeneral.json");
        try {
            Inventory inventory = reader.read();
            List<Equipment> stock = inventory.getStock();
            List<Equipment> rented = inventory.getRented();
            assertEquals(1, stock.size());
            assertEquals(stock.get(0).getCategory(), "Surfboard");
            assertEquals("Soft top", stock.get(0).getType());
            assertEquals("7", stock.get(0).getSize());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

  @Test
    void testReaderGeneralRented(){
        JsonReader reader = new JsonReader("./data/testReaderRent.json");
        try {
            Inventory inventory = reader.read();
            List<Equipment> rented = inventory.getRented();
            assertEquals(1, rented.size());
            assertEquals(rented.get(0).getCategory(), "Surfboard");
            assertEquals("Soft top", rented.get(0).getType());
            assertEquals("8", rented.get(0).getSize());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
