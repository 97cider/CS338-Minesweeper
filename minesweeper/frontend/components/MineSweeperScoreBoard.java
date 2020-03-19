package minesweeper.frontend.components;

import minesweeper.frontend.MineSweeperModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;

public class MineSweeperScoreBoard extends JPanel {
    private MineSweeperModel model;
    private JTextField timer, minesLeft;
    private JButton resetButton;
    private String MAX_TIME = "999";

    public MineSweeperScoreBoard(MineSweeperModel m) {
        this.model = m;
        timer = new JTextField("" + 0);
        minesLeft = new JTextField("" + model.getMines());
        resetButton = new JButton();

        timer.setColumns(3);
        minesLeft.setColumns(3);

        this.add(minesLeft);
        this.add(resetButton);
        this.add(timer);

        this.setSize(10, 16*20);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        model.setTimer(new Timer(1000, new TimerListener()));
        model.startTimer();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(timer.getText().compareTo(MAX_TIME) < 0) {
                timer.setText((Integer.parseInt(timer.getText()) + 1) + "");
            }
        }
    }
}