package Number;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if(isPalindrome(num)) {
            System.out.println(num + " is Palindrome");
        } else {
            System.out.println(num + " is not Palindrome");
        }
    }

    public static boolean isPalindrome(int number) {

        int original = number;
        int rev = 0;

        while(number > 0) {
            int digit = number % 10;
            rev = rev * 10 + digit;
            number /= 10;
        }

        return rev == original;
    }
}
