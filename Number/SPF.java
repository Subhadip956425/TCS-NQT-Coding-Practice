package Number;

public class SPF {

    public static void main(String[] args) {
        int n = 30;
        int[] spf = computeSPF(n);

        System.out.println("Smallest Prime Factors up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " → " + spf[i]);
        }

        // Example: Factorize a number using SPF
        System.out.println("\nPrime factors of 84:");
        factorize(84, spf);
    }

    // Compute SPF for all numbers up to n
    private static int[] computeSPF(int n) {
        int[] spf = new int[n + 1];

        // Step 1: Initialize spf[i] = i
        for (int i = 2; i <= n; i++) {
            spf[i] = i;
        }

        // Step 2: Mark SPF for even numbers as 2
        for (int i = 4; i <= n; i += 2) {
            spf[i] = 2;
        }

        // Step 3: Sieve process for odd numbers
        for (int i = 3; i * i <= n; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) { // not marked yet
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }

    // Factorize a number using precomputed SPF
    private static void factorize(int x, int[] spf) {
        while (x != 1) {
            System.out.print(spf[x] + " ");
            x /= spf[x];
        }
    }
}
