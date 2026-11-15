// https://leetcode.com/problems/split-linked-list-in-parts/



package TCSNQT;

import java.util.*;

class SplitArrayIntoParts {

    public static List<List<Integer>> splitArray(int[] arr, int k) {

        List<List<Integer>> result = new ArrayList<>();

        int n = arr.length;
        int base = n / k;
        int extra = n % k;

        int index = 0;

        for (int i = 0; i < k; i++) {

            int size = base + (extra > 0 ? 1 : 0);
            if (extra > 0) extra--;

            List<Integer> part = new ArrayList<>();

            for (int j = 0; j < size && index < n; j++) { ////////
                part.add(arr[index++]);
            }

            result.add(part);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        List<List<Integer>> parts = splitArray(arr, k);

        for (List<Integer> part : parts) {
            for (int num : part) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}