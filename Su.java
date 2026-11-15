import java.util.Scanner;
import java.util.Stack;

class BasicCalculator {

    public static void main(String[] args) {

        System.out.println(power(2, 10));  // 1024
        System.out.println(power(3, 5));   // 243
        System.out.println(power(5, 0));   // 1
        System.out.println(power(2, -2));
    }

    public static double power(double base, int exp) {

        double result = 1;

        while(exp > 0) {
            if(exp % 2 == 1) {
                result *= base;
            }
            base *=base;
            exp >>= 1;
        }

        return result;
    }
}
