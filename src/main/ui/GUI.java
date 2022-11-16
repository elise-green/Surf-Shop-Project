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

    StockList stockList;
    JPanel addRent = new JPanel();
    JPanel addStock = new JPanel();

    AddEquipment addEquipment = new AddEquipment();

    private  JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private  JsonReader jsonReader = new JsonReader(JSON_STORE);
    private Inventory myShop;
    private static final String JSON_STORE = "./data/inventory.json";
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");

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


        saveButton.addActionListener(new SaveButtonListener());
        loadButton.addActionListener(new LoadButtonListener());

        tabbedPane.addTab("Main", mainPanel);
        tabbedPane.addTab("Get Rented", gRent);
        tabbedPane.addTab("Get Stock", addStock);
        tabbedPane.add("Rent Equipment", addRent);
        tabbedPane.add("Add Stock",addStock);
        add(tabbedPane);

        stockList = new StockList(myShop);
    }


    public class SaveButtonListener implements ActionListener {

        public SaveButtonListener() {

        }

        @Override
        public void actionPerformed(ActionEvent event) {
            myShop = new Inventory();
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
                JOptionPane.showMessageDialog(null ,"Loaded" + "My shops inventory" + " from " + JSON_STORE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to read from file: " + JSON_STORE);
            }
        }
    }

    public Inventory getMyShop() {
        return myShop;
    }
}








