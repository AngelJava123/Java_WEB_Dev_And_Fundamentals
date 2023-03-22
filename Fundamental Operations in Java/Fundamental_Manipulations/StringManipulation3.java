package com.company.Fundamental_Manipulations;

import java.util.Scanner;

public class StringManipulation3 {

   /* Have the function StringChallenge(str) take the str parameter being passed and return
   a compressed version of the string using the Run-length encoding algorithm. This algorithm
   works by taking the occurrence of each repeating character and outputting that number along
   with a single character of the repeating sequence.

   For example: "wwwggopp" would return 3w2g1o2p. The string will not contain any numbers,
   punctuation, or symbols.

   Example:
   Input: "aabbcde"
   Output: 2a2b1c1d1e */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(StringChallenge(s.nextLine()));
    }

    public static String StringChallenge(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (i < str.length() - 1 && current == str.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(current);
                count = 1;
            }
        }
        return sb.toString();
    }
}
