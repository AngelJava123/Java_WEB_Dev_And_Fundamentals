package com.company.ProgressBarPackage;

import javax.swing.*;
import java.awt.*;

public class ProgressBarClass {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();

    ProgressBarClass() throws InterruptedException {

        bar.setValue(0);
        bar.setBounds(0, 0, 420, 50);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(Color.red);
        bar.setBackground(Color.black);

        frame.add(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    public void fill() throws InterruptedException {
        int counter = 0;

        while (counter <= 100) {

            bar.setValue(counter);
            Thread.sleep(50);
            counter += 1;
        }
        bar.setString("Done! :)");
    }
}
