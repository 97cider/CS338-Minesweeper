package minesweeper.frontend;

import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;

import minesweeper.frontend.components.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweeper extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private MineSweeperModel model;
    private Container cp;
    private MineSweeperScoreBoard scoreBoardPanel;
    private MineSweeperBoard boardPanel;
    private GameMenu gameMenu;
    private AccessibilityMenu accessibilityMenu;
    private HelpMenu helpMenu;
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

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(gameMenu);
        menuBar.add(accessibilityMenu);
        menuBar.add(helpMenu);

        cp.add(scoreBoardPanel, BorderLayout.NORTH);
        cp.add(boardPanel, BorderLayout.CENTER);

        this.setLocation(100, 100);
        this.setTitle("Minesweeper");
        this.setJMenuBar(menuBar);
        this.setSize((int)(model.getColumns() * 20), (int)(model.getRows() * 20 + 80));
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

    public void resetGame(int rows, int columns, int mines) {
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

    public void UpdateBoardPallete(int index) {
        this.currentSkinIndex = index;
        this.model.setIconsIndex(index);
        this.setSize((int)(model.getColumns() * 20 * currentSizeModifier), (int)(model.getRows() * 20 * currentSizeModifier + 80));
        boardPanel.RedrawAllPieces(currentSizeModifier);
    }

    public void UpdateBoardSize(double sizeModifier) {
        this.currentSizeModifier = sizeModifier;
        this.setSize((int)(model.getColumns() * 20 * sizeModifier), (int)(model.getRows() * 20 * sizeModifier + 80));
        boardPanel.RedrawAllPieces(sizeModifier);
    }

    public Container getContainer()
    {
        return cp;
    }
    public static void main(String[] args) {
        MineSweeper ms = new MineSweeper();
        ms.setVisible(true);
    }
}