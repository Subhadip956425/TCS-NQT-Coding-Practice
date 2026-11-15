// https://leetcode.com/problems/third-maximum-number/description/

package TCSNQT;

import java.util.*;

public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int num : nums) {
            long n = num;

            // Skip duplicates
            if ((first != null && n == first) ||
                (second != null && n == second) ||
                (third != null && n == third)) {
                continue;
            }

            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }

        return (third == null) ? first.intValue() : third.intValue();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Function call
        int result = thirdMax(nums);

        // Output
        System.out.println(result);

        sc.close();
    }
}