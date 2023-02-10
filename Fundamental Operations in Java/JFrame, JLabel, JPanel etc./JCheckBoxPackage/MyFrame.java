package com.company.JCheckBoxPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JCheckBox checkBox;
    ImageIcon xIcon;
    ImageIcon checkIcon;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        xIcon = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\JCheckBoxPackage\\png-transparent-x-red-mark-incorrect-thumbnail.png");
        checkIcon = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\JCheckBoxPackage\\png-transparent-thumb-signal-facebook-social-media-green-thumbs-up-hand-grass-thumb-signal-thumbnail.png");

        button = new JButton();
        button.setText("submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("I am not a robot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));
        checkBox.setIcon(xIcon);
        checkBox.setSelectedIcon(checkIcon);

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println(checkBox.isSelected());
        }
    }
}



