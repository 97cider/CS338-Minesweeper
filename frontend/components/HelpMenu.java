package minesweeper.frontend.components;

import minesweeper.frontend.MineSweeper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenu extends JMenu {
    private MineSweeper ms;
    
    public HelpMenu(MineSweeper msweep) {
        super("Help");
        this.ms = msweep;
        JMenuItem contentsHI = new JMenuItem("Contents");
        JMenuItem aboutMI = new JMenuItem("About Minesweeper");
        aboutMI.addActionListener(new AboutListener());

        this.add(contentsHI);
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
