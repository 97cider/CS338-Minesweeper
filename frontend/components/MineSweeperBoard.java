package minesweeper.frontend.components;

import minesweeper.frontend.MineSweeperModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSweeperBoard extends JPanel implements ActionListener {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private MineSweeperModel model;
	private BoardPiece[][] pieces;
    private int boardSizeX;
    private int boardSizeY;

    public MineSweeperBoard(MineSweeperModel m) {
        this.model = m;
        boardSizeX = model.getColumns();
        boardSizeY = model.getRows();
        pieces = new BoardPiece[boardSizeY][boardSizeX];

        for (int i = 0; i < boardSizeY; i++) {
            for (int j = 0; j < boardSizeX; j++) {
                pieces[i][j] = new BoardPiece(boardSizeY, boardSizeX);
                this.add(pieces[i][j]);
            }
        }

        this.setPreferredSize(new Dimension(boardSizeX * 20, boardSizeY * 20));
        this.setLayout(new GridLayout(boardSizeY, boardSizeX));
        this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked on a board piece");
    }
}