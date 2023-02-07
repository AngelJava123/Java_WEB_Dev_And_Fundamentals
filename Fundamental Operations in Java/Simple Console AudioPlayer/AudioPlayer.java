package com.company;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AudioPlayer {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);

        File file = new File("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\AMBForst_Forest (ID 0100)_BSB.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        String response = "";

        while (!response.equals("Q")) {
            System.out.println("P = play, S = stop, R = Reset, Q = Quit");
            System.out.println("Enter your choice: ");

            response = scanner.next();
            response = response.toUpperCase();

            switch (response) {
                case "P" -> clip.start();
                case "S" -> clip.stop();
                case "R" -> clip.setMicrosecondPosition(0);
                case "Q" -> clip.close();
                default -> System.out.println("Not a valid response");
            }
        }
        System.out.println("Byeeee! See you soon :P");
    }
}
