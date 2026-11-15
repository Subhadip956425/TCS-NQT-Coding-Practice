package Number;

import java.util.Scanner;

public class Digit_count {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int digit = (int) Math.log10(Math.abs(number)) + 1;
        System.out.println("Number of digit is " + digit);
    }
}