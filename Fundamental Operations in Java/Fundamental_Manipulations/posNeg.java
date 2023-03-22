package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class posNeg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\((?<n1>-?[0-9]+), (?<n2>-?[0-9]), (?<parameter>[a-z]{4,})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int n1 = Integer.parseInt(matcher.group("n1"));
            int n2 = Integer.parseInt(matcher.group("n2"));
            String parameter = matcher.group("parameter");

            System.out.println(getValue(n1, n2, parameter));
        }
    }
    private static boolean getValue(int n1, int n2, String parameter) {

        if (parameter.equals("true")) {
            return n1 < 0 && n2 < 0;
        } else {
            return (n1 > 0 && n2 < 0) || (n1 < 0 && n2 > 0);
        }
    }
}
