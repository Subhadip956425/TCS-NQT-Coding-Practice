// Need to repeat
// https://leetcode.com/problems/climbing-stairs/description/

package TCSNQT.Repeat;

import java.util.Scanner;

class ClimbingStairs {

    public static int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev2 = 1; // f(n-2)
        int prev1 = 2; // f(n-1)

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(climbStairs(n));

        sc.close();
    }
}