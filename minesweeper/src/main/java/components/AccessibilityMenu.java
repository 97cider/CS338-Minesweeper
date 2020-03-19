package minesweeper.src.main.java.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import minesweeper.src.main.java.MineSweeper;
import minesweeper.src.main.java.MineSweeperModel;


public class AccessibilityMenu extends JMenu {
    private MineSweeper ms;
    private MineSweeperModel model;
    private JMenuItem newMI;
    private JMenu iconSizeMenu;
    private JMenu colorPalleteMenu;
    private JCheckBoxMenuItem defaultSizeIcon;
    private JCheckBoxMenuItem largeSizeIcon;
    private JCheckBoxMenuItem extraLargeSizeIcon;
    private JCheckBoxMenuItem defaultPallete;
    private JCheckBoxMenuItem cartoonyPallete;


    public AccessibilityMenu(MineSweeper mineSweeper, MineSweeperModel model2) {
        super("Accessibility");
        this.ms = mineSweeper;
        this.model = model2;
        iconSizeMenu = new JMenu("Icon Sizes");
        defaultSizeIcon = new JCheckBoxMenuItem("Default");        
        largeSizeIcon = new JCheckBoxMenuItem("Large");        
        extraLargeSizeIcon = new JCheckBoxMenuItem("Extra Large");  

        defaultSizeIcon.addActionListener(new IconSizeListener());
        largeSizeIcon.addActionListener(new IconSizeListener());
        extraLargeSizeIcon.addActionListener(new IconSizeListener());

        colorPalleteMenu = new JMenu("Color Pallete");
        defaultPallete = new JCheckBoxMenuItem("Default");        
        cartoonyPallete = new JCheckBoxMenuItem("Cartoony");

        defaultPallete.addActionListener(new ColorPalleteListener());
        cartoonyPallete.addActionListener(new ColorPalleteListener());


        iconSizeMenu.add(defaultSizeIcon);
        iconSizeMenu.add(largeSizeIcon);
        iconSizeMenu.add(extraLargeSizeIcon);

        colorPalleteMenu.add(defaultPallete);
        colorPalleteMenu.add(cartoonyPallete);

        defaultSizeIcon.setState(true);

        this.add(iconSizeMenu);
        this.add(colorPalleteMenu);
    }

    private class IconSizeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(defaultSizeIcon)) {
                ms.UpdateBoardSize(1.0);
                largeSizeIcon.setState(false);
                extraLargeSizeIcon.setState((false));
            } else if(e.getSource().equals(largeSizeIcon)) {
                ms.UpdateBoardSize(2.0);
                defaultSizeIcon.setState(false);
                extraLargeSizeIcon.setState((false));
            } else if(e.getSource().equals(extraLargeSizeIcon)) {
                ms.UpdateBoardSize(3.0);
                largeSizeIcon.setState((false));
            }
        }
    }

    private class ColorPalleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(defaultPallete)) {
                ms.UpdateBoardPallete(0);
                cartoonyPallete.setState(false);
            } else if(e.getSource().equals(cartoonyPallete)) {
                ms.UpdateBoardPallete(1);
                defaultPallete.setState(false);
            }
        }
    }

}
