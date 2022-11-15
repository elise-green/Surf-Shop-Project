package ui;

import model.Equipment;
import model.Inventory;

import javax.swing.*;

public class StockList extends JFrame {
        JList list;
        JPanel panel;

        public StockList(Inventory shop){
            list.setListData(shop.getStock().toArray());
            panel.add(list);
            }

    public JPanel getPanel() {
        return panel;
    }
}
