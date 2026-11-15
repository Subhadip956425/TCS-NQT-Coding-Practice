/// ///////////////////////////////
/// https://leetcode.com/problems/basic-calculator-ii/description/


package TCSNQT.Repeat;

import java.util.Scanner;

public class BasicCalculatorII {

    public static int calculate(String s) {
        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char operator = '+';   ///////////////////////

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {  /// //////////////

                if (operator == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;

                } else if (operator == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;

                } else if (operator == '*') {
                    lastNumber = lastNumber * currentNumber;

                } else if (operator == '/') {
                    lastNumber = lastNumber / currentNumber;
                }

                operator = ch;
                currentNumber = 0;
            }
        }

        result += lastNumber;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine(); // TCS-style input

        System.out.println(calculate(s));

        sc.close();
    }
}