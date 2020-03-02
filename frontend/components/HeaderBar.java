package minesweeper.frontend.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HeaderBar extends JPanel {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    public HeaderBar() {
//        setLayout(new BorderLayout());
        JLabel label = new JLabel("Hello, welcome to the minesweeper application.");
        JButton settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                createSettingsMenu();
                } 
            } 
        );
        JButton helpButton = new JButton("Help");
        add(label);
        add(settingsButton);
        add(helpButton);
    }

    public static void createSettingsMenu() {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                SettingsMenu menu = new SettingsMenu();
            }
        });
    }
}