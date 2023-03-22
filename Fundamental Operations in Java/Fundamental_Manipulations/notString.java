package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class notString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\((?<word>\"[a-z]* ?[a-z]*\")\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String word = matcher.group("word");

            if (word.length() >= 5) {
                String substring = word.substring(1, 4);
                if (substring.equals("not")) {
                    System.out.println(word);
                }
            } else {
                word = word.replaceAll("\"", "");
                System.out.println("\"not " + word + "\"");
            }
        }
    }
}
