package Number;

import java.util.Scanner;

public class Aramstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if(isArmstrong(num)) {
            System.out.println(num + " is armstrong");
        } else {
            System.out.println(num + "is not armstrong");
        }
    }

    public static boolean isArmstrong(int number) {

        int original = number;
        int sum = 0;
        int no_of_digits = String.valueOf(number).length();

        while(number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, no_of_digits);
            number /= 10;
        }

        return sum == original;
    }
}
