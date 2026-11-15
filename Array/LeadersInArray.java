package Array;

import java.util.*;

public class LeadersInArray {
    public static List<Integer> findLeaders(int[] nums) {
        List<Integer> leaders = new ArrayList<>();

        int n = nums.length;
        int maxRight = nums[n - 1]; // rightmost element is always a leader
        leaders.add(maxRight);

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > maxRight) {
                leaders.add(nums[i]);
                maxRight = nums[i];
            }
        }

        // Reverse to maintain original order
        Collections.reverse(leaders);

        return leaders;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5, 3, 1, 2};
        int[] nums2 = {-3, 4, 5, 1, 4, -5};

        System.out.println(findLeaders(nums1)); // [5, 3, 2]
        System.out.println(findLeaders(nums2)); // [5, 1, 4, -5]
    }
}
