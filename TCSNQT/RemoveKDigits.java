////////////////////////////////////
/// https://leetcode.com/problems/remove-k-digits/description/

package TCSNQT;

import java.util.*;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {   ////////////

            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {   ///////
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // If k still remains, remove from end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // Edge case
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.next();  // TCS style input
        int k = sc.nextInt();

        System.out.println(removeKdigits(num, k));

        sc.close();
    }
}