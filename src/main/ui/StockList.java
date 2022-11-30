package ui;

import model.Equipment;
import model.Inventory;

import javax.swing.*;

public class StockList {

    private JPanel panel = new JPanel();
    private JList<Equipment> list = new JList<>();
    private DefaultListModel modelList = new DefaultListModel<>();
    private JScrollPane sp;

    public StockList(Inventory shop) {

        for (int i = 0; i < shop.getStock().size(); i++) {
            modelList.addElement(shop.getStock().get(i));
        }
        list.setModel(modelList);
        sp = new JScrollPane(list);
        panel.add(sp);
    }

    public void updateStockList(Inventory shop) {
        modelList.clear();
        for (int i = 0; i < shop.getStock().size(); i++) {
            modelList.addElement(shop.getStock().get(i));
        }
        list.setModel(modelList);
    }

    public JPanel getPanel() {
        return panel;
    }
}
