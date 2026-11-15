package TCSNQT;

import java.util.*;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;          // last element in nums1
        int j = n - 1;          // last element in nums2
        int k = m + n - 1;      // last position in nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sc.nextInt();
        }

        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        // Function call
        merge(nums1, m, nums2, n);

        // Output
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}