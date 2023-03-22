package com.company.Fundamental_Manipulations;

import java.util.Scanner;

public class StringManipulation2 {

    /* Have the function StringChallenge(strArr) read the array of strings stored in strArr, which will contain two elements,
     the first will be a positive decimal number and the second element will be a binary number. Your goal is to determine
      how many digits in the binary number need to be changed to represent the decimal number correctly
       (either 0 change to 1 or vice versa). For example: if strArr is ["56", "011000"] then your program should return 1
        because only 1 digit needs to change in the binary number (the first zero needs to become a 1) to correctly
        represent 56 in binary. */

    // ANSWER:

    public static String StringChallenge(String[] strArr) {
        int decimal = Integer.parseInt(strArr[0]);
        String binary = Integer.toBinaryString(decimal);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) != strArr[1].charAt(i)) {
                count++;
            }
        }
        return Integer.toString(count);
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        //  System.out.print(StringChallenge(s.nextLine()));
    }

    /* Here's how the code works:

    We first convert the decimal number from the first element of the input array to binary using the Integer.toBinaryString() method.
    We then compare each digit of the binary number to the corresponding digit in the binary number from the second element of the input array.
    If the digits are different, we increment a counter.
    Finally, we return the count as a string using Integer.toString(count).
    So, when you call StringChallenge(new String[] {"5624", "0010111111001"}) the output should be 2. */

}
