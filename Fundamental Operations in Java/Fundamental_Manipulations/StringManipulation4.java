package com.company.Fundamental_Manipulations;

import java.util.Scanner;

public class StringManipulation4 {

    /* Have the function StringChallenge(str) take the str parameter being passed and return it in
   proper camel case format where the first letter of each word is capitalized (excluding the first letter)
   The string will only contain letters and some combination of delimiter punctuation characters separating each word

   For example: If str is "BOB loves-coding" then your program should return the string bobLovesCoding.

   Example:
   Input: "cats AND*Dogs-are Awesome"
   Output: catsAndDogsAreAwesome */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(StringChallenge(s.nextLine()));
    }

    public static String StringChallenge(String str) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetter(c)) {
                if (capitalize) {
                    sb.append(Character.toUpperCase(c));
                    capitalize = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            } else {
                capitalize = true;
            }
        }

        return sb.toString();
    }
}
