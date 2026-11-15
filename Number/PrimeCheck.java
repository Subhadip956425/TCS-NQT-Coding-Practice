package Number;

public class PrimeCheck {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;  // 0 and 1 are not prime
        if (n == 2) return true;   // 2 is prime

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;  // divisible by some number
        }

        return true;
    }

    public static void main(String[] args) {
        int number = 29; // You can change this value

        if (isPrime(number)) {
            System.out.println(number + " is a Prime Number.");
        } else {
            System.out.println(number + " is NOT a Prime Number.");
        }
    }
}

