package Array;

import java.util.Arrays;

public class LeftRotateByK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        leftRotate(arr, k);
        System.out.println(Arrays.toString(arr)); // Output: [3, 4, 5, 6, 7, 1, 2]
    }

    private static void leftRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle k > n

        reverse(arr, 0, k - 1);   // Step 1: Reverse first k elements
        reverse(arr, k, n - 1);   // Step 2: Reverse remaining elements
        reverse(arr, 0, n - 1);   // Step 3: Reverse entire array
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
