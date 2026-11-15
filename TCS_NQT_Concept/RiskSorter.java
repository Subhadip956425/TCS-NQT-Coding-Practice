package TCS_NQT_Concept;

import java.util.Scanner;

public class RiskSorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // Input: Number of items
        int[] arr = new int[n];
        
        // Input: n integers separated by newline
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        

        sortRiskLevels(arr);

        // Output: Print sorted array
        for (int risk : arr) {
            System.out.print(risk + " ");
        }
    }

    public static void sortRiskLevels(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            
                default:
                    break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
