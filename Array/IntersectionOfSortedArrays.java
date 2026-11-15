package Array;

import java.util.*;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 3, 5, 6};

        List<Integer> result = intersection(arr1, arr2);
        System.out.println("Intersection: " + result);
    }

    private static List<Integer> intersection(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                // Avoid duplicates in the result
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
                j++;
            } 
            else if (arr1[i] < arr2[j]) {
                i++;
            } 
            else {
                j++;
            }
        }

        return result;
    }
}
