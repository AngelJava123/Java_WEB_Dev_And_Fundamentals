package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class icyHot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\((?<n1>-?[0-9]+), (?<n2>-?[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int temp1 = Integer.parseInt(matcher.group("n1"));
            int temp2 = Integer.parseInt(matcher.group("n2"));

            System.out.println(getTemp(temp1, temp2));
        }
    }
    private static boolean getTemp(int temp1, int temp2) {
        return (temp1 > 100 && temp2 < 0) || (temp1 < 0 && temp2 > 100);
    }
}
