package minesweeper.src.main.java.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import minesweeper.src.main.java.MineSweeper;
import minesweeper.src.main.java.MineSweeperModel;

public class GameMenu extends JMenu {
    private MineSweeper ms;
    private MineSweeperModel model;
    private JMenuItem newMI;
    private JCheckBoxMenuItem beginnerMI;
    private JCheckBoxMenuItem intermediateMI;
    private JCheckBoxMenuItem expertMI;
    private JCheckBoxMenuItem customMI;
    private JCheckBoxMenuItem marksMI;
    private JCheckBoxMenuItem colorMI;
    private JCheckBoxMenuItem soundMI;
    private JMenuItem bestTimesMI;
    private JMenuItem exitMI;

    public GameMenu(MineSweeper mineSweeper, MineSweeperModel model2) {
        super("Game");
        this.ms = mineSweeper;
        this.model = model2;

        newMI = new JMenuItem("New");
        newMI.addActionListener(new NewGameListener());

        beginnerMI = new JCheckBoxMenuItem("Beginner");
        beginnerMI.addActionListener(new DifficultyListener());

        intermediateMI = new JCheckBoxMenuItem("Intermediate");
        intermediateMI.addActionListener(new DifficultyListener());

        expertMI = new JCheckBoxMenuItem("Expert");
        expertMI.addActionListener(new DifficultyListener());

        customMI = new JCheckBoxMenuItem("Custom...");
        customMI.addActionListener(new CustomListener());

//        marksMI = new JCheckBoxMenuItem("Marks");
//        colorMI = new JCheckBoxMenuItem("Color");
//        soundMI = new JCheckBoxMenuItem("Sound");

//        bestTimesMI = new JMenuItem("Best Times...");
        exitMI = new JMenuItem("Exit");
        exitMI.addActionListener(new ExitListener());

        this.add(newMI);
        this.addSeparator();
        this.add(beginnerMI);
        this.add(intermediateMI);
        this.add(expertMI);
        this.add(customMI);
        this.addSeparator();
//        this.add(marksMI);
//        this.add(colorMI);
//        this.add(soundMI);
//        this.addSeparator();
//        this.add(bestTimesMI);
//        this.addSeparator();
        this.add(exitMI);
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ms.dispose();
            System.exit(0);
        }
    }

    private class CustomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CustomWindow customWindow = new CustomWindow();
        }

        private class CustomWindow extends JFrame {
            private JTextField rowAnswer, columnAnswer, mineAnswer;

            public CustomWindow() {
                JPanel custom = new JPanel();
                JLabel rows = new JLabel("Rows: ");
                JLabel columns = new JLabel("Columns: ");
                JLabel mines = new JLabel("Mines: ");
                rowAnswer = new JTextField("" + model.getRows());
                columnAnswer = new JTextField("" + model.getColumns());
                mineAnswer = new JTextField("" + model.getRows());
                JButton okay = new JButton("OK");
                okay.addActionListener(new OkListener(this));

                custom.add(rows);
                custom.add(rowAnswer);
                custom.add(columns);
                custom.add(columnAnswer);
                custom.add(mines);
                custom.add(mineAnswer);

                this.setLayout(new GridLayout(3,2));
                this.setSize(new Dimension(300,150));
                getContentPane().add(custom, BorderLayout.CENTER);
                getContentPane().add(okay, BorderLayout.SOUTH);
                customMI.setState(false);
                setVisible(true);
            }

            private class OkListener implements ActionListener {
                private JFrame dialogWindow;

                public OkListener(JFrame dialogWindow) {
                    this.dialogWindow = dialogWindow;
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        customMI.setState(true);
                        beginnerMI.setState(false);
                        intermediateMI.setState(false);
                        expertMI.setState(false);
                        int r = Integer.parseInt(rowAnswer.getText());
                        int c = Integer.parseInt(columnAnswer.getText());
                        int m = Integer.parseInt(mineAnswer.getText());

                        if ((m < r * c) && r > 0 && c > 0) {
                            ms.resetGame(r, c, m);
                        } else {
                            throw new NumberFormatException();
                        }
                        dialogWindow.dispose();
                    } catch (NumberFormatException nf) {
                        JOptionPane.showMessageDialog(dialogWindow,
                                "Please enter correct numbers");
                    }
                }
            }
        }
    }

    private class NewGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ms.resetGame();
        }
    }

    private class DifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(beginnerMI)) {
                ms.resetGame(9, 9, 10);
                intermediateMI.setState(false);
                expertMI.setState(false);
            } else if(e.getSource().equals(intermediateMI)) {
                ms.resetGame(16,16,40);
                beginnerMI.setState(false);
                expertMI.setState(false);
            } else if(e.getSource().equals(expertMI)) {
                ms.resetGame(16,30,99);
                beginnerMI.setState(false);
                intermediateMI.setState(false);
            }
        }
    }

}
