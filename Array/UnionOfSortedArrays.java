package Array;

import java.util.*;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        List<Integer> union = findUnion(arr1, arr2);
        System.out.println(union); // [1, 2, 3, 4, 5, 6, 7]
    }

    private static List<Integer> findUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        List<Integer> union = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                addToUnion(union, arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {
                addToUnion(union, arr2[j]);
                j++;
            } else {
                addToUnion(union, arr1[i]); // equal elements → add one
                i++;
                j++;
            }
        }

        // Add remaining elements
        while (i < arr1.length) addToUnion(union, arr1[i++]);
        while (j < arr2.length) addToUnion(union, arr2[j++]);

        return union;
    }

    private static void addToUnion(List<Integer> union, int val) {
        // Avoid duplicates in the result
        if (union.isEmpty() || union.get(union.size() - 1) != val) {
            union.add(val);
        }
    }
}
