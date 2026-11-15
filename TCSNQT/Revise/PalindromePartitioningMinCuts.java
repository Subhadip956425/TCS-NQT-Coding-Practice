/// ///////////////////////////////
/// https://leetcode.com/problems/palindrome-partitioning-ii/description/


package TCSNQT.Revise;

import java.util.Scanner;

public class PalindromePartitioningMinCuts {

    public static int minCut(String s) {
        int n = s.length();

        boolean[][] isPal = new boolean[n][n];

        // Step 1: Precompute palindrome table
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                if (gap == 0) {
                    isPal[i][j] = true;
                } 
                else if (gap == 1) {
                    isPal[i][j] = (s.charAt(i) == s.charAt(j));
                } 
                else {
                    isPal[i][j] = (s.charAt(i) == s.charAt(j)) 
                                  && isPal[i + 1][j - 1];
                }
            }
        }

        // Step 2: DP for minimum cuts
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            if (isPal[0][i]) {
                dp[i] = 0;
            } 
            else {
                dp[i] = Integer.MAX_VALUE;

                for (int j = 0; j < i; j++) {
                    if (isPal[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int result = minCut(s);

        System.out.println(result);
    }
}