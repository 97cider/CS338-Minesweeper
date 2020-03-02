package minesweeper.frontend.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSweeperBoard extends JPanel implements ActionListener {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private BoardPiece[][] pieces;
    private int boardSizeX;
    private int boardSizeY;

    public MineSweeperBoard(int x, int y) {
        boardSizeX = x;
        boardSizeY = y;
        setPreferredSize(new Dimension(400, 400));
        setLayout(new GridLayout(boardSizeY, boardSizeX));
        pieces = new BoardPiece[boardSizeY][boardSizeX];
        for (int i = 0; i < boardSizeX; i++) {
            for (int j = 0; j < boardSizeY; j++) {
                pieces[i][j] = new BoardPiece(i, j);
                add(pieces[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked on a board piece");
    }
}