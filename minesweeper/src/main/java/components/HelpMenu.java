package minesweeper.src.main.java.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import minesweeper.src.main.java.MineSweeper;


public class HelpMenu extends JMenu {
    private MineSweeper ms;
    
    public HelpMenu(MineSweeper mineSweeper) {
        super("Help");
        this.ms = mineSweeper;
        JMenuItem aboutMI = new JMenuItem("About Minesweeper");
        aboutMI.addActionListener(new AboutListener());
        this.addSeparator();
        this.add(aboutMI);
    }

    private class AboutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ms.getContainer(),
                    "Minesweeper v1.0\n" +
                            "CS 338\n" +
                            "Justin Perez\n" +
                            "Sean McFadden");
        }
    }
}
