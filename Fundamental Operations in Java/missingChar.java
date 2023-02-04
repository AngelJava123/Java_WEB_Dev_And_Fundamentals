package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class missingChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\(\"(?<word>[a-z]+)\", (?<number>[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String word = matcher.group("word");
            int number = Integer.parseInt(matcher.group("number"));

            getChar(word,number);
        }
    }
    private static void getChar(String word, int number) {

        StringBuilder charWord = new StringBuilder(word);

        charWord.deleteCharAt(number);

        System.out.println("\"" + charWord + "\"");
    }
}
