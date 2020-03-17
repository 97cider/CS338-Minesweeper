package minesweeper.frontend.components;

import javax.swing.*;
import java.awt.*;

public class BoardPiece extends JButton {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
    private int x, y;
    private boolean mine, flagged;

    public BoardPiece(int y, int x) {
        this.x = x;
        this.y = y;
        ImageIcon unClicked = new ImageIcon("./minesweeper/images/facingDown.png");
        this.setIcon(resizeIcon(unClicked));
    }

    public ImageIcon resizeIcon(ImageIcon icon) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(20, 20,  Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
}