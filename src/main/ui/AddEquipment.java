package ui;

import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddEquipment {
    private JPanel mainPanel;
    private JButton surfButton;
    private JButton wetsuitButton;
    private JButton bootButton;

    private Inventory myShop;

    private GUI gui;

    public AddEquipment(Inventory shop, GUI g) {
        mainPanel = new JPanel();
        surfButton = new JButton("Add Surfboard");
        wetsuitButton = new JButton("Add Wetsuit");
        bootButton = new JButton("Add Booties");
        myShop = shop;
        gui = g;

        surfButton.addActionListener(new SurfButtonListener(myShop, gui));
        wetsuitButton.addActionListener(new WetsuitButtonListener(myShop, gui));
        bootButton.addActionListener(new BootButtonListener(myShop, gui));

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

        private Inventory myShop;

        private GUI gui;

        public SurfButtonListener(Inventory shop, GUI g) {
            myShop = shop;
            gui = g;
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
            add.addActionListener(new AddNewBoard(myShop, gui));

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

            private Inventory myShop;

            private GUI gui;

            public AddNewBoard(Inventory shop, GUI g) {
                myShop = shop;
                gui = g;
            }


            @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
            @Override

            public void actionPerformed(ActionEvent event) {
                if (type1.isSelected()) {
                    if (size6.isSelected()) {
                        Equipment board1 = new SoftTop(6);
                        addEquip(board1, myShop);
                    } else if (size7.isSelected()) {
                        Equipment board2 = new SoftTop(7);
                        addEquip(board2, myShop);
                    } else if (size8.isSelected()) {
                        Equipment board3 = new SoftTop(8);
                        addEquip(board3, myShop);
                    } else if (size9.isSelected()) {
                        Equipment board4 = new SoftTop(9);
                        addEquip(board4, myShop);
                    } else if (size10.isSelected()) {
                        Equipment board5 = new SoftTop(10);
                        addEquip(board5, myShop);
                    }
                } else if (type2.isSelected()) {
                    if (size6.isSelected()) {
                        Equipment board1 = new Original(6);
                        addEquip(board1, myShop);
                    } else if (size7.isSelected()) {
                        Equipment board2 = new Original(7);
                        addEquip(board2, myShop);
                    } else if (size8.isSelected()) {
                        Equipment board3 = new Original(8);
                        addEquip(board3, myShop);
                    } else if (size9.isSelected()) {
                        Equipment board4 = new Original(9);
                        addEquip(board4, myShop);
                    } else if (size10.isSelected()) {
                        Equipment board5 = new Original(10);
                        addEquip(board5, myShop);
                    }

                }
                gui.updateGUI();
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
        private Inventory myShop;
        private GUI gui;

        public WetsuitButtonListener(Inventory shop, GUI g) {
            myShop = shop;
            gui = g;
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
            add.addActionListener(new AddNewWetsuit(myShop, gui));


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
            private Inventory myShop;
            private GUI gui;

            public AddNewWetsuit(Inventory shop, GUI g) {
                myShop = shop;
                gui = g;
            }

            @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
            @Override

            public void actionPerformed(ActionEvent event) {
                if (type1.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.XS);
                        addEquip(w1, myShop);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.S);
                        addEquip(w2, myShop);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.M);
                        addEquip(w3, myShop);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.L);
                        addEquip(w4, myShop);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Wetsuit(Wetsuit.Type.MENS, Wetsuit.Sizes.XL);
                        addEquip(w5, myShop);
                    }
                } else if (type2.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.XS);
                        addEquip(w1, myShop);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.S);
                        addEquip(w2, myShop);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.M);
                        addEquip(w3, myShop);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.L);
                        addEquip(w4, myShop);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Wetsuit(Wetsuit.Type.WOMENS, Wetsuit.Sizes.XL);
                        addEquip(w5, myShop);
                    }
                } else if (type3.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.XS);
                        addEquip(w1, myShop);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.S);
                        addEquip(w2, myShop);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.M);
                        addEquip(w3, myShop);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.L);
                        addEquip(w4, myShop);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Wetsuit(Wetsuit.Type.KIDS, Wetsuit.Sizes.XL);
                        addEquip(w5, myShop);
                    }
                }
                gui.updateGUI();

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

        private Inventory myShop;

        private GUI gui;

        public BootButtonListener(Inventory shop, GUI g) {
            myShop = shop;
            gui = g;
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
            add.addActionListener(new AddNewBoot(myShop, gui));

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

            private Inventory myShop;
            private GUI gui;

            public AddNewBoot(Inventory shop, GUI g) {
                myShop = shop;
                gui = g;

            }

            @Override
            public void actionPerformed(ActionEvent event) {

                if (type1.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Booties(Booties.Type.MENS, Booties.Sizes.XS);
                        addEquip(w1, myShop);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Booties(Booties.Type.MENS, Booties.Sizes.S);
                        addEquip(w2, myShop);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Booties(Booties.Type.MENS, Booties.Sizes.M);
                        addEquip(w3, myShop);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Booties(Booties.Type.MENS, Booties.Sizes.L);
                        addEquip(w4, myShop);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Booties(Booties.Type.MENS, Booties.Sizes.XL);
                        addEquip(w5, myShop);
                    }
                } else if (type2.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Booties(Booties.Type.WOMENS, Booties.Sizes.XS);
                        addEquip(w1, myShop);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Booties(Booties.Type.WOMENS, Booties.Sizes.S);
                        addEquip(w2, myShop);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Booties(Booties.Type.WOMENS, Booties.Sizes.M);
                        addEquip(w3, myShop);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Booties(Booties.Type.WOMENS, Booties.Sizes.L);
                        addEquip(w4, myShop);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Booties(Booties.Type.WOMENS, Booties.Sizes.XL);
                        addEquip(w5, myShop);
                    }
                } else if (type3.isSelected()) {
                    if (size1.isSelected()) {
                        Equipment w1 = new Booties(Booties.Type.KIDS, Booties.Sizes.XS);
                        addEquip(w1, myShop);
                    } else if (size2.isSelected()) {
                        Equipment w2 = new Booties(Booties.Type.KIDS, Booties.Sizes.S);
                        addEquip(w2, myShop);
                    } else if (size3.isSelected()) {
                        Equipment w3 = new Booties(Booties.Type.KIDS, Booties.Sizes.M);
                        addEquip(w3, myShop);
                    } else if (size4.isSelected()) {
                        Equipment w4 = new Booties(Booties.Type.KIDS, Booties.Sizes.L);
                        addEquip(w4, myShop);
                    } else if (size5.isSelected()) {
                        Equipment w5 = new Booties(Booties.Type.KIDS,Booties.Sizes.XL);
                        addEquip(w5, myShop);
                    }
                }
                gui.updateGUI();

            }

        }
    }

    public void addEquip(Equipment e, Inventory shop) {
        shop.addEquipment(e);
    }

}






