package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Equipment;
import model.Inventory;
import persistance.JsonReader;
import persistance.JsonWriter;

public class GUI extends JFrame {


    JPanel mainPanel = new JPanel();
    JPanel gRent = new JPanel();

    private StockList stockList;
    private RentList rentList;


    JPanel addRent = new JPanel();
    JPanel addStock = new JPanel();


    private RentEquipment rentEquipment;
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);
    private Inventory myShop = new Inventory();
    private static final String JSON_STORE = "./data/testWriterGeneral.json";
    private JButton saveButton = new JButton("Save");
    private JButton loadButton = new JButton("Load");

    private AddEquipment addEquipment;
    JTabbedPane tabbedPane = new JTabbedPane();
    JLabel gRentLabel = new JLabel("Rented Equipment");
    JLabel gStockLabel = new JLabel("Equipment in stock");
    private JList<String> list;

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


    public GUI() {

        mainPanel.add(saveButton);
        mainPanel.add(loadButton);
        gRent.add(gRentLabel);

        stockList = new StockList(myShop);
        rentList = new RentList(myShop);
        addEquipment = new AddEquipment(myShop, this);
        rentEquipment = new RentEquipment(myShop, this);


        saveButton.addActionListener(new SaveButtonListener());
        loadButton.addActionListener(new LoadButtonListener());

        tabbedPane.addTab("Main", mainPanel);
        tabbedPane.addTab("Get Rented", rentList.getPanel());
        tabbedPane.addTab("Get Stock", stockList.getPanel());
        tabbedPane.add("Rent Equipment", rentEquipment.getMainPanel());
        tabbedPane.add("Add Stock", addEquipment.getMainPanel());
        add(tabbedPane);
    }

    public void updateGUI() {
        removeAll();
        mainPanel.add(saveButton);
        mainPanel.add(loadButton);
        gRent.add(gRentLabel);

        stockList = new StockList(myShop);
        rentList = new RentList(myShop);
        addEquipment = new AddEquipment(myShop, this);
        rentEquipment = new RentEquipment(myShop, this);


        saveButton.addActionListener(new SaveButtonListener());
        loadButton.addActionListener(new LoadButtonListener());

        tabbedPane.addTab("Main", mainPanel);
        tabbedPane.addTab("Get Rented", rentList.getPanel());
        tabbedPane.addTab("Get Stock", stockList.getPanel());
        tabbedPane.add("Rent Equipment", rentEquipment.getMainPanel());
        tabbedPane.add("Add Stock", addEquipment.getMainPanel());
        add(tabbedPane);
    }

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


    public class LoadButtonListener implements ActionListener {

        public LoadButtonListener() {

        }

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                myShop = jsonReader.read();
                JOptionPane.showMessageDialog(null, "Loaded" + "My shops inventory" + " from " + JSON_STORE);
                updateGUI();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to read from file: " + JSON_STORE);
            }
        }
    }

    public Inventory getMyShop() {
        return myShop;
    }
}








