package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Inventory;
import persistance.JsonReader;
import persistance.JsonWriter;

public class GUI extends JFrame {


    JPanel mainPanel = new JPanel();


    private StockList stockList;
    private RentList rentList;


    JPanel addRent = new JPanel();
    JPanel addStock = new JPanel();

    JLabel importImage;
    ImageIcon image;


    private RentEquipment rentEquipment;
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);
    private Inventory myShop = new Inventory();
    private static final String JSON_STORE = "./data/inventory.json";
    private JButton saveButton = new JButton("Save");
    private JButton loadButton = new JButton("Load");

    private AddEquipment addEquipment;
    JTabbedPane tabbedPane = new JTabbedPane();

    private JList<String> list;

    // EFFECTS: runs gui
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                    frame.setSize(425, 300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})

    //EFFECTS: renders the gui and sets up all the panels
    public GUI() {

        try {
            image = new ImageIcon(getClass().getResource("Surfboard.png"));
            Image image2 = image.getImage();
            Image image3 = image2.getScaledInstance(60, 120, Image.SCALE_SMOOTH);
            image = new ImageIcon(image3);
            importImage = new JLabel("Surf Shop", image, JLabel.CENTER);
            mainPanel.add(importImage);
        } catch (Exception e) {
            System.out.println("Image could not be found");
        }

        mainPanel.add(saveButton);
        mainPanel.add(loadButton);


        stockList = new StockList(myShop);
        rentList = new RentList(myShop);
        addEquipment = new AddEquipment(myShop, this, rentList, stockList);
        rentEquipment = new RentEquipment(myShop, this, rentList, stockList);


        saveButton.addActionListener(new SaveButtonListener());
        loadButton.addActionListener(new LoadButtonListener());

        tabbedPane.addTab("Main", mainPanel);
        tabbedPane.addTab("Get Rented", rentList.getPanel());
        tabbedPane.addTab("Get Stock", stockList.getPanel());
        tabbedPane.addTab("Rent Equipment", rentEquipment.getMainPanel());
        tabbedPane.addTab("Add Stock", addEquipment.getMainPanel());
        add(tabbedPane);
    }




    // MODIFIES: \data.inventory file
    // EFFECTS: saves the inventory to the file when the button is pressed
    public class SaveButtonListener implements ActionListener {

        public SaveButtonListener() {

        }

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                jsonWriter.open();
                jsonWriter.write(myShop);
                jsonWriter.close();
                JOptionPane.showMessageDialog(null, "Saved " + " My shops inventory" + " to " + JSON_STORE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Unable to write to file: " + JSON_STORE);
            }
        }
    }

    //MODIFIES : Inventory
    //EFFECTS: loads the data from the file to the inventory when the button is pressed
    public class LoadButtonListener implements ActionListener {


        public LoadButtonListener() {

        }


        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                myShop = jsonReader.read();
                JOptionPane.showMessageDialog(null, "Loaded" + "My shops inventory" + " from " + JSON_STORE);
                stockList.updateStockList(myShop);
                rentList.updateRentList(myShop);
                revalidate();
                repaint();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to read from file: " + JSON_STORE);
            }
        }
    }

}








