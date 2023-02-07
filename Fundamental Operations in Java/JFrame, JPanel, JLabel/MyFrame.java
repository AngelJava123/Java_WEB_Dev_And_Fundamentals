package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame(){
        this.setTitle("JFrame title goes here"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false); //prevent frame from being resized
        this.setSize(420, 420); //sets the x-dimension, and y-dimension of frame
        this.setVisible(true); //make frame visible

        //create an Image Icon
        ImageIcon image = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\istockphoto-186019678-612x612.jpg");
        this.setIconImage(image.getImage()); //change icon of the frame
        this.getContentPane().setBackground(new Color(190,150,120)); //change color of background
    }
}
