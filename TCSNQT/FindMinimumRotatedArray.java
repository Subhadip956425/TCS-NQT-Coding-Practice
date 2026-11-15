package TCSNQT;

import java.util.*;

class FindMinimumRotatedArray {

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;   // min is in right part
            } else {
                high = mid;      // min is in left part (including mid)
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findMin(nums);
        System.out.println(result);

        sc.close();
    }
}