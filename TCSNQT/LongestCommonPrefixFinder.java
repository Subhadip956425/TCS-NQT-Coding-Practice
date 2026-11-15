// Repeat
// https://leetcode.com/problems/longest-common-prefix/description/

// Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.


package TCSNQT;

import java.util.*;

public class LongestCommonPrefixFinder {

    public static String longestCommonPrefix(String[] strs) {

        // Edge case
        if (strs == null || strs.length == 0) return "";

        // Take first string as reference
        for (int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);

            // Compare with all other strings
            for (int j = 1; j < strs.length; j++) {

                // If index out of bound OR mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {  /// ///
                    return strs[0].substring(0, i);
                }
            }
        }

        // If no mismatch found
        return strs[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        int n = sc.nextInt();
        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        String result = longestCommonPrefix(strs);

        System.out.println(result);

        sc.close();
    }
}