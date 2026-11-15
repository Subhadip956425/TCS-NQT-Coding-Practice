package Array;

import java.util.*;

public class MergeSortedArrays_WithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 8, 10};
        int[] arr2 = {2, 3, 9};

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
    }

    private static void merge(int[] arr1, int[] arr2, int m, int n) {
        int len = m+n;
        int gap = (int) Math.ceil((double) (m+n)/2);

        while (gap > 0) {
            int left = 0;
            int right = left+gap;

            while (right < len) {
                if(left < m && right >= m) {
                    swapIfGreater(arr1, arr2, left, right-m);
                } else if (left >= m) {
                    swapIfGreater(arr2, arr2, left-m, right-m);
                } else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (int) Math.ceil((double) gap / 2);
        }
    }

    private static void swapIfGreater(int[] arr1, int[] arr2, int left, int right) {
        if(arr1[left] > arr2[right]) {
            int temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
        }
    }
}