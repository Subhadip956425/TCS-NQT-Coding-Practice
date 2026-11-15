package Array;

import java.util.*;

public class LongestSubarraySumK_Positive {
    public static int longestSubarrayWithSumK(int[] nums, int k) {
        int left = 0, right = 0;
        int sum = 0, maxLen = 0;

        while (right < nums.length) {
            sum += nums[right];

            // Shrink window if sum > k
            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7, 5};
        int k = 12;
        System.out.println("Longest Subarray Length with Sum " + k + ": " + longestSubarrayWithSumK(nums, k));
    }
}
