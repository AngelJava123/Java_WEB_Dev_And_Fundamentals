package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    JButton button;
    JLabel label;

    MyFrame() {
        ImageIcon icon1 = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\istockphoto-186019678-612x612.jpg");

        label = new JLabel();
        label.setIcon(icon1);
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(100, 100, 250, 100);
        button.addActionListener(e -> label.setVisible(true));
        button.setText("Bro");
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(-15);
        button.setForeground(Color.cyan);
        button.setBackground(Color.gray);
        // button.setBorder(BorderFactory.createEtchedBorder());

        this.setTitle("JFrame title goes here"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false); //prevent frame from being resized
        this.setSize(420, 420); //sets the x-dimension, and y-dimension of frame
        this.setVisible(true); //make frame visible
        this.setLayout(null);
        this.add(button);
        this.add(label);

        //create an Image Icon
        ImageIcon image = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\istockphoto-186019678-612x612.jpg");
        this.setIconImage(image.getImage()); //change icon of the frame
        this.getContentPane().setBackground(new Color(190, 150, 120)); //change color of background

        button.setIcon(image);
    }
}
