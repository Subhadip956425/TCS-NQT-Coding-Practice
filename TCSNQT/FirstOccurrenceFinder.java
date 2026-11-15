// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

package TCSNQT;

import java.util.*;

public class FirstOccurrenceFinder {

    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Edge case
        if (m > n) return -1;

        // Try every possible starting index
        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // Match characters
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {   /// //////
                j++;
            }

            // Full match found
            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        String haystack = sc.next();
        String needle = sc.next();

        int result = strStr(haystack, needle);

        System.out.println(result);
    }
}