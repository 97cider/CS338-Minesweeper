package minesweeper.frontend;

import minesweeper.frontend.components.MineSweeperScoreBoard;

import javax.swing.Timer;

public class MineSweeperModel {
    private int rows;
    private int columns;
    private int mines;
    private Timer t;

    public double pieceSizeModifier = 1.0;

    public MineSweeperModel() {
        rows = 16;
        columns = 16;
        mines = 40;;
    }

    public MineSweeperModel(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
    }

    public void startTimer()
    {
        t.start();
    }

    public void setTimer(Timer time) {
        t = time;
    }

    public int getRows(){ return rows;}
    public int getColumns(){ return columns; }
    public int getMines() { return mines; }
    public double getSizeModifier() { return pieceSizeModifier; }
    public void setRows(int rows) { this.rows = rows; }
    public void setColumns(int columns) { this.columns = columns; }
    public void setMines(int mines) { this.mines = mines; }
}
