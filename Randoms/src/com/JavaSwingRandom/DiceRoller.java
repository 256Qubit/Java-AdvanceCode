package com.JavaSwingRandom;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DiceRoller extends JFrame implements ActionListener {
    private JButton rollButton;
    private JLabel resultLabel1, resultLabel2, totalLabel;
    private Random rand;

    public DiceRoller() {
        super("掷色子");
        setLayout(new FlowLayout());
        rollButton = new JButton("掷色子");
        resultLabel1 = new JLabel("第一个色子的结果：");
        resultLabel2 = new JLabel("第二个色子的结果：");
        totalLabel = new JLabel("总和：");
        add(rollButton);
        add(resultLabel1);
        add(resultLabel2);
        add(totalLabel);
        rollButton.addActionListener(this);
        rand = new Random();
        setSize(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int roll1 = rand.nextInt(6) + 1;
        int roll2 = rand.nextInt(6) + 1;
        resultLabel1.setText("第一个色子的结果：" + roll1);
        resultLabel2.setText("第二个色子的结果：" + roll2);
        totalLabel.setText("总和：" + (roll1 + roll2));
    }

    public static void main(String[] args) {
        new DiceRoller();
    }
}
