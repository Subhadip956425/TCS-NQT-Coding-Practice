// Optimized approach
// https://leetcode.com/problems/find-peak-element/description/

package TCSNQT;

import java.util.*;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Increasing → peak on right
                left = mid + 1;
            } else {
                // Decreasing → peak on left (including mid)
                right = mid;
            }
        }

        return left; // or right (both same)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findPeakElement(nums);

        System.out.println(result);

        sc.close();
    }
}