package Number;

import java.util.*;

public class PrimeFactorizationArray {

    public static Set<Integer> primeFactors(int n) {
        Set<Integer> factors = new LinkedHashSet<>();

        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 2) factors.add(n);

        return factors;
    }

    public static void main(String[] args) {
        int[] arr = {12, 15, 7, 20};

        for (int num : arr) {
            System.out.println("Distinct prime factors of " + num + ": " + primeFactors(num));
        }
    }
}
