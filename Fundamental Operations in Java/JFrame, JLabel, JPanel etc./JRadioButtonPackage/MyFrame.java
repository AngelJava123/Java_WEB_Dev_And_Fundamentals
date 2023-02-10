package com.company.JRadioButtonPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JRadioButton pizzaButton;
    JRadioButton hamburgerButton;
    JRadioButton hotDogButton;
    ImageIcon pizzaIcon;
    ImageIcon hamburgerIcon;
    ImageIcon hotDogIcon;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pizzaIcon = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\JRadioButtonPackage\\1f355.png");
        hamburgerIcon = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\JRadioButtonPackage\\1f354.png");
        hotDogIcon = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\JRadioButtonPackage\\1f32d.png");

        pizzaButton = new JRadioButton("pizza");
        hamburgerButton = new JRadioButton("hamburger");
        hotDogButton = new JRadioButton("hotDog");

        ButtonGroup group = new ButtonGroup();
        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotDogButton);

        pizzaButton.addActionListener(this);
        hamburgerButton.addActionListener(this);
        hotDogButton.addActionListener(this);

        pizzaButton.setIcon(pizzaIcon);
        hamburgerButton.setIcon(hamburgerIcon);
        hotDogButton.setIcon(hotDogIcon);

        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotDogButton);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pizzaButton) {
            System.out.println("You ordered pizza");
        } else if (e.getSource() == hamburgerButton) {
            System.out.println("You ordered a hamburger");
        } else if (e.getSource() == hotDogButton) {
            System.out.println("You ordered a hotDog");
        }
    }
}
