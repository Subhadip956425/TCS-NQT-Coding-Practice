package Number;

public class DivisorsOptimized {
    public static void main(String[] args) {
        int n = 36;
        printDivisors(n);
    }

    public static void printDivisors(int n) {
        System.out.print("Divisors of " + n + ": ");
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != n / i) { // Avoid duplicate for perfect squares
                    System.out.print(n / i + " ");
                }
            }
        }
    }
}
