package TCSNQT;

import java.util.*;

public class PrimeDigitSum {

    public static boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i=2; i*i<=num; i++) { /// ////////////////////////
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumDigit(int num) {
        int sum = 0;

        while(num > 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i=n; i<=m; i++) {
            if (isPrime(i) && isPrime(sumDigit(i))) {
                System.out.print(i + " ");
            }
        }
    }
}