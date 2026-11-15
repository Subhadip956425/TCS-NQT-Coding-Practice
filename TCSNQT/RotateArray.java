// https://leetcode.com/problems/rotate-array/description/

package TCSNQT;

import java.util.*;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n; // handle k > n   //////////////////

        // Step 1: Reverse whole array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements     //////
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        // Function call
        rotate(nums, k);

        // Output
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}