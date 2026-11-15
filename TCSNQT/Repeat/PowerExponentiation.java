///  ////////////////////////////


package TCSNQT.Repeat;

public class PowerExponentiation {

    public static void main(String[] args) {
        System.out.println(power(2, 10));  // 1024
        System.out.println(power(3, 5));   // 243
        System.out.println(power(5, 0));   // 1
        System.out.println(power(2, -2));  // 0.25
    }

    public static double power(double base, int exp) {

        long n = exp; // handle overflow

        if (n < 0) {
            base = 1 / base;
            n = -n;
        }

        double result = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                result *= base;
            }
            base *= base;
            n >>= 1;
        }

        return result;
    }
}