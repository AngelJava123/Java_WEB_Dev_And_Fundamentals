package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class makes10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //makes10(9, 10) → true
        //makes10(9, 9) → false
        //makes10(1, 9) → true

        String regex = "\\((?<n1>-?[0-9]+), (?<n2>-?[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int n1 = Integer.parseInt(matcher.group("n1"));
            int n2 = Integer.parseInt(matcher.group("n2"));

            System.out.println(isItEqual(n1, n2));
        }
    }
    private static boolean isItEqual(int n1, int n2) {

        if (n1 == 10 || n2 == 10 || n1 + n2 == 10) {
            return true;
        }
        return false;
    }
}
