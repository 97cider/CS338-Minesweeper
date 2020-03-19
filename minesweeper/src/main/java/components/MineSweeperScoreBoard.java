package minesweeper.src.main.java.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


import minesweeper.src.main.java.MineSweeper;
import minesweeper.src.main.java.MineSweeperModel;

public class MineSweeperScoreBoard extends JPanel {
    private MineSweeperModel model;
    private MineSweeper ms;
    private JTextField timer, minesLeft;
    private JButton resetButton;
    private String MAX_TIME = "999";

    public MineSweeperScoreBoard(MineSweeperModel model2, MineSweeper mineSweeper) {
        this.model = model2;
        this.ms = mineSweeper;
        timer = new JTextField("" + 0);
        minesLeft = new JTextField("" + model.getMines());
        resetButton = new JButton("Reset");

        resetButton.addActionListener(new resetListener());

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

    private class resetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ms.resetGame();
        }
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
