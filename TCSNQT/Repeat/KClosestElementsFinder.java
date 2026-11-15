///////////////////////////////////////////////
/// https://leetcode.com/problems/find-k-closest-elements/description/



package TCSNQT.Repeat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class KClosestElementsFinder {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;   /////////////////

        while (low < high) {  /// /////////////
            int mid = low + (high - low) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {    /// /////////////
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {  /// ///////
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int x = sc.nextInt();

        List<Integer> result = findClosestElements(arr, k, x);

        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}