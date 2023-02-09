package com.company;

public class JFrameClass {
    public static void main(String[] args) {

        // JFrame = a GUI window to add components to

        /*
        JFrame frame = new JFrame(); //creates a frame
        frame.setTitle("JFrame title goes here"); //sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(false); //prevent frame from being resized
        frame.setSize(420, 420); //sets the x-dimension, and y-dimension of frame
        frame.setVisible(true); //make frame visible

        //create an Image Icon
        ImageIcon image = new ImageIcon("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\istockphoto-186019678-612x612.jpg");
        frame.setIconImage(image.getImage()); //change icon of the frame
        frame.getContentPane().setBackground(new Color(190,150,120)); //change color of background
         */

        MyFrame myFrame = new MyFrame();
    }
}
