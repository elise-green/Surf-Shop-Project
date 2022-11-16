package ui;

import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


public class AddEquipment {
    private JPanel mainPanel;
    private JButton surfButton;
    private JButton wetsuitButton;
    private JButton bootButton;

    public AddEquipment() {
        mainPanel = new JPanel();
        surfButton = new JButton("Add Surfboard");
        wetsuitButton = new JButton("Add Wetsuit");
        bootButton = new JButton("Add Booties");

        surfButton.addActionListener(new SurfButtonListener());
        wetsuitButton.addActionListener(new WetsuitButtonListener());
        bootButton.addActionListener(new BootButtonListener());

        mainPanel.add(surfButton);
        mainPanel.add(wetsuitButton);
        mainPanel.add(bootButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


    private class SurfButtonListener implements ActionListener {
        JPopupMenu popupMenu;
        JLabel sizeLabel;
        JLabel typeLabel;
        JRadioButton type1;
        JRadioButton type2;
        JRadioButton size6;
        JRadioButton size7;
        JRadioButton size8;
        JRadioButton size9;
        JRadioButton size10;

        JButton add;


        public SurfButtonListener() {
        }

        @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
        private JPopupMenu surfPopupMenu() {
            popupMenu = new JPopupMenu("Add Surfboard");
            sizeLabel = new JLabel("Size");
            typeLabel = new JLabel("Type");
            type1 = new JRadioButton("Softtop");
            type2 = new JRadioButton("Original");
            size6 = new JRadioButton("6");
            size7 = new JRadioButton("7");
            size8 = new JRadioButton("8");
            size9 = new JRadioButton("9");
            size10 = new JRadioButton("10");
            add = new JButton("add");
            add.addActionListener(new AddNewBoard());

            popupMenu.add(typeLabel);
            popupMenu.add(type1);
            popupMenu.add(type2);
            popupMenu.addSeparator();
            popupMenu.add(sizeLabel);
            popupMenu.add(size6);
            popupMenu.add(size7);
            popupMenu.add(size8);
            popupMenu.add(size9);
            popupMenu.add(size10);
            popupMenu.add(add);
            return popupMenu;
        }


        @Override
        public void actionPerformed(ActionEvent event) {
            surfPopupMenu();

        }

        private class AddNewBoard implements ActionListener {

            public AddNewBoard() {
            }

            @Override

            public void actionPerformed(ActionEvent event) {
            }

        }
    }

    private class WetsuitButtonListener implements ActionListener {

        public WetsuitButtonListener() {

        }

        @Override
        public void actionPerformed(ActionEvent event) {

        }
    }

    private class BootButtonListener implements ActionListener {
        public BootButtonListener() {

        }

        @Override
        public void actionPerformed(ActionEvent event) {

        }

    }
}

