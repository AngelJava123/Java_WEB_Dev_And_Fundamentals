package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EncryptionProgram {

    private final Scanner scanner;
    private final ArrayList<Character> list;
    private ArrayList<Character> shuffledlist;
    private char character;
    private char[] letters;

    public EncryptionProgram() {

        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        shuffledlist = new ArrayList<>();
        character = ' ';

        newKey();
        askQuestion();

    }

    private void askQuestion() {

        while (true) {
            System.out.println("********************************************");
            System.out.println("What do you want to do?");
            System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response) {
                case 'N' -> newKey();
                case 'G' -> getKey();
                case 'E' -> encrypt();
                case 'D' -> decrypt();
                case 'Q' -> quit();
                default -> System.out.println("Not a valid answer");
            }
        }
    }

    private void newKey() {

        character = ' ';
        list.clear();
        shuffledlist.clear();

        for (int i = 32; i < 127; i++) {
            list.add(character);
            character++;
        }

        shuffledlist = new ArrayList<>(list);
        Collections.shuffle(shuffledlist);
        System.out.println("A new key has been generated");
    }

    private void getKey() {
        System.out.println("Key: ");
        for (Character x : list) {
            System.out.print(x);
        }
        System.out.println();
        for (Character x : shuffledlist) {
            System.out.print(x);
        }
        System.out.println();
    }

    private void encrypt() {

        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)) {
                    letters[i] = shuffledlist.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted: ");
        for (char x : letters) {
            System.out.print(x);
        }
        System.out.println();
    }

    private void decrypt() {

        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < shuffledlist.size(); j++) {
                if (letters[i] == shuffledlist.get(j)) {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted: ");
        for (char x : letters) {
            System.out.print(x);
        }
        System.out.println();
    }

    private void quit() {
        System.out.println("Thank you, have a nice day bro!");
        System.exit(0);
    }
}
