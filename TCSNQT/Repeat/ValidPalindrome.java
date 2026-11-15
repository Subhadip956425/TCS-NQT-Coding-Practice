// https://leetcode.com/problems/valid-palindrome/description/


//Key Character Methods (java.lang.Character)
//static boolean isDigit(char ch): Determines if the character is a digit.
//static boolean isLetter(char ch): Determines if the character is a letter.
//static boolean isLetterOrDigit(char ch): Checks if the character is a letter or digit.
//static boolean isLowerCase(char ch): Checks if the character is lowercase.
//static boolean isUpperCase(char ch): Checks if the character is uppercase.
//static boolean isWhitespace(char ch): Determines if the character is whitespace (space, tab, newline).
//static char toLowerCase(char ch): Converts a character to lowercase.
//static char toUpperCase(char ch): Converts a character to


package TCSNQT.Repeat;

import java.util.Scanner;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare after converting to lowercase
            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input (full line)
        String s = sc.nextLine();

        // Function call
        boolean result = isPalindrome(s);

        // Output
        System.out.println(result);

        sc.close();
    }
}