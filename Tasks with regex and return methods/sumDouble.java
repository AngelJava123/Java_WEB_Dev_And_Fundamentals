package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sumDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input Example:
        //sumDouble(1, 2) → 3
        //sumDouble(3, 2) → 5
        //sumDouble(2, 2) → 8

        String input = scanner.nextLine();

        String regex = "\\((?<n1>-?[0-9]), (?<n2>-?[0-9])\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int number1 = Integer.parseInt(matcher.group("n1"));
            int number2 = Integer.parseInt(matcher.group("n2"));
            System.out.println(isItEqual(number1, number2));
        }
    }
    private static int isItEqual(int number1, int number2) {

        if (number1 == number2) {
            return (number1 + number2) * 2;
        }
        return number1 + number2;
    }
}
