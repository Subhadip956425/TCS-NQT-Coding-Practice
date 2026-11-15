package Array;

import java.util.*;

public class LongestSubarraySumK {
    public static int longestSubarrayWithSumK(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (prefixMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixMap.get(sum - k));
            }

            // store first occurrence of this sum
            prefixMap.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int result = longestSubarrayWithSumK(nums, k);
        System.out.println("Longest Subarray Length with Sum " + k + ": " + result);
    }
}
