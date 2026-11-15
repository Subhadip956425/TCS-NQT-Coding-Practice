/// ////////////////////////////////////////////


package String;

import java.util.Scanner;

public class BoundarySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int boundarySum = calculateBoundarySum(matrix, rows, cols);
        System.out.println("Sum of boundary elements: " + boundarySum);

        sc.close();
    }

    public static int calculateBoundarySum(int[][] matrix, int rows, int cols) {
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Check if element is on boundary
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }
}
