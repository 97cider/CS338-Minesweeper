package minesweeper.frontend.components;

import javax.swing.*;
import java.awt.*;

public class BoardPiece extends JButton {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
    private int x, y;

    public BoardPiece(int x, int y) {
        this.setIcon(new ImageIcon("tileEmpty.png"));
        this.x = x;
        this.y = y;
    }
}