package String;

import java.util.*;

public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] remove = new boolean[s.length()];

        // Mark positions to remove:
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);              // possible unmatched '('
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();           // matched with a '('
                } else {
                    remove[i] = true;      // unmatched ')'
                }
            }
        }

        // Any indices left in stack are unmatched '(' -> mark them
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        // Build result skipping marked indices
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "())()(((";
        System.out.println(minRemoveToMakeValid(s)); // -> "()()"

        // Additional tests
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)")); // -> "lee(t(c)o)de"
        System.out.println(minRemoveToMakeValid("a)b(c)d"));       // -> "ab(c)d"
    }
}
