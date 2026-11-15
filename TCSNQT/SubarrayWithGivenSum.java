////////////////////////////////////////////////////////////////

package TCSNQT;

import java.util.*;

public class SubarrayWithGivenSum {

    public static void findSubarrays(int[] arr, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int prefixSum = 0;

        map.put(0, new ArrayList<>()); /////////////
        map.get(0).add(-1); /////////////////

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];
            int remaining = prefixSum - target;

            if (map.containsKey(remaining)) {
                for (int start : map.get(remaining)) {   //////////////
                    printSubarray(arr, start + 1, i);
                }
            }

            map.putIfAbsent(prefixSum, new ArrayList<>());
            map.get(prefixSum).add(i);
        }
    }

    public static void printSubarray(int[] arr, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // size of array
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        findSubarrays(arr, target);
    }
}