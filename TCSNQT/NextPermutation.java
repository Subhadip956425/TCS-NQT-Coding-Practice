// Need to repeat

package TCSNQT;

import java.util.*;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n - 2;

        // Step 1: Find first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If found, find just greater element
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap
            swap(nums, i, j); ////////
        }

        // Step 4: Reverse remaining
        reverse(nums, i + 1, n - 1);  //////////////
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
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

        // Function call
        nextPermutation(nums);

        // Output
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}