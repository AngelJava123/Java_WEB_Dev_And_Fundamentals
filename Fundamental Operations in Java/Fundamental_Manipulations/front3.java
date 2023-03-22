package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class front3 {
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

        StringBuilder newWord = new StringBuilder();

        if (word.equals("")) {
            return word;
        } else if (word.length() < 3) {
            newWord.append(word.repeat(3));
        } else {
           String substring = word.substring(0, 3);
            newWord.append(substring.repeat(3));
        }
        word = newWord.toString();
        return word;
    }
}
