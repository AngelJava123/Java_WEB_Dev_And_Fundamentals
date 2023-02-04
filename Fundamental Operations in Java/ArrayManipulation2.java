package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation2 {

    /* Have the function ArrayChallenge(arr) take the array of integers stored in arr and return the minimum number of
     integers needed to make the contents of arr consecutive from the lowest number to the highest number. For example:
     If arr contains [4, 8, 6] then the output should be 2 because two numbers need to be added to the array (5 and 7)
     to make it a consecutive array of numbers from 4 to 8. Negative numbers may be entered as parameters and no array
     will have less than 2 elements.

     import java.util.*;
     import java.io.*;

class Main {

  public static int ArrayChallenge(int[] arr) {
    // code goes here
    return arr[0];
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(ArrayChallenge(s.nextLine()));
  }
} */

    //ANSWER:

    public static int ArrayChallenge(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = arr[0]; i < arr[arr.length - 1]; i++) {
            if (!contains(i, arr)) {
                count++;
            }
        }
        return count;
    }

    public static boolean contains(int i, int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        // System.out.print(ArrayChallenge(s.nextLine()));
    }

    /* In this code, I first sort the array in ascending order, then I iterate through the range of the lowest and
     highest number in the array and check if each number in that range is present in the array. If it is not present,
     I increment a count variable. Finally, I return the count variable which represents the minimum number of integers
     needed to make the contents of arr consecutive from the lowest number to the highest number. Note that the function
     nextLine() doesn't work with arrays, You should use nextInt() instead, also you should pass the array as an argument
     to the function.
     */
}
