package Array;

import java.util.*;

// 🧠 Approach 1: Mathematical (Optimal, O(n) time & O(1) space)
//
//Let:
//
//S = sum of first n natural numbers = n(n + 1)/2
//
//P = sum of squares of first n natural numbers = n(n + 1)(2n + 1)/6
//
//S1 = sum of array elements
//
//P1 = sum of squares of array elements
//
//If
//x = missing number,
//y = repeating number
//
//Then:
//
//S1 - S = y - x        → (eq 1)
//P1 - P = y² - x² = (y - x)(y + x) → (eq 2)
//
//
//From (1) & (2):
//
//(y + x) = (P1 - P) / (S1 - S)
//=> y = ((S1 - S) + (y + x)) / 2
//=> x = y - (S1 - S)

public class RepeatingAndMissingNumber {
    public static int[] findTwoElements(int[] nums) {
        int n = nums.length;
        long sumN = (long) n * (n + 1) / 2;
        long sumNSq = (long) n * (n + 1) * (2L * n + 1) / 6;

        long sumArr = 0, sumArrSq = 0;
        for (int num : nums) {
            sumArr += num;
            sumArrSq += (long) num * num;
        }

        long diff1 = sumArr - sumN;           // y - x
        long diff2 = sumArrSq - sumNSq;       // y² - x² = (y - x)(y + x)

        long sumYX = diff2 / diff1;           // y + x

        long y = (diff1 + sumYX) / 2;
        long x = y - diff1;

        return new int[]{(int) y, (int) x};   // {repeating, missing}
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 3};

        int[] result = findTwoElements(nums);
        System.out.println("Repeating Number: " + result[0]);
        System.out.println("Missing Number: " + result[1]);
    }
}
