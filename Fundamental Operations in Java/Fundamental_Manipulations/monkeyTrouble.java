package com.company;

import java.util.Scanner;

public class monkeyTrouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input example:
        //monkeyTrouble(true, true) → true
        //monkeyTrouble(false, false) → true
        //monkeyTrouble(true, false) → false

        String[] input = scanner.nextLine().split("\\(");
        String splitInput = input[1];
        String[] split = splitInput.split(", ");
        String aSmile = split[0];
        String[] splitA = split[1].split("\\) → ");
        String bSmile = splitA[0];

        if (isInTrouble(aSmile, bSmile)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    private static boolean isInTrouble(String aSmile, String bSmile) {

        if (aSmile.equals("true") && bSmile.equals("true") || aSmile.equals("false") && bSmile.equals("false")) {
            return true;
        }
        return false;
    }
}
