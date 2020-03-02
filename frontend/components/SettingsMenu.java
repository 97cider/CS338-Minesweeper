package minesweeper.frontend.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SettingsMenu extends JFrame {
    /**
     * Load settings file and everything here
     */
    String[] resolutions = {
        "Small", "Medium", "Large", "Full Screen"
    };

    String[] colors = {
        "Grasslands", "Iceberg", "Desert", "Lava"
    };

    String[] icons = {
        "Bomb", "Face", "Food"
    };

    public SettingsMenu() {
        super("Settings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel settingsContent = new JPanel();
        settingsContent.setLayout(new BoxLayout(settingsContent, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Hello, welcome to the Settings page");

        //#region Display Settings
        JPanel displaySettings = new JPanel();
        displaySettings.setLayout(new BoxLayout(displaySettings, BoxLayout.Y_AXIS));

        JPanel resolutionSettings = new JPanel();
        resolutionSettings.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel resolutionLabel = new JLabel("Resolution");
        JComboBox<String> resolutionComboBox = new JComboBox<String>(resolutions);
        resolutionSettings.add(resolutionLabel);
        resolutionSettings.add(resolutionComboBox);

        // color settings
        JPanel colorSettings = new JPanel();
        colorSettings.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel colorLabel = new JLabel("Colors");
        JComboBox<String> colorComboBox = new JComboBox<String>(colors);
        colorSettings.add(colorLabel);
        colorSettings.add(colorComboBox);

        // icon settings
        JPanel iconSettings = new JPanel();
        iconSettings.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel iconLabel = new JLabel("Icons");
        JComboBox<String> iconComboBox = new JComboBox<String>(icons);
        iconSettings.add(iconLabel);
        iconSettings.add(iconComboBox);

        displaySettings.add(label);
        displaySettings.add(resolutionSettings);
        displaySettings.add(colorSettings);
        displaySettings.add(iconSettings);
        settingsContent.add(displaySettings);
        //#endregion        

        add(settingsContent);
        setVisible(true);
        setResizable(false);
        setSize(320, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}