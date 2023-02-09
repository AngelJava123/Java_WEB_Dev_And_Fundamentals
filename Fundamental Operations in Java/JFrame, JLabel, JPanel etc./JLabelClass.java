package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JLabelClass {
    public static void main(String[] args) {

        // JLabel = a GUI display area for a string of text, an image, or both

        ImageIcon image = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\istockphoto-186019678-612x612.jpg");
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        JLabel label = new JLabel(); //create a label
        label.setText("Bro do you even lift?"); //set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image icon
        label.setVerticalTextPosition(JLabel.CENTER); //set text TOP, CENTER, BOTTOM
        label.setForeground(Color.black);
        label.setFont(new Font("MV Boli", Font.BOLD, 30)); //set font of text
        label.setIconTextGap(100); //set gap of text to image
        label.setBackground(Color.black); //set background color
        label.setOpaque(true); //display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
        // label.setBounds(100, 0, 500, 500); //set x, y position within frame as well as dimensions

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(500, 500);
        // frame.setLayout(null);
        frame.setVisible(true);

        frame.add(label);
        frame.pack();
    }
}
