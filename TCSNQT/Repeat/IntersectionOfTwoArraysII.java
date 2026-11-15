// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

// Remove the entry with key "Apple"
//String removedValue = map.remove("Apple");
//        System.out.println("Removed Value: " + removedValue);

// Remove the element "Banana"
//boolean wasRemoved = set.remove("Banana");

package TCSNQT.Repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store frequency of nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Check in nums2
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {   /// /////////
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

//        Instead of convert print directly
//        for (int num : result) {
//    System.out.print(num + " ");   -> 2 2
//}

//        System.out.println(result);   ->  [2, 2]

        // Convert list to array
        int[] res = new int[result.size()];  ///////////////////
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        // Function call
        int[] result = intersect(nums1, nums2);

        // Output
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}