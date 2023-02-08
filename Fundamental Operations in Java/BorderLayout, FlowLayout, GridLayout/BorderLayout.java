package com.company;

import javax.swing.*;
import java.awt.*;

public class BorderLayout {
    public static void main(String[] args) {

        // Layout Manager = Defines the natural layout for components within a container

        // 3 common managers

        // BorderLayout = A BorderLayout places components in five areas: NORTH, SOUTH, WEST, EAST, CENTER
        //                All extra space is placed in the center area

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new java.awt.BorderLayout(10, 10));
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.black);
        panel2.setBackground(Color.darkGray);
        panel3.setBackground(Color.lightGray);
        panel4.setBackground(Color.gray);
        panel5.setBackground(Color.magenta);

        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));

        //--------------------- sub panels ------------------

        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();

        panel6.setBackground(Color.black);
        panel7.setBackground(Color.darkGray);
        panel8.setBackground(Color.gray);
        panel9.setBackground(Color.lightGray);
        panel10.setBackground(Color.white);

        panel5.setLayout(new java.awt.BorderLayout());

        panel6.setPreferredSize(new Dimension(50, 50));
        panel7.setPreferredSize(new Dimension(50, 50));
        panel8.setPreferredSize(new Dimension(50, 50));
        panel9.setPreferredSize(new Dimension(50, 50));
        panel10.setPreferredSize(new Dimension(50, 50));

        panel5.add(panel6, java.awt.BorderLayout.NORTH);
        panel5.add(panel7, java.awt.BorderLayout.WEST);
        panel5.add(panel8, java.awt.BorderLayout.EAST);
        panel5.add(panel9, java.awt.BorderLayout.SOUTH);
        panel5.add(panel10, java.awt.BorderLayout.CENTER);

        //--------------------- sub panels ------------------

        frame.add(panel1, java.awt.BorderLayout.NORTH);
        frame.add(panel2, java.awt.BorderLayout.WEST);
        frame.add(panel3, java.awt.BorderLayout.EAST);
        frame.add(panel4, java.awt.BorderLayout.SOUTH);
        frame.add(panel5, java.awt.BorderLayout.CENTER);
    }
}
