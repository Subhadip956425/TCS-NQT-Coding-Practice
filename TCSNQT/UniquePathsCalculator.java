/// ////////////////////////
/// https://leetcode.com/problems/unique-paths/description/


package TCSNQT;

import java.util.*;

class UniquePathsCalculator {

    public static int uniquePaths(int m, int n) {
        int N = m + n - 2;      // total moves
        int r = Math.min(m - 1, n - 1); // choose smaller for efficiency

        long result = 1;

        for (int i = 1; i <= r; i++) {
            result = result * (N - r + i) / i;    //////////////
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(uniquePaths(m, n));

        sc.close();
    }
}