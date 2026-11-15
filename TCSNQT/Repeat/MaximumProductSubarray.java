/// ////////////////////////////////////////////////
///
/// https://leetcode.com/problems/maximum-product-subarray/description/



package TCSNQT.Repeat;

import java.util.Scanner;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // If negative, swap max and min
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);

            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Function call
        int result = maxProduct(nums);

        // Output
        System.out.println(result);

        sc.close();
    }
}