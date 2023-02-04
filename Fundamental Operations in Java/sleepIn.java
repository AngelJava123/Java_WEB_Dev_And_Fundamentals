package com.company;

import java.util.Scanner;

public class sleepIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input example: sleepIn(false, false)

        String[] data = scanner.nextLine().split("\\(");
        String commonData = data[1];
        String[] week = commonData.split(", ");
        String weekday = week[0];
        String vacation = week[1].replaceAll("\\)","");

        if (isItValid(weekday, vacation)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    private static boolean isItValid(String weekday, String vacation) {
        if (weekday.equals("false") || vacation.equals("true")) {
            return true;
        }
        return false;
    }
}
