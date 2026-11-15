// Need to repeat
// https://leetcode.com/problems/remove-outermost-parentheses/description/

import java.util.*;

public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                if (balance > 0) {
                    result.append(ch);
                }
                balance++;
            } else { // ')'
                balance--;
                if (balance > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine(); // TCS-style input

        System.out.println(removeOuterParentheses(s));

        sc.close();
    }
}