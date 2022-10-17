
package ui;


import model.Equipment;
import model.Inventory;

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
        if (command.equals("d")) {
            doDeposit();
        } else if (command.equals("w")) {
            doWithdrawal();
        } else if (command.equals("t")) {
            doTransfer();
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
        System.out.println("\td -> add stock");
        System.out.println("\tw -> get stock");
        System.out.println("\tt -> rent equipment");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void addStock(Equipment piece ) {
        myShop.addEquipment(piece);
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();

        if (amount >= 0.0) {
            selected.deposit(amount);
        } else {
            System.out.println("Cannot deposit negative amount...\n");
        }

        printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: conducts a withdraw transaction
    private void doWithdrawal() {
        Account selected = selectAccount();
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
    private Account selectAccount() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("c") || selection.equals("s"))) {
            System.out.println("c for chequing");
            System.out.println("s for savings");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("c")) {
            return cheq;
        } else {
            return sav;
        }
    }

    // EFFECTS: prints balance of account to the screen
    private void printBalance(Account selected) {
        System.out.printf("Balance: $%.2f\n", selected.getBalance());
    }
}