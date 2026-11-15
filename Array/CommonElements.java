package Array;

import java.util.HashSet;
import java.util.Set;

public class CommonElements {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 8};
        int[] arr2 = {6, 2, 9, 0, 7, 3};

        findCommonEelements(arr1, arr2);
    }

    static void findCommonEelements(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        for(int n : arr1) {
            set.add(n);
        }

        for (int n : arr2) {
            if(set.contains(n)) {
                common.add(n);
            }
        }

        System.out.println("Duplicates are: ");
        for(int num : common) {
            System.out.print(num + " ");
        }
    } 
}
