package Number;

public class PowerExponentiation {
    public static void main(String[] args) {
        System.out.println(power(2, 10)); // Output: 1024
        System.out.println(power(3, 5));  // Output: 243
        System.out.println(power(5, 0));  // Output: 1
    }

    public static long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) { // if exp is odd
                result *= base;
            }
            base *= base; // square the base
            exp >>= 1;    // divide exponent by 2
        }
        return result;
    }
}
