package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class front22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\(\"(?<word>[A-Za-z]*)\"\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String word = matcher.group("word");

            System.out.println("\"" + getString(word) + "\"");
        }
    }

    private static String getString(String str) {

        StringBuilder firstTwoChars = new StringBuilder();

        if (str.equals("")) {
            return str;
        } else if (str.length() < 2) {
            return str + str + str;
        } else {
            firstTwoChars.append(str.charAt(0));
            firstTwoChars.append(str.charAt(1));

            StringBuilder newWord = new StringBuilder(str);

            newWord.insert(0, firstTwoChars);
            newWord.append(firstTwoChars);

            str = newWord.toString();
        }
        return str;
    }
}
