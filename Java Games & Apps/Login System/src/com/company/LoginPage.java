package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("user ID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLAbel = new JLabel();
    Map<String, String> loginInfo;

    public LoginPage(Map<String, String> loginInfoOriginal) {

        loginInfo = loginInfoOriginal;

        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLAbel.setBounds(125, 250, 250, 35);
        messageLAbel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLAbel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (loginInfo.containsKey(userID)) {
                if (loginInfo.get(userID).equals(password)) {
                    messageLAbel.setForeground(Color.green);
                    messageLAbel.setText("Login successful");
                    frame.dispose();
                    new WelcomePage(userID);
                } else {
                    messageLAbel.setForeground(Color.red);
                    messageLAbel.setText("Wrong password");
                }
            } else {
                messageLAbel.setForeground(Color.red);
                messageLAbel.setText("Username not found");
            }
        }
    }
}
