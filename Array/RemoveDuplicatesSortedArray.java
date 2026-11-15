package Array;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(nums);
        System.out.println("Unique count = " + length);
        System.out.println("Modified array = " + Arrays.toString(Arrays.copyOf(nums, length)));
        // Output: Unique count = 4, Modified array = [1, 2, 3, 4]
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // pointer for unique position
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { 
                i++; 
                nums[i] = nums[j]; // place next unique element
            }
        }
        return i + 1; // length of unique elements
    }
}
