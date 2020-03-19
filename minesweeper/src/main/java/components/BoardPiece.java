package minesweeper.src.main.java.components;

import javax.swing.*;
import java.awt.*;

public class BoardPiece extends JButton {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
    private int row, col;
    private boolean mine = false, flagged = false, uncovered = false;
    private int mines = 0;
    private double iconScale;
    private Icons icons;
    

    public BoardPiece(int row, int col, double scale, Icons icon) {
        this.row = row;
        this.col = col;
        this.iconScale = scale;
        this.icons = icon;
        ImageIcon unClicked = new ImageIcon("./minesweeper/src/main/resources/facingDown.png");
        this.setIcon(resizeIcon(unClicked, scale));
    }

    public ImageIcon resizeIcon(ImageIcon icon, double iconScale) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance((int)(20 * iconScale), (int)(20 * iconScale),  Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }

    public void Redraw(double sizeModifier) {
        iconScale = sizeModifier;
        UpdateIcon();
    }

    public void UpdateIcon() {
        if(uncovered) {
            if(!mine) {
                ImageIcon imTarget = new ImageIcon(icons.GetIcon(mines));
                this.setIcon(resizeIcon(imTarget, iconScale));
            }
            if(mine) {
                ImageIcon imTarget = new ImageIcon(icons.GetIcon(9));
                this.setIcon(resizeIcon(imTarget, iconScale));
            }
            if(flagged) {
                ImageIcon imTarget = new ImageIcon(icons.GetIcon(11));
                this.setIcon(resizeIcon(imTarget, iconScale));
            }
        }
        else {
            if(flagged) {
                ImageIcon imTarget = new ImageIcon(icons.GetIcon(11));
                this.setIcon(resizeIcon(imTarget, iconScale));
            }
            else {
                ImageIcon imTarget = new ImageIcon(icons.GetIcon(10));
                this.setIcon(resizeIcon(imTarget, iconScale));
            }
        }                
    }

    public void SetMine() {
        mine = true;
    }

    public boolean isEmpty() {
        if(mines == 0 && !mine) {
            return true;
        }
        return false;
    }

    public void addNearbyMine() {
        mines++;
    }

    public void setNearbyMines(int i) {
        mines = i;
        UpdateIcon();
    }

    public boolean isMine() {
        return mine;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public boolean isUncovered() { return uncovered;}
    public void Uncover() { uncovered = true; }

    public int FlagPiece() {
        if(flagged) {
            flagged = false;
            // if they incorrectly removed a correct answer
            if(mine) {
                return -1;
            }
        }
        else {
            flagged = true;
            if(mine) {
                // if they flag a bomb
                return 1;
            }
        }
        return 0;
    }
}