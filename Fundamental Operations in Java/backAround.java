package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class backAround {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\(\"(?<word>[A-Za-z]*)\"\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String word = matcher.group("word");

            System.out.println("\"" + getWord(word) + "\"");
        }
    }
    private static String getWord(String word) {

        char first = word.charAt(word.length()-1);

        StringBuilder newWord = new StringBuilder();

        newWord.append(word);
        newWord.insert(0, first);
        newWord.insert(word.length(), first);

        word = newWord.toString();
        return word;
    }
}
