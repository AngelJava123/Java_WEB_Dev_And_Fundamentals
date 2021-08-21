package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class or35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\((?<number>[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group("number"));

            System.out.println(getWord(number));
        }
    }
    private static boolean getWord(int number) {

        if (number % 3 == 0 || number % 5 == 0) {
            return true;
        }
        return false;
    }
}
