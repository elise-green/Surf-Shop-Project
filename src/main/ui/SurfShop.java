
package ui;


import model.*;

import java.util.Scanner;


// Surf Shop application
public class SurfShop extends Inventory{
    private Inventory myShop;
    private Scanner input;

    // EFFECTS: runs the SurfShop application
    public SurfShop() {
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
    private void processCommand(String command) {
        if (command.equals("s")) {
            addSurfboard();
        } else if (command.equals("w")) {
            addWetsuit();
        } else if (command.equals("b")) {
            addBooties();
        } else {
            System.out.println("Selection not valid...");
        }
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
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: allows the user to add a surfboard
    private void addSurfboard() {
        System.out.print("Enter type ");
        String type = selectType();
        System.out.print("Enter length");
        int length = input.nextInt();


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
        String size = input.next();


        if (category.equals("MENS")) {
            myShop.addEquipment(new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.M));
            System.out.println("Added a mens wetsuit...\n");
        } else if (category.equals("WOMENS")) {
            myShop.addEquipment(new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.M));
            System.out.println("Added a women's wetsuit...\n");
        } else {
           myShop.addEquipment(new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.M));
            System.out.println("Added a kids wetsuit...\n");
        }

    }

    private void addBooties() {
        System.out.print("Select type");
        String category = selectRange();
        System.out.print("Select size: XS, S, M, L, XL");


        if (category.equals("MENS")) {
            myShop.addEquipment(new Booties(Booties.Type.MENS, Booties.Sizes.M));
            System.out.println("Added mens booties...\n");
        } else if (category.equals("WOMENS")) {
            myShop.addEquipment(new Booties(Booties.Type.WOMENS, Booties.Sizes.M));
            System.out.println("Added women's booties...\n");
        } else {
            myShop.addEquipment( new Booties(Booties.Type.KIDS, Booties.Sizes.M));
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
    private String select() {
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

    // EFFECTS: prints balance of account to the screen
    private void printBalance() {
        System.out.printf("Stock: $%.2f\n", myShop.getStock());
    }
}