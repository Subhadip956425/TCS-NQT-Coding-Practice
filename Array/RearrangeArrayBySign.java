package Array;

import java.util.Arrays;

public class RearrangeArrayBySign {

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int posIndex = 0;  // even positions for positive numbers
        int negIndex = 1;  // odd positions for negative numbers

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 5, -1, -3, -4};
        int[] nums2 = {1, -1, -3, -4, 2, 3};

        System.out.println(Arrays.toString(rearrangeArray(nums1))); // [2, -1, 4, -3, 5, -4]
        System.out.println(Arrays.toString(rearrangeArray(nums2))); // [1, -1, 2, -3, 3, -4]
    }
}
