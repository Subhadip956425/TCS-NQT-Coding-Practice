// Need to repeat
// https://leetcode.com/problems/longest-valid-parentheses/

package TCSNQT;

import java.util.*;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        // Base index
        stack.push(-1);    //////////////////////////////////////

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else {
                stack.pop();

                if (stack.isEmpty()) {
                    // New base
                    stack.push(i);
                } else {
                    // Valid substring length
                    maxLength = Math.max(maxLength, i - stack.peek());  ///////////////////////
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        String s = sc.nextLine();

        int result = longestValidParentheses(s);

        System.out.println(result);
    }
}