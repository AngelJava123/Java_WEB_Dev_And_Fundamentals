package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation1 {

    /* 2.Have the function ArrayChallenge(arr) take the array of numbers stored in arr which will contain integers that
     represent the amount in dollars that a single stock is worth, and return the maximum profit that could have been
     made by buying stock on day x and selling stock on day y where y > x. For example: if arr is
     [44, 30, 24, 32, 35, 30, 40, 38, 15] then your program should return 16 because at index 2 the stock was worth $24
     and at index 6 the stock was then worth $40, so if you bought the stock at 24 and sold it at 40, you would have
     made a profit of $16, which is the maximum profit that could have been made with this list of stock prices. If there
     is not profit that could have been made with the stock prices, then your program should return -1.
     For example: arr is [10, 9, 8, 2] then your program should return -1.

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

    // ANSWER:
    // Here is an example of a Java function that implements the logic you described:

    public static int ArrayChallenge(int[] arr) {
        int maxProfit = -1;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = Arrays.stream(s.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.print(ArrayChallenge(arr));
    }

    /* In this example, the function ArrayChallenge(int[] arr) takes an array of integers as an input. It initializes
     two variables maxProfit and minPrice to -1 and Integer.MAX_VALUE respectively. We use a for loop to iterate through
     the elements of the input array. For each element, we compare it with the minPrice and update it if the current
     element is smaller. Then we calculate the profit by subtracting the minPrice from current element and compare it
     with maxProfit and update it if the profit is larger. Finally the function returns the maxProfit. In the main method,
     we use the Scanner class to read the input array from console, then we use the Arrays.stream() method to convert the
     input string to an array of integers, and finally call the ArrayChallenge method and print the result. Please note
     that this is just one way to solve the problem, there are other ways to optimize the solution.
     */
}
