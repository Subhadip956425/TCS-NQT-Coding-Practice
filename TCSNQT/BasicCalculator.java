/// ////////////////////////////
/// https://leetcode.com/problems/basic-calculator/description/


package TCSNQT;

import java.util.*;

public class BasicCalculator {

    public static int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);  ////////

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');  /////////
            }

            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }

            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }

            else if (ch == '(') {
                // Save state
                stack.push(result);
                stack.push(sign);

                // Reset
                result = 0;
                sign = 1;
            }

            else if (ch == ')') {
                result += sign * number;
                number = 0;

                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }

        result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(calculate(s));

        sc.close();
    }
}