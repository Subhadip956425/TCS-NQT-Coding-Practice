/// /////////////////////////////
/// https://leetcode.com/problems/find-the-most-competitive-subsequence/description/



package TCSNQT.Revise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class MostCompetitiveSubsequence {

    public static int[] mostCompetitive(int[] nums, int k) {

        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();  /////////

        for (int i = 0; i < n; i++) {

            // Remove larger elements if possible
            while (!stack.isEmpty() && 
                   stack.peekLast() > nums[i] && 
                   stack.size() + (n - i) > k) {   /////////// (n - i) → how many elements are still left (including current)

                stack.pollLast();
            }

            // Add element if size < k
            if (stack.size() < k) {
                stack.offerLast(nums[i]);
            }
        }

        // Convert to array
        int[] result = new int[k];
        int i = 0;

        for (int num : stack) {
            result[i++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] result = mostCompetitive(nums, k);

        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}