package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class diff21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        // Example input:
        //diff21(19) → 2
        //diff21(10) → 11
        //diff21(21) → 0

        String regex = "\\((?<number>-?[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group("number"));
            System.out.println(isDiff(number));
        }
    }
    private static int isDiff(int number) {

        if (number < 21) {
            return 21 - number;
        } else {
            return (number - 21) * 2;
        }
    }
}
