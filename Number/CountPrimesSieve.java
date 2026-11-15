package Number;

public class CountPrimesSieve {

    public static int countPrimesSieve(int n) {
        if (n < 2) return 0;

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n1 = 6;
        int n2 = 10;
        int n3 = 20;

        System.out.println("Number of primes till " + n1 + " = " + countPrimesSieve(n1)); // 3
        System.out.println("Number of primes till " + n2 + " = " + countPrimesSieve(n2)); // 4
        System.out.println("Number of primes till " + n3 + " = " + countPrimesSieve(n3)); // 8
    }
}
