package ui;

import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


public class RentEquipment {
    private JPanel mainPanel;
    private JButton surfButton;
    private JButton wetsuitButton;
    private JButton bootButton;

    public RentEquipment() {
        mainPanel = new JPanel();
        surfButton = new JButton("Rent Surfboard");
        wetsuitButton = new JButton("Rent Wetsuit");
        bootButton = new JButton("Rent Booties");

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

        JSplitPane splitPane;
        JPanel leftPanel;
        JPanel rightPanel;
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
        private JSplitPane surfPanel() {
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

            splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
            return splitPane;
        }


        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, surfPanel());
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
            add.addActionListener(new RentNewWetsuit());


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

        private class RentNewWetsuit implements ActionListener {

            public RentNewWetsuit(){

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
            add.addActionListener(new RentNewBoot());

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

        private class RentNewBoot implements ActionListener {

            public RentNewBoot(){}

            @Override
            public void actionPerformed(ActionEvent event) {

            }
        }
    }
}