package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class frontBack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\(\"(?<word>[a-z]*)\"\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String word = matcher.group("word");
            System.out.println("\"" + getReplace(word) + "\"");
        }
    }
    private static String getReplace(String word) {

        if (word.equals("")) {
            return "";
        } else if (word.length() == 1) {
            return word;
        } else {
            String subsFront = word.substring(0,1);
            String subsEnd = word.substring(word.length()-1);

            StringBuilder wordReplacement = new StringBuilder(word);

            wordReplacement.replace(0, 1, subsEnd);
            wordReplacement.replace(word.length()-1, word.length(), subsFront);

            word = wordReplacement.toString();
        }
        return word;
    }
}
