package minesweeper.src.main.java;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import minesweeper.src.main.java.components.AccessibilityMenu;
import minesweeper.src.main.java.components.GameMenu;
import minesweeper.src.main.java.components.HelpMenu;
import minesweeper.src.main.java.components.MineSweeperBoard;
import minesweeper.src.main.java.components.MineSweeperScoreBoard;

public class MineSweeper extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private MineSweeperModel model;
    private final Container cp;
    private MineSweeperScoreBoard scoreBoardPanel;
    private MineSweeperBoard boardPanel;
    private final GameMenu gameMenu;
    private final AccessibilityMenu accessibilityMenu;
    private final HelpMenu helpMenu;
    private boolean gameOver;
    private double currentSizeModifier = 1.0;
    private int currentSkinIndex = 0;

    public MineSweeper() {
        model = new MineSweeperModel();
        scoreBoardPanel = new MineSweeperScoreBoard(model, this);
        boardPanel = new MineSweeperBoard(this, model);
        gameMenu = new GameMenu(this, model);
        accessibilityMenu = new AccessibilityMenu(this, model);
        helpMenu = new HelpMenu(this);
        cp = getContentPane();
        gameOver = false;

        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(gameMenu);
        menuBar.add(accessibilityMenu);
        menuBar.add(helpMenu);

        cp.add(scoreBoardPanel, BorderLayout.NORTH);
        cp.add(boardPanel, BorderLayout.CENTER);

        this.setLocation(100, 100);
        this.setTitle("Minesweeper");
        this.setJMenuBar(menuBar);
        this.setSize((int) (model.getColumns() * 20), (int) (model.getRows() * 20 + 80));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void resetGame() {
        cp.remove(scoreBoardPanel);
        cp.remove(boardPanel);
        gameOver = false;
        model = new MineSweeperModel(currentSkinIndex);
        scoreBoardPanel = new MineSweeperScoreBoard(model, this);
        boardPanel = new MineSweeperBoard(this, model);
        cp.add(scoreBoardPanel, BorderLayout.NORTH);
        cp.add(boardPanel, BorderLayout.CENTER);
        this.setResizable(true);
        this.setSize(model.getColumns() * 20, model.getRows() * 20 + 80);
        this.setResizable(false);
        this.validate();
    }

    public void resetGame(final int rows, final int columns, final int mines) {
        cp.remove(scoreBoardPanel);
        cp.remove(boardPanel);
        gameOver = false;
        model = new MineSweeperModel(rows, columns, mines, currentSkinIndex);
        scoreBoardPanel = new MineSweeperScoreBoard(model, this);
        boardPanel = new MineSweeperBoard(this, model);
        cp.add(scoreBoardPanel, BorderLayout.NORTH);
        cp.add(boardPanel, BorderLayout.CENTER);
        this.setResizable(true);
        this.setSize(model.getColumns() * 20, model.getRows() * 20 + 80);
        this.setResizable(false);
        this.validate();
    }

    public void UpdateBoardPallete(final int index) {
        this.currentSkinIndex = index;
        this.model.setIconsIndex(index);
        this.setSize((int) (model.getColumns() * 20 * currentSizeModifier),
                (int) (model.getRows() * 20 * currentSizeModifier + 80));
        boardPanel.RedrawAllPieces(currentSizeModifier);
    }

    public void UpdateBoardSize(final double sizeModifier) {
        this.currentSizeModifier = sizeModifier;
        this.setSize((int) (model.getColumns() * 20 * sizeModifier), (int) (model.getRows() * 20 * sizeModifier + 80));
        boardPanel.RedrawAllPieces(sizeModifier);
    }

    public Container getContainer() {
        return cp;
    }

    public static void main(final String[] args) {
        final MineSweeper ms = new MineSweeper();
        ms.setVisible(true);
        System.out.println(new File(".").getAbsolutePath());
        Class c = MineSweeper.class;
        String className = c.getName();
        System.out.println(className);
    }
}