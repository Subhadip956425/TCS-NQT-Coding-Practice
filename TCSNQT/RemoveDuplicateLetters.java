/// //////////////////////////////
/// https://leetcode.com/problems/remove-duplicate-letters/description/

package TCSNQT;

import java.util.*;

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];

        // Store last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (visited[ch - 'a']) continue;   /////////

            while (!stack.isEmpty() &&
                   ch < stack.peek() &&
                   lastIndex[stack.peek() - 'a'] > i) {   ///////////////

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(removeDuplicateLetters(s));

        sc.close();
    }
}