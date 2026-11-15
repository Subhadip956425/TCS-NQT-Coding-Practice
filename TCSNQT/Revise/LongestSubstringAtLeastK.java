///  /////////////////////////
/// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/


package TCSNQT.Revise;

import java.util.Scanner;

public class LongestSubstringAtLeastK {

    public static int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private static int helper(String s, int start, int end, int k) {

        if (end - start < k) return 0;   ///////////////

        int[] freq = new int[26];

        // Count frequency
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int mid = start; mid < end; mid++) {

            if (freq[s.charAt(mid) - 'a'] < k) {  ////////////////////

                int next = mid + 1;

                // Skip consecutive invalid chars
                while (next < end && freq[s.charAt(next) - 'a'] < k) {
                    next++;
                }

                // Split into two parts
                return Math.max(   //////////////////
                    helper(s, start, mid, k),
                    helper(s, next, end, k)
                );
            }
        }

        // All characters valid
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int k = sc.nextInt();

        int result = longestSubstring(s, k);

        System.out.println(result);
    }
}