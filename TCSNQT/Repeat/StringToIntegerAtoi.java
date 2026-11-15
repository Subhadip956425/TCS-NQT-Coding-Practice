/// //////////////////////////////////
/// https://leetcode.com/problems/string-to-integer-atoi/description/


package TCSNQT.Repeat;

import java.util.Scanner;

public class StringToIntegerAtoi {

    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        int result = 0;

        // Step 1: Skip whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Handle overflow BEFORE adding digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {   /////////
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;  ////////
            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input (full string)
        String s = sc.nextLine();

        int result = myAtoi(s);

        System.out.println(result);
    }
}