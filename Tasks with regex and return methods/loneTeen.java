package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loneTeen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\((?<n1>-?[0-9]+), (?<n2>-?[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int n1 = Integer.parseInt(matcher.group("n1"));
            int n2 = Integer.parseInt(matcher.group("n2"));

            System.out.println(getValue(n1, n2));
        }
    }
    private static boolean getValue(int n1, int n2) {
        return  ((n1 >= 13 && n1 <= 19) && !(n2 >= 13 && n2 <= 19)) ||
                (!(n1 >= 13 && n1 <= 19) && (n2 >= 13 && n2 <= 19));
    }
}
