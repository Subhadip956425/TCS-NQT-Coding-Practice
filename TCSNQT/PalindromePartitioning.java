/// /////////////////////////////////
/// https://leetcode.com/problems/palindrome-partitioning/description/


package TCSNQT;

import java.util.*;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, 
                                  List<String> current, 
                                  List<List<String>> result) {

        // If reached end → store result
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all substrings
        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {
                // Choose
                current.add(s.substring(start, end + 1));

                // Explore
                backtrack(s, end + 1, current, result);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        String s = sc.next();

        List<List<String>> result = partition(s);

        // Output
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}