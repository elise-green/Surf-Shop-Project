package persistance;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Inventory read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseInventory(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Inventory from JSON object and returns it
    private Inventory parseInventory(JSONObject jsonObject) {

        Inventory inventory = new Inventory();
        addStock(inventory, jsonObject);
        addRent(inventory, jsonObject);
        return inventory;
    }

    // MODIFIES: inventory
    // EFFECTS: parses thingies from JSON object and adds them to the addEquipment function
    private void addStock(Inventory inventory, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("stock");
        for (Object json : jsonArray) {
            JSONObject nextEquipment = (JSONObject) json;
            addEquipment(inventory, nextEquipment);
        }
    }
    //MODIFIES: inventory
    //EFFECTS: adds the next piece of equipment on the json array
    // and puts it into the addRented function

    private void addRent(Inventory inventory, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("rented");
        for (Object json : jsonArray) {
            JSONObject nextEquipment = (JSONObject) json;
            addRented(inventory, nextEquipment);
        }
    }

    // MODIFIES: inventory
    // EFFECTS: parses thingy from JSON object and adds it to the stock
    private void addEquipment(Inventory inventory, JSONObject jsonObject) {
        String category = jsonObject.getString("Category");
        if (category.equals("Surfboard")) {
            String type = String.valueOf(jsonObject.getString("Type"));
            if (type.equals("Soft top")) {
                Integer size = Integer.valueOf(jsonObject.getInt("Size"));
                Equipment e0 = new SoftTop(size);
                inventory.addEquipment(e0);
            }
            Integer size = Integer.valueOf(jsonObject.getInt("Size"));
            Equipment e1 = new Original(size);
            inventory.addEquipment(e1);
        } else if (category.equals("Wetsuit")) {
            Wetsuit.Type type = Wetsuit.Type.valueOf(jsonObject.getString("Type"));
            Wetsuit.Sizes size = Wetsuit.Sizes.valueOf(jsonObject.getString("Size"));
            Equipment e2 = new Wetsuit(type, size);
            inventory.addEquipment(e2);
        } else {
            Booties.Type type = Booties.Type.valueOf(jsonObject.getString("Type"));
            Booties.Sizes size = Booties.Sizes.valueOf(jsonObject.getString("Size"));
            Equipment e3 = new Booties(type, size);
            inventory.addEquipment(e3);
        }
    }
    //MODIFIES: inventory
    // EFFECTS: parses thingy from JSON object and adds it to the rented

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void addRented(Inventory inventory, JSONObject jsonObject) {
        String category = jsonObject.getString("Category");
        if (category.equals("Surfboard")) {
            String type = String.valueOf(jsonObject.getString("Type"));
            if (type.equals("Soft top")) {
                int size = jsonObject.getInt("Size");
                Equipment e0 = new SoftTop(size);
                inventory.rentEquipment(e0);
            }
            int size = jsonObject.getInt("Size");
            Equipment e1 = new Original(size);
            inventory.rentEquipment(e1);
        } else if (category.equals("Wetsuit")) {
            Wetsuit.Type type = Wetsuit.Type.valueOf(jsonObject.getString("Type"));
            Wetsuit.Sizes size = Wetsuit.Sizes.valueOf(jsonObject.getString("Size"));
            Equipment e2 = new Wetsuit(type, size);
            inventory.rentEquipment(e2);
        } else {
            Booties.Type type = Booties.Type.valueOf(jsonObject.getString("Type"));
            Booties.Sizes size = Booties.Sizes.valueOf(jsonObject.getString("Size"));
            Equipment e3 = new Booties(type, size);
            inventory.rentEquipment(e3);
        }
    }
}



