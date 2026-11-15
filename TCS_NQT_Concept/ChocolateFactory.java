package TCS_NQT_Concept;

import java.util.Scanner;

public class ChocolateFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read number of elements
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Step 2: Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = 0;

        for(int i=0; i<n; i++) {
            if(arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        while(index < n) {
            arr[index++] = 0;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
