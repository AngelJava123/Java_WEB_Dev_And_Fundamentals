package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class teen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\((?<n1>-?[0-9]+), (?<n2>-?[0-9]+), (?<n3>-?[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int n1 = Integer.parseInt(matcher.group("n1"));
            int n2 = Integer.parseInt(matcher.group("n2"));
            int n3 = Integer.parseInt(matcher.group("n3"));

            System.out.println(getNumbs(n1,n2,n3));
        }
    }
    private static boolean getNumbs(int n1, int n2, int n3) {

        return  ((n1 >= 13 && n1 <= 19) || (n2 >= 13 && n2 <= 19) || (n3 >= 13 && n3 <= 19));
    }
}
