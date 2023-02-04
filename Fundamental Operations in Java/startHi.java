package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class startHi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\(\"(?<word>[A-Za-z]* ?[A-Za-z]*)\"\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String word = matcher.group("word");

            System.out.println(getWord(word));
        }
    }
    private static boolean getWord(String str) {

        if (str.equals("")) {
            return false;
        } else if (str.length() == 1) {
            return false;
        } else {
            String substring = str.substring(0, 2);

            if (substring.equals("hi")) {
                return true;
            }
        }
        return false;
    }
}
