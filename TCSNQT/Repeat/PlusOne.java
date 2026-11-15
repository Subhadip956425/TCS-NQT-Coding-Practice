// https://leetcode.com/problems/plus-one/description/

package TCSNQT.Repeat;

import java.util.Scanner;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) { /// ///
                digits[i]++;
                return digits;
            }
            digits[i] = 0;  ////////
        }

        int[] result = new int[n + 1];  //////////////////
        result[0] = 1;         //////////////////

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] digits = new int[n];

        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        // Function call
        int[] result = plusOne(digits);

        // Output
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}