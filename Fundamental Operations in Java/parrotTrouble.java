package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class parrotTrouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\((?<tf>[a-z]{4,}), (?<number>-?[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String tf = matcher.group("tf");
            int number = Integer.parseInt(matcher.group("number"));

            System.out.println(isItInTrouble(tf, number));
        }
    }
    private static boolean isItInTrouble(String tf, int number) {

        if (tf.equals("true") && (number < 7 || number > 20) ) {
            return true;
        }
        return false;
    }
}
