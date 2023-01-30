package com.company;

import java.util.Scanner;

public class StringManipulation1 {

    /* Have the function Manipulate(str) take the str parameter being passed and return the count of words with
    length greater than or equal to 4 letters, followed by space and the words concatenated with "-" and capitalized
    first letter. For example the string is "Hello world" the output should be "2 Hello-World", it the string is "I can run"
     the output should be "0 ". (do not write the quotes, they are just for visual clues)

    public static String StringManipulation(String str) {
        // code goes here
        return str;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringManipulation(s.nextLine()));
    }
    */

    // ANSWER:
    // Here is an example of how you could implement the StringManipulation function using the String and StringBuilder classes:

    public static String StringManipulation(String str) {

        String[] words = str.split(" "); // split the input string into an array of words
        int count = 0; // initialize a count variable to keep track of words with 4 or more letters
        StringBuilder result = new StringBuilder(); // use a StringBuilder to build the final result
        for (String word : words) {
            if (word.length() >= 4) {
                count++; // increment count if the current word has 4 or more letters
                result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append("-"); // add the word to the result
            }
        }
        if (count == 0) {
            return "0 ";
        } else {
            // remove the last "-" character from the result and return the count and result
            return count + " " + result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringManipulation(s.nextLine()));
    }

    /* This function first splits the input string into an array of words using the split() method. Then, it uses a for-each
     loop to iterate over the words and checks if the length of each word is greater than or equal to 4. If it is, it increments
      a count variable and adds the word to a StringBuilder, capitalizing the first letter and adding a "-" after the word.
       If there are no words with 4 or more letters, it returns "0 "; otherwise it returns the count and the concatenated
       and modified words. */
}
