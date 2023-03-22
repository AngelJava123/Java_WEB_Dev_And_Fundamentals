package com.company.Fundamental_Manipulations;

import java.util.Scanner;

public class MathematicalManipulation1 {

    /* Have the function MathChallenge(num1, num2) take both parameters being passed and return the
   Greatest Common Factor. That is, return the greatest number that evenly goes into both numbers with
   no reminder. For example: 12 and 16 both are devisible by 1, 2, and 4 so the output should be 4. Tha range
   for both parameters will be from 1 to 10^3.

   Example:
   Input: 7 & num2 = 3
   Output: 1 */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1 = Integer.parseInt(s.nextLine());
        int num2 = Integer.parseInt(s.nextLine());
        System.out.println(MathChallenge(num1, num2));
    }

    public static int MathChallenge(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

}
