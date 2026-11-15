package String;

import java.util.Scanner;

public class OddEvenSwap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        swapAdjacent(arr);

        System.out.println("Array after swapping adjacent elements:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    public static void swapAdjacent(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
