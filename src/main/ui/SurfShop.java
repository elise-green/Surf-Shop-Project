
package ui;


import persistance.JsonReader;
import persistance.JsonWriter;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// Surf Shop application
public class SurfShop extends Inventory {
    private Inventory myShop;
    private Scanner input;

    private JsonWriter jsonWriter;

    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/inventory.json";
    // EFFECTS: runs the SurfShop application


    public SurfShop() throws FileNotFoundException {
        input = new Scanner(System.in);
        myShop = new Inventory();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runSurfShop();
    }
    // MODIFIES: this
    // EFFECTS: processes user input

    private void runSurfShop() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void processCommand(String command) {
        switch (command) {
            case "s":
                addSurfboard();
                break;
            case "w":
                addWetsuit();
                break;
            case "b":
                addBooties();
                break;
            case "g":
                System.out.println(myShop.getStock());
                break;
            case "r":
                System.out.println(myShop.getRented());
                break;
            case "rs":
                rentSurfboard();
                break;
            case "rw":
                rentWetsuit();
                break;
            case "rb":
                rentBooties();
                break;
            case "v":
                saveInventory();
            case "l":
                loadInventory();
            default:
                System.out.println("Selection not valid...");
                break;
        }
    }

    private void rentBooties() {
        System.out.print("Select type");
        String category = selectRange();
        System.out.print("Select size");
        Booties.Sizes size = selectBootieSize();


        switch (category) {
            case "MENS":
                Equipment z = new Booties(Booties.Type.MENS, size);
                myShop.rentEquipment(z);
                System.out.println("Rented mens booties...\n");
                break;
            case "WOMENS":
                Equipment y = new Booties(Booties.Type.WOMENS, size);
                myShop.rentEquipment(y);
                System.out.println("Rented women's booties...\n");
                break;
            case "KIDS":
                Equipment x = new Booties(Booties.Type.KIDS, size);
                myShop.rentEquipment(x);
                System.out.println("Rented kids booties ...\n");
                break;
        }
        rentBooties();
    }

    private void rentWetsuit() {
        System.out.print("Select type");
        String category = selectRange();

        System.out.print("Select size ");
        Wetsuit.Sizes size = selectWetsuitSize();


        if (category.equals("MENS")) {
            Equipment c = new Wetsuit(Wetsuit.Type.MENS, size);
            myShop.rentEquipment(c);
            System.out.println("Rented a mens wetsuit...\n");
        } else if (category.equals("WOMENS")) {
            Equipment a = new Wetsuit(Wetsuit.Type.WOMENS, size);
            myShop.rentEquipment(a);
            System.out.println("Rented a women's wetsuit...\n");
        } else {
            Equipment b = new Wetsuit(Wetsuit.Type.KIDS, size);
            myShop.rentEquipment(b);
            System.out.println("Rented a kids wetsuit...\n");
        }
    }

    private void rentSurfboard() {
        System.out.print("Enter type ");
        String type = selectType();
        System.out.print("Enter length");
        int length = input.nextInt();
        System.out.println("Enter action");



        if (type.equals("Softtop")) {
            Equipment x = new SoftTop(length);
            myShop.rentEquipment(x);
        } else {
            Equipment y = new Original(length);
            myShop.rentEquipment(y);
        }
        System.out.println("surfboard was rented");
    }

    // MODIFIES: this
    // EFFECTS: initializes inventory
    private void init() {
        myShop = new Inventory();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ts -> add surfboard");
        System.out.println("\tw -> add wetsuit");
        System.out.println("\tb -> add booties");
        System.out.println("\tg -> get stock");
        System.out.println("\trs -> rent surfboard");
        System.out.println("\trw -> rent wetsuit");
        System.out.println("\trb -> rent booties");
        System.out.println("\tr -> get rented");
        System.out.println("\tv-> save inventory");
        System.out.println("\tl -> load inventory");
        System.out.println("\tq -> quit");

    }

    // MODIFIES: this
    // EFFECTS: allows the user to add a surfboard
    private void addSurfboard() {
        System.out.print("Enter type ");
        String type = selectType();
        System.out.print("Enter length");
        int length = input.nextInt();
        System.out.println("Enter action");


        if (type.equals("Softtop")) {
            SoftTop x = new SoftTop(length);
            myShop.addEquipment(x);

        } else {
            Original y = new Original(length);
            myShop.addEquipment(y);
        }
        System.out.println("new surfboard was added");
    }

    // MODIFIES: this
    // EFFECTS: adds a wetsuit to the stock
    private void addWetsuit() {
        System.out.print("Select type");
        String category = selectRange();

        System.out.print("Select size ");
        Wetsuit.Sizes size = selectWetsuitSize();


        if (category.equals("MENS")) {
            myShop.addEquipment(new Wetsuit(Wetsuit.Type.MENS, size));
            System.out.println("Added a mens wetsuit...\n");
        } else if (category.equals("WOMENS")) {
            myShop.addEquipment(new Wetsuit(Wetsuit.Type.WOMENS, size));
            System.out.println("Added a women's wetsuit...\n");
        } else {
            myShop.addEquipment(new Wetsuit(Wetsuit.Type.KIDS, size));
            System.out.println("Added a kids wetsuit...\n");
        }

    }

    private void addBooties() {
        System.out.print("Select type");
        String category = selectRange();
        System.out.print("Select size");
        Booties.Sizes size = selectBootieSize();


        if (category.equals("MENS")) {
            myShop.addEquipment(new Booties(Booties.Type.MENS, size));
            System.out.println("Added mens booties...\n");
        } else if (category.equals("WOMENS")) {
            myShop.addEquipment(new Booties(Booties.Type.WOMENS, size));
            System.out.println("Added women's booties...\n");
        } else {
            myShop.addEquipment(new Booties(Booties.Type.KIDS, size));
            System.out.println("Added kids booties ...\n");
        }
    }


    // EFFECTS: prompts user to select chequing or savings account and returns it
    private String selectType() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("s") || selection.equals("o"))) {
            System.out.println("o for original");
            System.out.println("s for softtop");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("s")) {
            return "softtop";
        } else {
            return "original";
        }
    }


    private String selectRange() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("m") || selection.equals("w") || selection.equals("k"))) {
            System.out.println("m for mens");
            System.out.println("w for women's");
            System.out.println("k for kids");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("m")) {
            return "MENS";
        } else if (selection.equals("w")) {
            return "WOMENS";
        } else {
            return "KIDS";
        }
    }

    @SuppressWarnings({"methodLength", "checkstyle:SuppressWarnings"})
    private Wetsuit.Sizes selectWetsuitSize() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("xs") || selection.equals("s") || selection.equals("m") || selection.equals("l")
                || selection.equals("xl"))) {
            System.out.println("xs for extra-small");
            System.out.println("s for small");
            System.out.println("m for medium");
            System.out.println("l for large");
            System.out.println("xl for extra-large");
            selection = input.next();
            selection = selection.toLowerCase();
        }
        switch (selection) {

            case "xs":
                return Wetsuit.Sizes.XS;
            case "s":
                return Wetsuit.Sizes.S;
            case "m":
                return Wetsuit.Sizes.M;
            case "l":
                return Wetsuit.Sizes.L;
            case "xl":
                return Wetsuit.Sizes.XL;
            default:
                return selectWetsuitSize();
        }
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private Booties.Sizes selectBootieSize() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("xs") || selection.equals("s") || selection.equals("m") || selection.equals("l")
                || selection.equals("xl"))) {
            System.out.println("xs for extra-small");
            System.out.println("s for small");
            System.out.println("m for medium");
            System.out.println("l for large");
            System.out.println("xl for extra-large");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        switch (selection) {
            case "xs":
                return Booties.Sizes.XS;
            case "s":
                return Booties.Sizes.S;
            case "m":
                return Booties.Sizes.M;
            case "l":
                return Booties.Sizes.L;
            case "xl":
                return Booties.Sizes.XL;
            default:
                return selectBootieSize();
        }
    }

    private void saveInventory() {
        try {
            jsonWriter.open();
            jsonWriter.write(myShop);
            jsonWriter.close();
            System.out.println("Saved " + " My shops inventory" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadInventory() {
        try {
            myShop = jsonReader.read();
            System.out.println("Loaded " + "My shops inventory" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}