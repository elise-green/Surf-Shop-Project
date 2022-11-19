package ui;

import model.Equipment;
import model.Inventory;

import javax.swing.*;

public class RentList {

    private JPanel panel = new JPanel();
    private JList<Equipment> list = new JList<>();
    private DefaultListModel modelList = new DefaultListModel<>();
    private JScrollPane sp;
    private Inventory myShop;

    public RentList(Inventory shop) {

        for (int i = 0; i < shop.getStock().size(); i++) {
            modelList.addElement(shop.getRented().get(i));
        }
        list.setModel(modelList);
        sp = new JScrollPane(list);
        panel.add(sp);
        panel.setVisible(true);
    }

    public void updateRentList(Inventory shop) {
        panel.removeAll();
        modelList.removeAllElements();
        list.removeAll();
        for (int i = 0; i < shop.getRented().size(); i++) {
            modelList.addElement(shop.getRented().get(i));
        }
        list.setModel(modelList);
        sp = new JScrollPane(list);
        panel.add(sp);
        panel.setVisible(true);
    }


    public JPanel getPanel() {
        return panel;
    }
}
