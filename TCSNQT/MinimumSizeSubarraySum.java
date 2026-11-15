/// ///////////////////////////////////////////////
///
/// https://leetcode.com/problems/minimum-size-subarray-sum/description/



package TCSNQT;

import java.util.*;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;   ///////////

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Shrink window while condition is satisfied
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int target = sc.nextInt();
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Function call
        int result = minSubArrayLen(target, nums);

        // Output
        System.out.println(result);

        sc.close();
    }
}