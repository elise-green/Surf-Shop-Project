package persistence;

import model.Inventory;

import model.Equipment;
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
    void testReaderEmptyStock() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyStock.json");
        try {
            Inventory inventory = reader.read();
            assertEquals(0, inventory.getStock().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void  testReaderEmptyRented(){
        JsonReader reader = new JsonReader("./data/testReaderEmptyRented.json");
        try {
            Inventory inventory = reader.read();
            assertEquals(0, inventory.getRented().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
