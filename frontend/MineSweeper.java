package minesweeper.frontend;

import javax.swing.*;

import minesweeper.frontend.components.HeaderBar;
import minesweeper.frontend.components.*;

import java.awt.*;

public class MineSweeper extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MineSweeper() {
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel sweeperPanel = new JPanel();

        sweeperPanel.add(new MineSweeperBoard(15, 15));

        main.add(new HeaderBar(), BorderLayout.NORTH);
        main.add(sweeperPanel);

        setSize(720, 600);
        setVisible(true);

        add(main);
    }

    public static void main(String[] args) {
        new MineSweeper();
    }
}