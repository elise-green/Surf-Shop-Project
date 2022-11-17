package ui;

import model.Inventory;
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

    public AddEquipment(Inventory shop) {
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

        private JSplitPane splitPane;
        private JPanel leftPanel;
        private JPanel rightPanel;
        private JLabel sizeLabel;
        private JLabel typeLabel;
        private JRadioButton type1;
        private JRadioButton type2;
        private JRadioButton size6;
        private JRadioButton size7;
        private JRadioButton size8;
        private JRadioButton size9;
        private JRadioButton size10;

        private ButtonGroup buttonGroup1;
        private ButtonGroup buttonGroup2;

        private JButton add;


        public SurfButtonListener(Inventory shop) {
        }

        @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
        public JSplitPane surfPanel() {
            leftPanel = new JPanel();
            rightPanel = new JPanel();

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

            leftPanel.add(typeLabel);
            leftPanel.add(type1);
            leftPanel.add(type2);
            rightPanel.add(sizeLabel);
            rightPanel.add(size6);
            rightPanel.add(size7);
            rightPanel.add(size8);
            rightPanel.add(size9);
            rightPanel.add(size10);
            rightPanel.add(add);

            buttonGroup1 = new ButtonGroup();
            buttonGroup2 = new ButtonGroup();
            buttonGroup1.add(type1);
            buttonGroup1.add(type2);
            buttonGroup2.add(size6);
            buttonGroup2.add(size7);
            buttonGroup2.add(size8);
            buttonGroup2.add(size9);
            buttonGroup2.add(size10);

            splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
            return splitPane;
        }


        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, surfPanel());
        }

        private class AddNewBoard implements ActionListener {

            public AddNewBoard(Inventory shop) {
            }

            @Override

            public void actionPerformed(ActionEvent event) {

            }

        }
    }

    private class WetsuitButtonListener implements ActionListener {

        private JSplitPane splitPane;
        private JPanel leftPanel;
        private JPanel rightPanel;

        private JLabel sizeLabel;
        private JLabel typeLabel;
        private JRadioButton type1;
        private JRadioButton type2;

        private JRadioButton type3;
        private JRadioButton size1;
        private JRadioButton size2;
        private JRadioButton size3;
        private JRadioButton size4;
        private JRadioButton size5;
        private JButton add;

        private ButtonGroup buttonGroup1;
        private ButtonGroup buttonGroup2;

        public WetsuitButtonListener() {
        }

        @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
        private JSplitPane wetsuitPanel() {
            leftPanel = new JPanel();
            rightPanel = new JPanel();

            sizeLabel = new JLabel("Size");
            typeLabel = new JLabel("Type");
            type1 = new JRadioButton("Men's");
            type2 = new JRadioButton("Women's");
            type3 = new JRadioButton("Kid's");
            size1 = new JRadioButton("XS");
            size2 = new JRadioButton("S");
            size3 = new JRadioButton("M");
            size4 = new JRadioButton("L");
            size5 = new JRadioButton("XL");
            add = new JButton("add");
            add.addActionListener(new AddNewWetsuit());


            buttonGroup1 = new ButtonGroup();
            buttonGroup2 = new ButtonGroup();
            buttonGroup1.add(type1);
            buttonGroup1.add(type2);
            buttonGroup1.add(type3);
            buttonGroup2.add(size1);
            buttonGroup2.add(size2);
            buttonGroup2.add(size3);
            buttonGroup2.add(size4);
            buttonGroup2.add(size5);

            leftPanel.add(typeLabel);
            leftPanel.add(type1);
            leftPanel.add(type2);
            leftPanel.add(type3);
            rightPanel.add(sizeLabel);
            rightPanel.add(size1);
            rightPanel.add(size2);
            rightPanel.add(size3);
            rightPanel.add(size4);
            rightPanel.add(size5);
            rightPanel.add(add);

            splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
            return splitPane;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, wetsuitPanel());
        }

        private class AddNewWetsuit implements ActionListener {

            public AddNewWetsuit() {
            }

            @Override
            public void actionPerformed(ActionEvent event) {

            }
        }
    }

    private class BootButtonListener implements ActionListener {

        private JSplitPane splitPane;
        private JPanel leftPanel;
        private JPanel rightPanel;

        private JLabel sizeLabel;
        private JLabel typeLabel;
        private JRadioButton type1;
        private JRadioButton type2;

        private JRadioButton type3;
        private JRadioButton size1;
        private JRadioButton size2;
        private JRadioButton size3;
        private JRadioButton size4;
        private JRadioButton size5;
        private JButton add;

        private ButtonGroup buttonGroup1;
        private ButtonGroup buttonGroup2;

        public BootButtonListener() {
        }

        @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
        public JSplitPane bootPanel() {
            leftPanel = new JPanel();
            rightPanel = new JPanel();


            sizeLabel = new JLabel("Size");
            typeLabel = new JLabel("Type");
            type1 = new JRadioButton("Men's");
            type2 = new JRadioButton("Women's");
            type3 = new JRadioButton("Kid's");
            size1 = new JRadioButton("XS");
            size2 = new JRadioButton("S");
            size3 = new JRadioButton("M");
            size4 = new JRadioButton("L");
            size5 = new JRadioButton("XL");
            add = new JButton("add");
            add.addActionListener(new AddNewBoot());

            buttonGroup1 = new ButtonGroup();
            buttonGroup2 = new ButtonGroup();
            buttonGroup1.add(type1);
            buttonGroup1.add(type2);
            buttonGroup1.add(type3);
            buttonGroup2.add(size1);
            buttonGroup2.add(size2);
            buttonGroup2.add(size3);
            buttonGroup2.add(size4);
            buttonGroup2.add(size5);


            leftPanel.add(typeLabel);
            leftPanel.add(type1);
            leftPanel.add(type2);
            leftPanel.add(type3);
            rightPanel.add(sizeLabel);
            rightPanel.add(size1);
            rightPanel.add(size2);
            rightPanel.add(size3);
            rightPanel.add(size4);
            rightPanel.add(size5);
            rightPanel.add(add);

            splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
            return splitPane;
        }

        @Override
        public void actionPerformed(ActionEvent event) {

            JOptionPane.showMessageDialog(null, bootPanel());

        }

        private class AddNewBoot implements ActionListener {

            public AddNewBoot() {

            }

            @Override
            public void actionPerformed(ActionEvent event) {

            }

        }
    }
}

