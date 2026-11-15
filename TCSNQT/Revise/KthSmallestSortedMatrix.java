/// ///////////////////////////////
/// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/


package TCSNQT.Revise;

import java.util.Scanner;

class KthSmallestSortedMatrix {

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Count elements <= mid
    public static int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int row = n - 1, col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        int result = kthSmallest(matrix, k);
        System.out.println(result);

        sc.close();
    }
}