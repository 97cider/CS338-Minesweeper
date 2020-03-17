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
    private HelpMenu helpMenu;
    private boolean gameOver;

    public MineSweeper() {
        model = new MineSweeperModel();
        scoreBoardPanel = new MineSweeperScoreBoard(model);
        boardPanel = new MineSweeperBoard(model);
        gameMenu = new GameMenu(this, model);
        helpMenu = new HelpMenu(this);
        cp = getContentPane();
        gameOver = false;

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);

        cp.add(scoreBoardPanel, BorderLayout.NORTH);
        cp.add(boardPanel, BorderLayout.CENTER);

        this.setLocation(100, 100);
        this.setTitle("Minesweeper");
        this.setJMenuBar(menuBar);
        this.setSize(model.getColumns() * 20, model.getRows() * 20 + 80);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void resetGame() {
        cp.remove(scoreBoardPanel);
        cp.remove(boardPanel);
        gameOver = false;
        model = new MineSweeperModel();
        scoreBoardPanel = new MineSweeperScoreBoard(model);
        boardPanel = new MineSweeperBoard(model);
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
        model = new MineSweeperModel(rows, columns, mines);
        scoreBoardPanel = new MineSweeperScoreBoard(model);
        boardPanel = new MineSweeperBoard(model);
        cp.add(scoreBoardPanel, BorderLayout.NORTH);
        cp.add(boardPanel, BorderLayout.CENTER);
        this.setResizable(true);
        this.setSize(model.getColumns() * 20, model.getRows() * 20 + 80);
        this.setResizable(false);
        this.validate();
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