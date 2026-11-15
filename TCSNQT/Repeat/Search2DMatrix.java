/// ////////////////////////////////
/// https://leetcode.com/problems/search-a-2d-matrix/description/


package TCSNQT.Repeat;

import java.util.Scanner;

class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m * n - 1;   /////////////////////////

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / n;  /////////
            int col = mid % n;   ////////////////////

            int val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();

        boolean result = searchMatrix(matrix, target);
        System.out.println(result);

        sc.close();
    }
}