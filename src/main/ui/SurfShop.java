
package ui;


import model.*;

import java.util.Scanner;


// Surf Shop application
public class SurfShop {
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
            addWetsuit;
        } else if (command.equals("b")) {
            addBooties;
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
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
    // EFFECTS: conducts a withdraw transaction
    private void addWetsuit() {
        System.out.print("Enter amount to withdraw: $");
        double amount = input.nextDouble();

        if (amount < 0.0) {
            System.out.println("Cannot withdraw negative amount...\n");
        } else if (selected.getBalance() < amount) {
            System.out.println("Insufficient balance on account...\n");
        } else {
            selected.withdraw(amount);
        }

        printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: conducts a transfer transaction
    private void doTransfer() {
        System.out.println("\nTransfer from?");
        Account source = selectAccount();
        System.out.println("Transfer to?");
        Account destination = selectAccount();

        System.out.print("Enter amount to transfer: $");
        double amount = input.nextDouble();

        if (amount < 0.0) {
            System.out.println("Cannot transfer negative amount...\n");
        } else if (source.getBalance() < amount) {
            System.out.println("Insufficient balance on source account...\n");
        } else {
            source.withdraw(amount);
            destination.deposit(amount);
        }

        System.out.print("Source ");
        printBalance(source);
        System.out.print("Destination ");
        printBalance(destination);
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
            return Wetsuit(Wetsuit.M);
        } else {
            return "original";
        }
    }

    // EFFECTS: prints balance of account to the screen
    private void printBalance(Inventory selected) {
        System.out.printf("Stock: $%.2f\n", selected.getStock());
    }
}