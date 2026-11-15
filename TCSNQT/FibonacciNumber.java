package TCSNQT;

import java.util.*;

class FibonacciNumber {

    public static int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fib(n));

        sc.close();
    }
}