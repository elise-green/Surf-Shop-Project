package ui;

import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//EFFECTS: sets up the main panel with the buttons
public class AddEquipment {
    private JPanel mainPanel;
    private JButton surfButton;
    private JButton wetsuitButton;
    private JButton bootButton;

    private Inventory myShop;

    private GUI gui;

    private RentList rentList;
    private StockList stockList;


    // EFFECTS: Constructs the panel
    public AddEquipment(Inventory shop, GUI g, RentList r, StockList s) {
        mainPanel = new JPanel();
        surfButton = new JButton("Add Surfboard");
        wetsuitButton = new JButton("Add Wetsuit");
        bootButton = new JButton("Add Booties");
        myShop = shop;
        gui = g;
        rentList = r;
        stockList = s;

        surfButton.addActionListener(new SurfButtonListener(myShop, gui, rentList, stockList));
        wetsuitButton.addActionListener(new WetsuitButtonListener(myShop, gui, rentList, stockList));
        bootButton.addActionListener(new BootButtonListener(myShop, gui, rentList, stockList));

        mainPanel.add(surfButton);
        mainPanel.add(wetsuitButton);
        mainPanel.add(bootButton);
    }

    //EFFECTS: getter
    public JPanel getMainPanel() {
        return mainPanel;
    }


    //Listener for the button add surfboard
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

        private Inventory myShop;

        private GUI gui;

        private RentList rentList;
        private StockList stockList;

        //Constructor
        public SurfButtonListener(Inventory shop, GUI g, RentList r, StockList s) {
            myShop = shop;
            gui = g;
            stockList = s;
            rentList = r;

        }

        @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
        // Constructs a panel for the popup menu with all the options
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
            add.addActionListener(new AddNewBoard(myShop, gui, rentList, stockList));

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

    //EFFECTS: brings a pop-up menu with all the options when the button is clicked
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, surfPanel());
        }

        //Action listener for the popup panel with radio buttons
        private class AddNewBoard implements ActionListener {

            private Inventory myShop;

            private GUI gui;

            private RentList rentList;
            private StockList stockList;

            public AddNewBoard(Inventory shop, GUI g, RentList r, StockList s) {
                myShop = shop;
                gui = g;
                rentList = r;
                stockList = s;

            }


            @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
            @Override

            //MODIFIES : Inventory , Stockist, and main gui
            //EFFECTS: adds the piece of equipment with the radio buttons to the stock and displays it under
            // the get stock tab

            public void actionPerformed(ActionEvent event) {
                if (type1.isSelected()) {
                    if (size6.isSelected()) {
                        Equipment board1 = new SoftTop(6);
                        addEquip(board1);
                    } else if (size7.isSelected()) {
                        Equipment board2 = new SoftTop(7);
                        addEquip(board2);
                    } else if (size8.isSelected()) {
                        Equipment board3 = new SoftTop(8);
                        addEquip(board3);
                    } else if (size9.isSelected()) {
                        Equipment board4 = new SoftTop(9);
                        addEquip(board4);
                    } else if (size10.isSelected()) {
                        Equipment board5 = new SoftTop(10);
                        addEquip(board5);
                    }
                } else if (type2.isSelected()) {
                    if (size6.isSelected()) {
                        Equipment board1 = new Original(6);
                        addEquip(board1);
                    } else if (size7.isSelected()) {
                        Equipment board2 = new Original(7);
                        addEquip(board2);
                    } else if (size8.isSelected()) {
                        Equipment board3 = new Original(8);
                        addEquip(board3);
                    } else if (size9.isSelected()) {
                        Equipment board4 = new Original(9);
                        addEquip(board4);
                    } else if (size10.isSelected()) {
                        Equipment board5 = new Original(10);
                        addEquip(board5);
                    }

                }
                stockList.updateStockList(myShop);
                gui.repaint();
                gui.revalidate();
            }
        }
    }


    // Listener for when the wetsuit button is clicked
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
        private Inventory myShop;
        private GUI gui;
        private RentList rentList;
        private StockList stockList;

        public WetsuitButtonListener(Inventory shop, GUI g, RentList r, StockList s) {
            myShop = shop;
            gui = g;
            rentList = r;
            stockList = s;

        }


        // EFFECTS: Constructs a panel for the popup menu with all the options
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
            add.addActionListener(new AddNewWetsuit(myShop, gui, rentList, stockList));


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

        //EFFECTS: Displays a popup menu when the add wetsuit button is clicked
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, wetsuitPanel());
        }

        private class AddNewWetsuit implements ActionListener {
            private Inventory myShop;
            private GUI gui;
            private RentList rentList;
            private StockList stockList;

            public AddNewWetsuit(Inventory shop, GUI g, RentList r, StockList s) {
                myShop = shop;
                gui = g;
                rentList = r;
                stockList = s;

            }

            @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
            @Override

            //MODIFIES : Inventory , Stockist, and main gui
            //EFFECTS: adds the piece of equipment with the radio buttons to the stock and displays it under
            // the get stock tab
            public void actionPerformed(ActionEvent event) {
                if (type1.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.XS);
                        addEquip(w1);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.S);
                        addEquip(w2);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.M);
                        addEquip(w3);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.L);
                        addEquip(w4);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.XL);
                        addEquip(w5);
                    }
                } else if (type2.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.XS);
                        addEquip(w1);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.S);
                        addEquip(w2);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.M);
                        addEquip(w3);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.L);
                        addEquip(w4);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.XL);
                        addEquip(w5);
                    }
                } else if (type3.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.XS);
                        addEquip(w1);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.S);
                        addEquip(w2);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.M);
                        addEquip(w3);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.L);
                        addEquip(w4);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.XL);
                        addEquip(w5);
                    }
                }

                stockList.updateStockList(myShop);
                gui.repaint();
                gui.revalidate();

            }
        }
    }

    // listener for when the add boot button is pressed
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

        private Inventory myShop;

        private GUI gui;

        private RentList rentList;
        private StockList stockList;

        //Constructor
        public BootButtonListener(Inventory shop, GUI g, RentList r, StockList s) {
            myShop = shop;
            gui = g;
            rentList = r;
            stockList = s;
        }

        @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
        //Creates a panel to add to the popup menu with all the choices for size and type
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
            add.addActionListener(new AddNewBoot(myShop, gui, rentList, stockList));

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
        //EFFECTS: makes a pop-up window when the button is pressed
        public void actionPerformed(ActionEvent event) {

            JOptionPane.showMessageDialog(null, bootPanel());

        }

        private class AddNewBoot implements ActionListener {

            private Inventory myShop;
            private GUI gui;
            private RentList rentList;
            private StockList stockList;

            //Constructor
            public AddNewBoot(Inventory shop, GUI g, RentList r, StockList s) {
                myShop = shop;
                gui = g;
                rentList = r;
                stockList = s;
            }

            @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
            @Override
            //MODIFIES : Inventory , Stockist, and main gui
            //EFFECTS: adds the piece of equipment with the radio buttons to the stock and displays it under
            // the get stock tab
            public void actionPerformed(ActionEvent event) {

                if (type1.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Booties(Booties.Type.MENS, Booties.Sizes.XS);
                        addEquip(w1);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Booties(Booties.Type.MENS, Booties.Sizes.S);
                        addEquip(w2);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Booties(Booties.Type.MENS, Booties.Sizes.M);
                        addEquip(w3);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Booties(Booties.Type.MENS, Booties.Sizes.L);
                        addEquip(w4);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Booties(Booties.Type.MENS, Booties.Sizes.XL);
                        addEquip(w5);
                    }
                } else if (type2.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Booties(Booties.Type.WOMENS, Booties.Sizes.XS);
                        addEquip(w1);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Booties(Booties.Type.WOMENS, Booties.Sizes.S);
                        addEquip(w2);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Booties(Booties.Type.WOMENS, Booties.Sizes.M);
                        addEquip(w3);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Booties(Booties.Type.WOMENS, Booties.Sizes.L);
                        addEquip(w4);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Booties(Booties.Type.WOMENS, Booties.Sizes.XL);
                        addEquip(w5);
                    }
                } else if (type3.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Booties(Booties.Type.KIDS, Booties.Sizes.XS);
                        addEquip(w1);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Booties(Booties.Type.KIDS, Booties.Sizes.S);
                        addEquip(w2);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Booties(Booties.Type.KIDS, Booties.Sizes.M);
                        addEquip(w3);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Booties(Booties.Type.KIDS, Booties.Sizes.L);
                        addEquip(w4);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Booties(Booties.Type.KIDS, Booties.Sizes.XL);
                        addEquip(w5);
                    }
                }
                stockList.updateStockList(myShop);
                gui.revalidate();
                gui.repaint();
            }

        }
    }

    //MODIFIES: myShop
    //EFFECTS: adds a piece of equipment to the stock

    public void addEquip(Equipment e) {
        myShop.addEquipment(e);
    }

}






