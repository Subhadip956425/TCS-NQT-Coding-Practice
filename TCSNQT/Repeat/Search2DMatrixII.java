package TCSNQT.Repeat;

import java.util.Scanner;

class Search2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;  /////////////
        int n = matrix[0].length;  /////////////

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {   /////////////
            int val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val > target) {
                col--; // move left
            } else {
                row++; // move down
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