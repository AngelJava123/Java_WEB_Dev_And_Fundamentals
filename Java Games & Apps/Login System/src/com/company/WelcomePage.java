package com.company;

import javax.swing.*;
import java.awt.*;

public class WelcomePage {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello");

    public WelcomePage(String userID) {

        welcomeLabel.setBounds(0,0,200,35);
        welcomeLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
        welcomeLabel.setText("Hello " + userID);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
