package com.company.Fundamental_Manipulations;

import java.util.Scanner;

public class StringManipulation5 {

    /* Have the function StringChallenge(str) read the str parameter being passed which will contain the
   written out version of the numbers 0-9 and the words "minus" or "plus" and convert the
   expression into an actual final number written out as well. For example: If str is
   "foursixminustwotwoplusonezero" then this converts to "46 - 22 + 10" which evaluates to 34
   and your program should return the final string threefour. If your final answer is negative
   it should include the word "negative"

   Example:
   Input: "onezeropluseight"
   Output: oneeight */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(StringChallenge(s.nextLine()));
    }

    public static String StringChallenge(String str) {
        StringBuilder build = new StringBuilder();
        StringBuilder equation = new StringBuilder();
        boolean isNegative = false;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            build.append(currentChar);

            switch (build.toString()) {
                case "zero" -> {
                    equation.append("0");
                    build = new StringBuilder();
                }
                case "one" -> {
                    equation.append("1");
                    build = new StringBuilder();
                }
                case "two" -> {
                    equation.append("2");
                    build = new StringBuilder();
                }
                case "three" -> {
                    equation.append("3");
                    build = new StringBuilder();
                }
                case "four" -> {
                    equation.append("4");
                    build = new StringBuilder();
                }
                case "five" -> {
                    equation.append("5");
                    build = new StringBuilder();
                }
                case "six" -> {
                    equation.append("6");
                    build = new StringBuilder();
                }
                case "seven" -> {
                    equation.append("7");
                    build = new StringBuilder();
                }
                case "eight" -> {
                    equation.append("8");
                    build = new StringBuilder();
                }
                case "nine" -> {
                    equation.append("9");
                    build = new StringBuilder();
                }
                case "plus" -> {
                    equation.append("+");
                    build = new StringBuilder();
                }
                case "minus" -> {
                    equation.append("-");
                    build = new StringBuilder();
                }
            }
        }
        // TODO convert the string numbers into integers.

        String[] parts = equation.toString().split("\\+");
        int result = 0;

        for (String part : parts) {
            if (part.contains("-")) {
                String[] subParts = part.split("-");
                int subResult = Integer.parseInt(subParts[0]);

                for (int i = 1; i < subParts.length; i++) {
                    subResult -= Integer.parseInt(subParts[i]);
                }

                result += subResult;
            } else {
                result += Integer.parseInt(part);
            }
        }

        StringBuilder builder = new StringBuilder();

        if (result < 0) {
            builder.append("negative");
        }

        String stringResult = String.valueOf(result);

        for (int i = 0; i < stringResult.length(); i++) {
            char currentChar = stringResult.charAt(i);

            switch (currentChar) {
                case 'o' -> {
                    builder.append("zero");
                }
                case '1' -> {
                    builder.append("one");
                }
                case '2' -> {
                    builder.append("two");
                }
                case '3' -> {
                    builder.append("three");
                }
                case '4' -> {
                    builder.append("four");
                }
                case '5' -> {
                    builder.append("five");
                }
                case '6' -> {
                    builder.append("six");
                }
                case '7' -> {
                    builder.append("seven");
                }
                case '8' -> {
                    builder.append("eight");
                }
                case '9' -> {
                    builder.append("nine");
                }
            }
        }
        return builder.toString();
    }
}
