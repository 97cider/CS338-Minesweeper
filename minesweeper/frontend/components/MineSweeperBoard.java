package minesweeper.frontend.components;

import minesweeper.frontend.MineSweeper;
import minesweeper.frontend.MineSweeperModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MineSweeperBoard extends JPanel implements ActionListener {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private MineSweeperModel model;
	private BoardPiece[][] pieces;
    private int boardSizeX;
    private int boardSizeY;
    private int bombsCounted;
    private MineSweeper ms;

    public MineSweeperBoard(MineSweeper ms, MineSweeperModel m) {
        this.model = m;
        this.ms = ms;
        boardSizeX = model.getColumns();
        boardSizeY = model.getRows();
        pieces = new BoardPiece[boardSizeY][boardSizeX];

        for (int i = 0; i < boardSizeY; i++) {
            for (int j = 0; j < boardSizeX; j++) {
                pieces[i][j] = new BoardPiece(i, j, model.pieceSizeModifier);
                pieces[i][j].addMouseListener(new CustomMouseListener());
                this.add(pieces[i][j]);
            }
        }

        this.placeMines(model.getMines());

        this.setPreferredSize(new Dimension(boardSizeX * 20, boardSizeY * 20));
        this.setLayout(new GridLayout(boardSizeY, boardSizeX));
        this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
    }

    public void RedrawAllPieces(double sizeModifier) {
        for (int i = 0; i < boardSizeY; i++) {
            for (int j = 0; j < boardSizeX; j++) {
                pieces[i][j].Redraw(sizeModifier);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clickPiece((BoardPiece)e.getSource());
    }

    public void placeMines(int numberOfMines) {
        int placedMines = 0;
        Random r = new Random();
        while(placedMines < numberOfMines) {
            int randX = r.nextInt((boardSizeY - 2) + 1) + 1;
            int randY = r.nextInt((boardSizeX - 2) + 1) + 1;
            if(!pieces[randX][randY].isMine()) {
                pieces[randX][randY].SetMine();
                placedMines++;
                for (int i = randX - 1; i <= randX+1; i++) {
                    for(int j = randY- 1; j <= randY +1; j++) {
                        if((i >= 0 && i < boardSizeY) && (j >= 0 && j < boardSizeX)){
                            pieces[i][j].addNearbyMine();
                            pieces[i][j].UpdateIcon();            
                        }
                    }
                }                
            }  
        }
    }

    public void checkSurroundingPieces(BoardPiece p) {
        int row = p.getRow();
        int col = p.getCol();
        for (int i = row - 1; i <= row+1; i++) {
            for(int j = col- 1; j <= col +1; j++) {
                if((i >= 0 && i < boardSizeY) && (j >= 0 && j < boardSizeX)){
                    if(pieces[i][j].isEmpty() && !pieces[i][j].isUncovered()) {
                        pieces[i][j].Uncover();
                        pieces[i][j].UpdateIcon();
                        checkSurroundingPieces(pieces[i][j]);
                    }
                    else {
                        pieces[i][j].Uncover();
                        pieces[i][j].UpdateIcon();
                    }
                }
            }
        }
    }

    private void FlagPiece(BoardPiece p) {
        bombsCounted += p.FlagPiece();
        p.UpdateIcon();
        System.out.println("Flagged: " + bombsCounted);
        if(bombsCounted == model.getMines()) {
            System.out.println("HEY YOU WON");
            CustomWinWindow win = new CustomWinWindow(ms);
        }
    }
    private void clickPiece(BoardPiece piece) {
        if(!piece.isUncovered() && !piece.isMine()){
            if(piece.isEmpty()){
                checkSurroundingPieces(piece);
            }
            else {
                piece.Uncover();
                piece.UpdateIcon();
            }
        }
        if(piece.isMine()) {
            System.out.println("You clicked on a mine");
            for (int i = 0; i < boardSizeY; i++) {
                for (int j = 0; j < boardSizeX; j++) {
                    if(pieces[i][j].isMine()) {
                        pieces[i][j].Uncover();
                        pieces[i][j].UpdateIcon();
                    }
                }
            }
            CustomLoseWindow win = new CustomLoseWindow(ms);
        }
    }

    private class CustomMouseListener extends MouseAdapter {
        
        @Override
        public void mousePressed(MouseEvent e) {
            if(SwingUtilities.isLeftMouseButton(e)){
                clickPiece((BoardPiece)e.getSource());
            }
            else {
                FlagPiece((BoardPiece)e.getSource());
            }
        }

    }
    private class CustomWinWindow extends JWindow {
        private MineSweeper ms;
        public CustomWinWindow(MineSweeper mine) {
            this.setLocation(0 + mine.getWidth() / 2, 0 + mine.getHeight() / 2);
            this.ms = mine;
            JPanel win = new JPanel();
            JLabel winText = new JLabel("Congratulations! You have won the game! Press OK to restart.");
            JButton restart = new JButton("OK");
            restart.addActionListener(new restartListener(this));

            win.add(winText);
            win.add(restart);

            this.setSize(new Dimension(400,50));

            getContentPane().add(win, BorderLayout.CENTER);
            setVisible(true);
        }

        private class restartListener implements ActionListener {
            private CustomWinWindow winWindow; 
            public restartListener(CustomWinWindow w) {
                this.winWindow = w;
            }
            @Override 
            public void actionPerformed(ActionEvent e) {
                ms.resetGame();
                winWindow.dispose();
                
            }
        }
    }

    private class CustomLoseWindow extends JWindow {
        private MineSweeper ms;
        public CustomLoseWindow(MineSweeper mine) {
            this.setLocation(0 + mine.getWidth() / 2, 0 + mine.getHeight() / 2);
            this.ms = mine;
            JPanel win = new JPanel();
            JLabel winText = new JLabel("Oh No! You have lost the game. Press OK to restart.");
            JButton restart = new JButton("OK");
            restart.addActionListener(new restartLoseListener(this));

            win.add(winText);
            win.add(restart);
            
            this.setSize(new Dimension(400,50));

            getContentPane().add(win, BorderLayout.CENTER);
            setVisible(true);
        }

        private class restartLoseListener implements ActionListener {
            private CustomLoseWindow winWindow; 
            public restartLoseListener(CustomLoseWindow w) {
                this.winWindow = w;
            }
            @Override 
            public void actionPerformed(ActionEvent e) {
                ms.resetGame();
                winWindow.dispose();
                
            }
        }
    }
}

